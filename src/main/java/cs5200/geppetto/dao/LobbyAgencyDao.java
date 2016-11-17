package cs5200.geppetto.dao;

import cs5200.geppetto.model.LobbyAgency;

import java.util.List;

/**
 * Created by andrewdickens on 11/17/16.
 */
public interface LobbyAgencyDao {

		LobbyAgency create(LobbyAgency lobbyAgency);
		List<LobbyAgency> getByUniqueId(String client); // read
		LobbyAgency get(LobbyAgency lobbyAgency); // read
		LobbyAgency update(LobbyAgency lobbyAgency);
		void delete(LobbyAgency lobbyAgency);
}
