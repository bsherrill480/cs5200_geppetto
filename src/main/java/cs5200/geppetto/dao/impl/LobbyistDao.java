package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.LobbyistInterface;
import cs5200.geppetto.model.Lobbyist;

@Service
public class LobbyistDao extends MyJdbcDaoSupport implements LobbyistInterface {


  protected LobbyistDao() {

  }


  @Override
  public Lobbyist create(Lobbyist lobbyist) {
    String insertLobbyist =
        "INSERT INTO Lobbyists(uniqID,lobbyist_raw,lobbyist,lobbyist_id,year,`Official Position`,cid,formercongmem) "
            + "VALUES(?,?,?,?,?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = getConnection();
      insertStmt = connection.prepareStatement(insertLobbyist);
      insertStmt.setString(1, lobbyist.getUniqId());
      insertStmt.setString(2, lobbyist.getLobbyistRaw());
      insertStmt.setString(3, lobbyist.getLobbyist());
      insertStmt.setString(4, lobbyist.getLobbyistId());
      insertStmt.setString(5, lobbyist.getYear());
      insertStmt.setString(6, lobbyist.getOfficialPosition());
      insertStmt.setString(7, lobbyist.getCid());
      insertStmt.setString(8, lobbyist.getFormercongmen());
      insertStmt.executeUpdate();
      return lobbyist;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
  }


  @Override
  public Lobbyist getLobbyistById(String uniqId) {
    String selectLobbyist =
        "SELECT uniqID,lobbyist_raw,lobbyist,lobbyist_id,year,`Official Position`,cid,formercongmem "
            + "FROM Lobbyists WHERE uniqID=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(selectLobbyist);
      selectStmt.setString(1, uniqId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        String resultUniqId = results.getString("lobbyist_id");
        String lobbyistRaw = results.getString("lobbyist_raw");
        String lobbyist = results.getString("lobbyist");
        String year = results.getString("year");
        String officialPosition = results.getString("Official Position");
        String cid = results.getString("cid");
        String formercongmen = results.getString("formercongmem");
        Lobbyist lobbyistObj = new Lobbyist(uniqId, lobbyistRaw, lobbyist, resultUniqId, year,
            officialPosition, cid, formercongmen);
        return lobbyistObj;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
    return null;
  }

  @Override
  public Lobbyist getLobbyist(String lobbyist) {
    String selectLobbyist =
        "SELECT uniqID,lobbyist_raw,lobbyist,lobbyist_id,year,`Official Position`,cid,formercongmen "
            + "FROM Lobbyists " + "WHERE lobbyist=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(selectLobbyist);
      selectStmt.setString(1, lobbyist);
      results = selectStmt.executeQuery();
      if (results.next()) {
        String resultUniqId = results.getString("uniqId");
        String lobbyistRaw = results.getString("lobbyist_raw");
        String lobbyistId = results.getString("lobbyist_id");
        String year = results.getString("year");
        String officialPosition = results.getString("Official Position");
        String cid = results.getString("cid");
        String formercongmen = results.getString("formercongmem");
        Lobbyist lobbyistObj = new Lobbyist(resultUniqId, lobbyistRaw, lobbyist, lobbyistId, year,
            officialPosition, cid, formercongmen);
        return lobbyistObj;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
    return null;
  }

  @Override
  public Lobbyist update(Lobbyist lobbyist) {
    String updateLobbyist =
        "UPDATE Lobbyists SET lobbyist_raw = ?, lobbyist = ?, year = ?, `Official Position`=?, cid = ?, formercongmem = ? "
            + "WHERE uniqID=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = getConnection();
      updateStmt = connection.prepareStatement(updateLobbyist);
      updateStmt.setString(1, lobbyist.getLobbyistRaw());
      updateStmt.setString(2, lobbyist.getLobbyist());
      updateStmt.setString(3, lobbyist.getYear());
      updateStmt.setString(4, lobbyist.getOfficialPosition());
      updateStmt.setString(5, lobbyist.getCid());
      updateStmt.setString(6, lobbyist.getFormercongmen());

      updateStmt.setString(7, lobbyist.getUniqId());
      updateStmt.executeUpdate();
      updateStmt.close();
      return lobbyist;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  @Override
  public Lobbyist delete(Lobbyist lobbyist) {
    String deleteLobbyist = "DELETE FROM Lobbyists WHERE uniqID=?";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = getConnection();
      deleteStmt = connection.prepareStatement(deleteLobbyist);
      deleteStmt.setString(1, lobbyist.getUniqId());
      // deleteStmt.setString(2, lobbyist.getLobbyist());
      deleteStmt.executeUpdate();
      deleteStmt.close();
      return lobbyist;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
  }
}

