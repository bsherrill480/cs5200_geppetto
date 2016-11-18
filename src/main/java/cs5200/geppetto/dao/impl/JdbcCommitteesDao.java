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
    String getCommitteesByCycle = "SELECT * FROM Cmtes16 WHERE Cycle=?;";
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
  public List<Committees> getByClient(String client) {
    return null;
  }

  // @Override
  public List<Committees> getByUniqueId(String Id) {
    String sql = "SELECT * FROM Cmtes16 WHERE Cmteld = ?";

    Connection conn = null;

    try {
      conn = getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, Id);
      ResultSet rs = ps.executeQuery();
      List<Committees> committees = new ArrayList<Committees>();
      while (rs.next()) {
        Committees committees1 = parseCommittees(rs);
        committees.add(committees1);
      }
      rs.close();
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
  public Committees get(Committees committeesGetter) {
    String sql = "SELECT * FROM Cmtes16 WHERE CmteId = ?";

    Connection conn = null;

    try {
      conn = getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, committeesGetter.getCmteId());
      ResultSet rs = ps.executeQuery();
      Committees committees = null;
      if (rs.next()) {
        committees = parseCommittees(rs);
      }
      rs.close();
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
  public Committees update(Committees committees) {
    String sql =
        "UPDATE Cmtes16 SET Cycle = ? AND CmteId = ? AND PACShort = ? AND Affiliate = ? AND Ultorg = ?"
            + "AND RecipId = ? AND RecipCode = ? AND FECCandId = ? AND Party = ? AND PrimCode = ? AND Source = ?"
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
    String sql = "DELETE FROM Cmtes16 WHERE CmteId = ?";

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
    return new Committees(rs.getString("Cycle"), rs.getString("CmteId"), rs.getString("PACShort"),
        rs.getString("Affiliate"), rs.getString("Ultorg"), rs.getString("RecipId"),
        rs.getString("RecipCode"), rs.getString("FECCandId"), rs.getString("Party"),
        rs.getString("PrimCode"), rs.getString("Source"), rs.getString("Sensitive"),
        rs.getInt("Foreign"), rs.getInt("Active"));
  }
}

