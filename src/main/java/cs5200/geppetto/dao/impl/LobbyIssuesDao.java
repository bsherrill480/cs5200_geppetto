package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cs5200.geppetto.controllers.WelcomeController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.LobbyIssuesInterface;
import cs5200.geppetto.model.LobbyIssues;


@Service
public class LobbyIssuesDao extends MyJdbcDaoSupport implements LobbyIssuesInterface {
  static Logger log = Logger.getLogger(WelcomeController.class.getName());
  @Override
  public LobbyIssues create(LobbyIssues lobbyissue) {
    String insertLobbyIssue = "INSERT INTO lobbyissue VALUES (?,?,?,?,?,?)";
    Connection connection = null;
    try {
      connection = getConnection();
      PreparedStatement ps = connection.prepareStatement(insertLobbyIssue);
      ps.setInt(1, lobbyissue.getSi_ID());
      ps.setString(2, lobbyissue.getUniqId());
      ps.setString(3, lobbyissue.getIssueId());
      ps.setString(4, lobbyissue.getIssue());
      ps.setString(5, lobbyissue.getSpecificIssue());
      ps.setString(6, lobbyissue.getYear());
      int affectedRows = ps.executeUpdate();
      if (affectedRows == 0) {
        throw new SQLException("Creating LobbyIssue failed, no rows affected.");
      }
      ps.close();
      return lobbyissue;
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
  public LobbyIssues get(Integer siId) {
    String selectLobbyIssue = "SELECT * FROM lobbyissue WHERE SI_ID=?";
    Connection connection = null;

    try {
      connection = getConnection();
      PreparedStatement selectStmt = connection.prepareStatement(selectLobbyIssue);
      log.info("=========");
      log.info(selectStmt);
      log.info("=========");
      selectStmt.setInt(1, siId);
      ResultSet results = selectStmt.executeQuery();
      LobbyIssues lobbyissueObj = null;
      if (results.next()) {
        Integer si_id = results.getInt("SI_ID");
        String resultUniqId = results.getString("uniqId");
        String issueID = results.getString("issueID");
        String issue = results.getString("issue");
        String SpecificIssue = results.getString("SpecificIssue");
        String year = results.getString("year");
        lobbyissueObj = new LobbyIssues(si_id, resultUniqId, issueID, issue, SpecificIssue, year);
      }
      results.close();
      selectStmt.close();
      return lobbyissueObj;
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
  public LobbyIssues update(LobbyIssues lobbyissue) {
    String updateLobbyIssue =
            "UPDATE lobbyissue SET issue=?, SpecificIssue=?, year=?" + " WHERE IssueID=?";
    Connection coconnection = null;
    try {
      coconnection = getConnection();
      PreparedStatement ps = coconnection.prepareStatement(updateLobbyIssue);
      ps.setString(1, lobbyissue.getIssue());
      ps.setString(2, lobbyissue.getSpecificIssue());
      ps.setString(3, lobbyissue.getYear());
      ps.executeUpdate();
      ps.close();
      return lobbyissue;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (coconnection != null) {
        try {
          coconnection.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  @Override
  public LobbyIssues delete(LobbyIssues lobbyissue) {
    String deleteLobbyIssue = "DELETE FROM lobbyissue WHERE SI_ID=?";
    Connection connection = null;
    try {
      connection = getConnection();
      PreparedStatement ps = connection.prepareStatement(deleteLobbyIssue);
      ps.setInt(1, lobbyissue.getSi_ID());
      ps.executeUpdate();
      ps.close();
      return lobbyissue;
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

