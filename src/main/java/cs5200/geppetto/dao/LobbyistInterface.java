package cs5200.geppetto.dao;

import cs5200.geppetto.model.Lobbyist;

public interface LobbyistInterface {
  Lobbyist create(Lobbyist lobbyist);

  Lobbyist getLobbyistById(String uniqId);

  Lobbyist getLobbyist(String lobbyist);

  Lobbyist update(Lobbyist lobbyist);

  Lobbyist delete(Lobbyist lobbyist);
}
