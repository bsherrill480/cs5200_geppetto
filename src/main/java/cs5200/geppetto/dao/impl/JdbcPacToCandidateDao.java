package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.CandidateDao;
import cs5200.geppetto.dao.CommitteesDao;
import cs5200.geppetto.dao.PacToCandidateDao;
import cs5200.geppetto.model.Candidate;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.PacToCandidateDonation;

/**
 * @author joshuaveden
 */
@Service
public class JdbcPacToCandidateDao extends MyJdbcDaoSupport implements PacToCandidateDao {

  @Autowired
  private CandidateDao candidateDao;

  @Autowired
  private CommitteesDao committeeDao;

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToCandidateDonation create(PacToCandidateDonation donation) throws SQLException {
    String insertDonation = "INSERT INTO"
        + " PACsToCand16(Cycle,FECRecNo,PACID,CID,Amount,Date,RealCode,Type,DI,FECCandId)"
        + " VALUES(?,?,?,?,?,?,?,?,?,?);";
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
      insertStmt.setString(3, donation.getCommittee().getCmteId());
      insertStmt.setString(4, donation.getCandidate().getCid());
      insertStmt.setFloat(5, donation.getAmount());
      insertStmt.setDate(6, new java.sql.Date(donation.getDate().getTime()));
      insertStmt.setString(7, donation.getRealCode());
      insertStmt.setString(8, donation.getType());
      insertStmt.setString(9, donation.getDi());
      insertStmt.setString(10, donation.getFecCandId());
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
  public List<PacToCandidateDonation> getDonationsByCandidateName(String candidateName)
      throws SQLException {
    List<PacToCandidateDonation> donationsToCandidate = new ArrayList<PacToCandidateDonation>();
    String getDonationsToCandidate =
        "SELECT * FROM PACsToCand16 AS ptc16 INNER JOIN CandsCRP16 AS c16 ON ptc16.CID=c16.CID WHERE c16.FirstLastP LIKE '%?%';";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getDonationsToCandidate);
      selectStmt.setString(1, candidateName);
      results = selectStmt.executeQuery();
      while (results.next()) {
        donationsToCandidate.add(parseDonation(results));
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
    return donationsToCandidate;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<PacToCandidateDonation> getDonationsFromCommittee(Committees committee)
      throws SQLException {
    List<PacToCandidateDonation> donations = new ArrayList<PacToCandidateDonation>();
    String getDonationsFromCommittee = "SELECT * FROM PACsToCand16 WHERE PACID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getDonationsFromCommittee);
      selectStmt.setString(1, committee.getCmteId());
      results = selectStmt.executeQuery();
      while (results.next()) {
        donations.add(parseDonation(results));
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
    return donations;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<PacToCandidateDonation> getDonationsToCandidate(Candidate candidate)
      throws SQLException {
    List<PacToCandidateDonation> donations = new ArrayList<PacToCandidateDonation>();
    String getDonationsToCandidate = "SELECT * FROM PACsToCand16 WHERE CID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getDonationsToCandidate);
      selectStmt.setString(1, candidate.getCid());
      results = selectStmt.executeQuery();
      while (results.next()) {
        donations.add(parseDonation(results));
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
    return donations;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToCandidateDonation updateDonationDate(PacToCandidateDonation donation, Date date)
      throws SQLException {
    String updateDate = "UPDATE PACsToCand16 SET Date=? WHERE FECRecNo=?;";
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
  public PacToCandidateDonation deleteDonation(String fecRecNo) throws SQLException {
    String deleteByFECCandId = "DELETE FROM PACsToCand16 WHERE FECRecNo=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = getConnection();
      deleteStmt = connection.prepareStatement(deleteByFECCandId);
      deleteStmt.setString(1, fecRecNo);
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("No records available to delete for FECRecNo=" + fecRecNo);
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
  private PacToCandidateDonation parseDonation(ResultSet results) throws SQLException {
    String resCycle = results.getString("Cycle");
    String resFECRecNo = results.getString("FECRecNo");
    String resPACID = results.getString("PACID");
    Float resAmount = results.getFloat("Amount");
    Date resDate = results.getDate("Date");
    String resRealCode = results.getString("RealCode");
    String resType = results.getString("Type");
    String resDI = results.getString("DI");
    String resFECCandID = results.getString("FECCandID");
    return new PacToCandidateDonation(resCycle, resFECRecNo,
        this.candidateDao.getCandidateByFECCandId(resFECCandID),
        this.committeeDao.getCommitteeByCmteId(resPACID), resAmount, resDate, resRealCode, resType,
        resDI, resFECCandID);
  }
}
