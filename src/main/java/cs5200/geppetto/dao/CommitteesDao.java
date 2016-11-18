package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.List;

import cs5200.geppetto.model.Committees;

/**
 * Created by andrewdickens on 11/17/16.
 */
public interface CommitteesDao {

  Committees create(Committees committees);

  Committees getCommitteeByCmteId(String cmteId) throws SQLException; // read

  List<Committees> getCommitteesByCycle(String cycle) throws SQLException;

  Committees update(Committees committees);

  void delete(Committees committees);
}
