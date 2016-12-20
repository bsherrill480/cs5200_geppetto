package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.List;

import cs5200.geppetto.model.LobbyIssues;
import cs5200.geppetto.model.lobbying.TopLobbyiedIssues;

public interface LobbyIssuesInterface {
  LobbyIssues create(LobbyIssues lobbyissue);

  LobbyIssues get(Integer siId);

  LobbyIssues update(LobbyIssues lobbyissue);

  LobbyIssues delete(LobbyIssues lobbyissue);

  List<TopLobbyiedIssues> getTop() throws SQLException;
}
