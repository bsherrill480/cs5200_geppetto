package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.PacToCandidateDao;
import cs5200.geppetto.model.Candidate;
import cs5200.geppetto.model.PacToCandidateDonation;

/**
 * @author joshuaveden
 */
@Service
public class JdbcPacToCandidateDao extends MyJdbcDaoSupport implements PacToCandidateDao {

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToCandidateDonation create(PacToCandidateDonation donation) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<PacToCandidateDonation> getDonationsByCandidate(Candidate candidate)
      throws SQLException {
    List<PacToCandidateDonation> donationsToCandidate = new ArrayList<PacToCandidateDonation>();
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
  public PacToCandidateDonation updateDonationDate(PacToCandidateDonation donation, Date date) {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public PacToCandidateDonation deleteDonation(PacToCandidateDonation donation) {
    // TODO Auto-generated method stub
    return null;
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
    String resCID = results.getString("CID");
    String resPACID = results.getString("PACID");
    Float resAmount = results.getFloat("Amount");
    Date resDate = results.getDate("Date");
    String resRealCode = results.getString("RealCode");
    String resType = results.getString("Type");
    String resDI = results.getString("DI");
    String resFECCandID = results.getString("FECCandID");
    return new PacToCandidateDonation(resCycle, resFECRecNo, resCID, resPACID, resAmount, resDate,
        resRealCode, resType, resDI, resFECCandID);
  }
}
