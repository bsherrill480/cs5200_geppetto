package cs5200.geppetto.dao;

import cs5200.geppetto.model.Lobbying;

/**
 * Created by brian on 11/17/16.
 */
public interface LobbyingDao {
    Lobbying create(Lobbying lobbying);
    Lobbying get(Lobbying lobbying); // read
    Lobbying update(Lobbying lobbying);
    void delete(Lobbying lobbying);
}
