package cs5200.geppetto.dao;

import cs5200.geppetto.model.LobbyIndustry;
import cs5200.geppetto.model.campaignFinance.OrganizationsPaying;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by brian on 11/15/16.
 */
public interface LobbyIndustryDao {
    LobbyIndustry create(LobbyIndustry lobbyIndustry);
    List<LobbyIndustry> getByClient(String client); // read
    LobbyIndustry get(LobbyIndustry lobbyIndustry); // read
    LobbyIndustry update(LobbyIndustry lobbyIndustry);
    void delete(LobbyIndustry lobbyIndustry);
    List<OrganizationsPaying> getOrgsPayingTheMost() throws SQLException;

}
