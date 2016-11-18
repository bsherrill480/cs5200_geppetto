package cs5200.geppetto.dao;

import cs5200.geppetto.model.Lobbying;

/**
 * Created by brian on 11/17/16.
 */
public interface LobbyingDao {
    Lobbying create(Lobbying lobbying);
    Lobbying getByUniqId(String uniqId); // read
    Lobbying update(Lobbying lobbying);
    void deleteByUniqId(String uniqId);
}
