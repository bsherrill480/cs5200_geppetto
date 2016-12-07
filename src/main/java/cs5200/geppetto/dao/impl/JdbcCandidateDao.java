package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.CandidateDao;
import cs5200.geppetto.dao.CommitteesDao;
import cs5200.geppetto.model.Candidate;
import cs5200.geppetto.model.campaignFinance.CandReceivingFromPac;
import cs5200.geppetto.model.campaignFinance.CandReceivingFromPacs;

/**
 * @author joshuaveden
 */
@Service
public class JdbcCandidateDao extends MyJdbcDaoSupport implements CandidateDao {


  @Autowired
  CommitteesDao committeesDao;

  /**
   * {@inheritDoc}
   */
  @Override
  public Candidate create(Candidate candidate) throws SQLException {
    String id = UUID.randomUUID().toString().substring(0, 10);
    id = id.toUpperCase().replaceAll("-", "");
    String cid = UUID.randomUUID().toString().substring(0, 10);
    cid = cid.toUpperCase().replaceAll("-", "");
    String insertCandidate =
        "INSERT INTO CandsCRP16(Cycle,FECCandID,CID,FirstLastP,Party,DistIDRunFor,DistIDCurr,NoPacs) VALUES(?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = getConnection();
      insertStmt = connection.prepareStatement(insertCandidate);
      insertStmt.setString(1, candidate.getCycle());
      insertStmt.setString(2, id);
      insertStmt.setString(3, cid);
      insertStmt.setString(4, candidate.getFirstLastP());
      insertStmt.setString(5, candidate.getParty());
      insertStmt.setString(6, candidate.getDistIdRunFor());
      insertStmt.setString(7, candidate.getDistIdCurr());
      insertStmt.setString(8, candidate.getNoPacs());
      insertStmt.executeUpdate();
      candidate.setFecCandId(id);
      candidate.setCid(cid);
      return candidate;
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
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Candidate getCandidateByFECCandId(String fecCandId) throws SQLException {
    String getCandidateByFECCandId = "SELECT * FROM CandsCRP16 WHERE FECCandID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCandidateByFECCandId);
      selectStmt.setString(1, fecCandId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return parseCandidate(results);
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
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Candidate getCandidateByCID(String CID) throws SQLException {
    String getCandidateByFECCandId = "SELECT * FROM CandsCRP16 WHERE CID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCandidateByFECCandId);
      selectStmt.setString(1, CID);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return parseCandidate(results);
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
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Candidate> getCandidatesByCycle(String year) throws SQLException {
    List<Candidate> candidates = new ArrayList<Candidate>();
    String getCandidatesByCycle =
        "SELECT * FROM CandsCRP16 WHERE Cycle=? AND FirstLastP<>' ' ORDER BY FirstLastP ASC;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCandidatesByCycle);
      selectStmt.setString(1, year);
      results = selectStmt.executeQuery();
      while (results.next()) {
        candidates.add(parseCandidate(results));
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
    return candidates;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Candidate getCandidateByFirstLastP(String firstLastP) throws SQLException {
    String getCandidateByFirstLastP = "SELECT * FROM CandsCRP16 WHERE FirstLastP=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCandidateByFirstLastP);
      selectStmt.setString(1, firstLastP);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return parseCandidate(results);
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
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Candidate updateCycle(Candidate candidate, String cycle) throws SQLException {
    String updateCycle = "UPDATE CandsCRP16 SET Cycle=? WHERE FECCandId=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = getConnection();
      updateStmt = connection.prepareStatement(updateCycle);
      updateStmt.setString(1, cycle);
      updateStmt.setString(2, candidate.getFecCandId());
      updateStmt.executeUpdate();

      // Update the cycle param before returning to the caller.
      candidate.setCycle(cycle);
      return candidate;
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
  public Candidate delete(String fecCandId) throws SQLException {
    String deleteByFECCandId = "DELETE FROM CandsCRP16 WHERE FECCandID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = getConnection();
      deleteStmt = connection.prepareStatement(deleteByFECCandId);
      deleteStmt.setString(1, fecCandId);
      int affectedRows = deleteStmt.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("No records available to delete for FECCandId=" + fecCandId);
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
   * Parses candidate from a SQL Result Set
   *
   * @param results result set
   * @return candidate
   * @throws SQLException
   */
  private Candidate parseCandidate(ResultSet results) throws SQLException {
    String resCycle = results.getString("Cycle");
    String resFECCandId = results.getString("FECCandID");
    String resCID = results.getString("CID");
    String resFirstLastP = results.getString("FirstLastP");
    String resParty = results.getString("Party");
    String resDistIdRunFor = results.getString("DistIDRunFor");
    String resDistIdCurr = results.getString("DistIDCurr");
    String resCurrCand = results.getString("CurrCand");
    String resCycleCand = results.getString("CycleCand");
    String resCRPICO = results.getString("CRPICO");
    String resRecipCode = results.getString("RecipCode");
    String resNoPacs = results.getString("NoPacs");
    return new Candidate(resCycle, resFECCandId, resCID, resFirstLastP, resParty, resDistIdRunFor,
        resDistIdCurr, resCurrCand, resCycleCand, resCRPICO, resRecipCode, resNoPacs);
  }

  @Override
  public List<CandReceivingFromPacs> candsRecievingMostFromPacs() throws SQLException {
    List<CandReceivingFromPacs> candReceivingFromPacsList = new ArrayList<CandReceivingFromPacs>();
    String sql =
        "SELECT PACsToCand16.FECCandID, SUM(PACsToCand16.amount) AS TotGiven, COUNT(*) AS NumDonations\n"
            + "FROM PACsToCand16 \n"
            + "JOIN CandsCRP16 ON CandsCRP16.FECCandID = PACsToCand16.FECCandID\n"
            + "GROUP BY FECCandID\n" + "ORDER BY TotGiven DESC \n" + "LIMIT 100;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(sql);
      results = selectStmt.executeQuery();
      while (results.next()) {
        CandReceivingFromPacs candReceivingFromPacs = new CandReceivingFromPacs(
            results.getString("TotGiven"), results.getString("NumDonations"),
            getCandidateByFECCandId(results.getString("FECCandID")));
        candReceivingFromPacsList.add(candReceivingFromPacs);
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
    return candReceivingFromPacsList;
  }

  @Override
  public List<CandReceivingFromPac> getCommitteesDonatingToCandidate(String fecCandId)
      throws SQLException {
    List<CandReceivingFromPac> candReceivingFromPacList = new ArrayList<CandReceivingFromPac>();
    String sql = "SELECT PACID, COUNT(*) AS CNT, SUM(Amount) AS AMOUNT\n" + "FROM PACsToCand16 \n"
        + "WHERE FECCandID = ?\n" + "GROUP BY PACID\n" + "ORDER BY AMOUNT DESC;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(sql);
      selectStmt.setString(1, fecCandId);
      results = selectStmt.executeQuery();
      while (results.next()) {
        CandReceivingFromPac candReceivingFromPac =
            new CandReceivingFromPac(results.getString("AMOUNT"), results.getString("CNT"),
                this.committeesDao.getCommitteeByCmteId(results.getString("PACID")));
        candReceivingFromPacList.add(candReceivingFromPac);
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
    return candReceivingFromPacList;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, Double> averageDonationsFromIndividuals() throws SQLException {
    Map<String, Double> candidateToAverage = new TreeMap<String, Double>();
    String averageDonationsPerCandidate =
        "SELECT CandsCRP16.FirstLastP, AVG(Amount) AS AVG_RECEIVED_INDIVIDUAL_DONATION "
            + "FROM Indivs16 " + "INNER JOIN CandsCRP16 "
            + "WHERE Indivs16.RecipID = CandsCRP16.CID " + "GROUP BY CandsCRP16.FirstLastP;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(averageDonationsPerCandidate);
      results = selectStmt.executeQuery();
      while (results.next()) {
        candidateToAverage.put(results.getString("FirstLastP"),
            results.getDouble("AVG_RECEIVED_INDIVIDUAL_DONATION"));
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
    return candidateToAverage;
  }
}
