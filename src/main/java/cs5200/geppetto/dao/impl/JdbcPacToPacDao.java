package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.PacToPacDao;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.PacToPacDonation;

/**
 * @author joshuaveden
 */
@Service
public class JdbcPacToPacDao extends MyJdbcDaoSupport implements PacToPacDao {

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToPacDonation create(PacToPacDonation donation) throws SQLException {
    String insertDonation = "INSERT INTO"
        + " PacToPac16(Cycle,FECRecNo,FilerID,DonorCmte,ContribLendTrans,City,State,Zip,FECOccEmp,PrimCode,Date,Amount,RecipID,Party,OtherID,RecipCode,RecipPrimcode,Amend,Report,PG,Microfilm,Type,Realcode,Source)"
        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    // generate 19 random numbers between 0-9 to build FECRecNo
    // WARN: potential for collisions
    String FECRecNo = randNumId(10, 19);
    try {
      connection = getConnection();
      insertStmt = connection.prepareStatement(insertDonation);
      insertStmt.setString(1, donation.getCycle());
      insertStmt.setString(2, FECRecNo);
      insertStmt.setString(3, donation.getFilerId());
      insertStmt.setString(4, donation.getDonorCmte());
      insertStmt.setString(5, donation.getContribLendTrans());
      insertStmt.setString(6, donation.getCity());
      insertStmt.setString(7, donation.getState());
      insertStmt.setString(8, donation.getZip());
      insertStmt.setString(9, donation.getFecOccEmp());
      insertStmt.setString(10, donation.getPrimCode());
      insertStmt.setDate(11, new java.sql.Date(donation.getDate().getTime()));
      insertStmt.setFloat(12, donation.getAmount());
      insertStmt.setString(13, donation.getRecipId());
      insertStmt.setString(14, donation.getParty());
      insertStmt.setString(15, donation.getOtherId());
      insertStmt.setString(16, donation.getRecipCode());
      insertStmt.setString(17, donation.getRecipPrimCode());
      insertStmt.setString(18, donation.getAmend());
      insertStmt.setString(19, donation.getReport());
      insertStmt.setString(20, donation.getPg());
      insertStmt.setString(21, donation.getMicrofilm());
      insertStmt.setString(22, donation.getType());
      insertStmt.setString(23, donation.getRealCode());
      insertStmt.setString(24, donation.getSource());
      insertStmt.executeUpdate();

      donation.setFecRecNo(FECRecNo);
      return donation;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
      if (resultKey != null) {
        resultKey.close();
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<PacToPacDonation> getDonationsToPac(Committees pac) throws SQLException {
    List<PacToPacDonation> donationsToPac = new ArrayList<PacToPacDonation>();
    String getDonationsToPac = "SELECT * FROM PacToPac16 WHERE RecipID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getDonationsToPac);
      selectStmt.setString(1, pac.getCmteId());
      results = selectStmt.executeQuery();
      while (results.next()) {
        donationsToPac.add(parseDonation(results));
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return donationsToPac;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToPacDonation updateDonationDate(PacToPacDonation donation, Date date)
      throws SQLException {
    String updateDate = "UPDATE PacToPac16 SET Date=? WHERE FECRecNo=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = getConnection();
      updateStmt = connection.prepareStatement(updateDate);
      updateStmt.setDate(1, new java.sql.Date(date.getTime()));
      updateStmt.setString(2, donation.getFecRecNo());
      updateStmt.executeUpdate();

      // Update the cycle param before returning to the caller.
      donation.setDate(date);
      return donation;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToPacDonation deleteDonation(PacToPacDonation donation) throws SQLException {
    String deleteByFECRecNo = "DELETE FROM PacToPac16 WHERE FECRecNo=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = getConnection();
      deleteStmt = connection.prepareStatement(deleteByFECRecNo);
      deleteStmt.setString(1, donation.getFecRecNo());
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException(
            "No records available to delete for FECRecNo=" + donation.getFecRecNo());
      }
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }

  /**
   * Parses donation from a SQL Result Set
   *
   * @param results result set
   * @return donation
   * @throws SQLException
   */
  private PacToPacDonation parseDonation(ResultSet results) throws SQLException {
    String resCycle = results.getString("Cycle");
    String resFECRecNo = results.getString("FECRecNo");
    String resFilerId = results.getString("FilerID");
    String resDonorCmte = results.getString("DonorCmte");
    String resContribLendTrans = results.getString("ContribLendTrans");
    String resCity = results.getString("City");
    String resState = results.getString("State");
    String resZip = results.getString("Zip");
    String resFECOccEmp = results.getString("FECOccEmp");
    String resPrimCode = results.getString("PrimCode");
    Date resDate = results.getDate("Date");
    Float resAmount = results.getFloat("Amount");
    String resRecipId = results.getString("RecipId");
    String resParty = results.getString("Party");
    String resOtherId = results.getString("OtherID");
    String resRecipCode = results.getString("RecipCode");
    String resRecipPrimcode = results.getString("RecipPrimcode");
    String resAmend = results.getString("Amend");
    String resReport = results.getString("Report");
    String resPG = results.getString("PG");
    String resMicrofilm = results.getString("Microfilm");
    String resType = results.getString("Type");
    String resRealcode = results.getString("Realcode");
    String resSource = results.getString("Source");
    return new PacToPacDonation(resCycle, resFECRecNo, resFilerId, resDonorCmte,
        resContribLendTrans, resCity, resState, resZip, resFECOccEmp, resPrimCode, resDate,
        resAmount, resRecipId, resParty, resOtherId, resRecipCode, resRecipPrimcode, resAmend,
        resReport, resPG, resMicrofilm, resType, resRealcode, resSource);
  }
}
