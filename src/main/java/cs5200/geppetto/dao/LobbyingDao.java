package cs5200.geppetto.dao;

import cs5200.geppetto.model.Lobbying;
import cs5200.geppetto.model.campaignFinance.Industry;
import cs5200.geppetto.model.campaignFinance.LobbyingFirms;
import cs5200.geppetto.model.campaignFinance.OrganizationsPaying;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by brian on 11/17/16.
 */
public interface LobbyingDao {
    Lobbying create(Lobbying lobbying);
    Lobbying getByUniqId(String uniqId); // read
    Lobbying update(Lobbying lobbying);
    void deleteByUniqId(String uniqId);
    List<Industry> getAverageByIndustry() throws SQLException;
    List<LobbyingFirms> getTopPaidLobbyingFirms() throws SQLException;
}
