package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.CommitteesDao;
import cs5200.geppetto.model.Committees;

@Service
public class JdbcCommitteesDao extends MyJdbcDaoSupport implements CommitteesDao {

  @Override
  public Committees create(Committees committees) {
    String sql = "INSERT INTO Cmtes16 VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    Connection conn = null;
    try {
      conn = getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, committees.getCycle());
      ps.setString(2, committees.getCmteId());
      ps.setString(3, committees.getPACShort());
      ps.setString(4, committees.getAffiliate());
      ps.setString(5, committees.getUltorg());
      ps.setString(6, committees.getRecipId());
      ps.setString(7, committees.getRecipCode());
      ps.setString(8, committees.getFECCandId());
      ps.setString(9, committees.getParty());
      ps.setString(10, committees.getPrimCode());
      ps.setString(11, committees.getSource());
      ps.setString(12, committees.getSensitive());
      ps.setInt(13, committees.getForeign());
      ps.setInt(14, committees.getActive());
      int affectedRows = ps.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("Creating LobbyAgency failed, no rows affected.");
      }
      ps.close();
      return committees;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Committees> getCommitteesByCycle(String cycle) throws SQLException {
    List<Committees> committees = new ArrayList<Committees>();
    String getCommitteesByCycle =
        "SELECT * FROM Cmtes16 WHERE Cycle=? AND PACShort<>' ' ORDER BY PACShort ASC;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCommitteesByCycle);
      selectStmt.setString(1, cycle);
      results = selectStmt.executeQuery();
      while (results.next()) {
        committees.add(parseCommittees(results));
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
    return committees;
  }

  @Override
  public Committees getCommitteeByCmteId(String cmteId) throws SQLException {
    String getCommitteeByCmteId = "SELECT * FROM Cmtes16 WHERE CmteID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCommitteeByCmteId);
      selectStmt.setString(1, cmteId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return parseCommittees(results);
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
  public Committees getCommitteeByPACShort(String pacShort) throws SQLException {
    String getCommitteeByPACShort = "SELECT * FROM Cmtes16 WHERE PACShort=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(getCommitteeByPACShort);
      selectStmt.setString(1, pacShort);
      results = selectStmt.executeQuery();
      if (results.next()) {
        return parseCommittees(results);
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

  @Override
  public Committees update(Committees committees) {
    String sql =
        "UPDATE Cmtes16 SET Cycle = ? AND CmteID = ? AND PACShort = ? AND Affiliate = ? AND Ultorg = ?"
            + "AND RecipID = ? AND RecipCode = ? AND FECCandID = ? AND Party = ? AND PrimCode = ? AND Source = ?"
            + "AND Sensitive = ? AND test = ? AND test = ?"; // todo
    Connection conn = null;
    try {
      conn = getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, committees.getCycle());
      ps.setString(2, committees.getCmteId());
      ps.setString(3, committees.getPACShort());
      ps.setString(4, committees.getAffiliate());
      ps.setString(5, committees.getUltorg());
      ps.setString(6, committees.getRecipId());
      ps.setString(7, committees.getRecipCode());
      ps.setString(8, committees.getFECCandId());
      ps.setString(9, committees.getParty());
      ps.setString(10, committees.getPrimCode());
      ps.setString(11, committees.getSource());
      ps.setString(12, committees.getSensitive());
      ps.setInt(13, committees.getForeign());
      ps.setInt(14, committees.getActive());
      ps.executeUpdate();
      ps.close();
      return committees;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  @Override
  public void delete(Committees committees) {
    String sql = "DELETE FROM Cmtes16 WHERE CmteID = ?";

    Connection conn = null;

    try {
      conn = getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, committees.getCmteId());
      ps.executeUpdate();
      ps.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  /**
   * Parse committees from result set
   *
   * @param rs result set
   * @return committee
   * @throws SQLException
   */
  public Committees parseCommittees(ResultSet rs) throws SQLException {
    return new Committees(rs.getString("Cycle"), rs.getString("CmteID"), rs.getString("PACShort"),
        rs.getString("Affiliate"), rs.getString("Ultorg"), rs.getString("RecipID"),
        rs.getString("RecipCode"), rs.getString("FECCandID"), rs.getString("Party"),
        rs.getString("PrimCode"), rs.getString("Source"), rs.getString("Sensitive"),
        rs.getInt("Foreign"), rs.getInt("Active"));
  }
}

