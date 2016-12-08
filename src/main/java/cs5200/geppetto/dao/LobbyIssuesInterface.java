package cs5200.geppetto.dao;

import cs5200.geppetto.model.LobbyIssues;

public interface LobbyIssuesInterface {
  LobbyIssues create(LobbyIssues lobbyissue);

  LobbyIssues get(Integer siId);

  LobbyIssues update(LobbyIssues lobbyissue);

  LobbyIssues delete(LobbyIssues lobbyissue);
}
