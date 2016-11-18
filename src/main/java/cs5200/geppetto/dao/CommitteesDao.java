package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.List;

import cs5200.geppetto.model.Committees;

/**
 * Created by andrewdickens on 11/17/16.
 */
public interface CommitteesDao {

  Committees create(Committees committees);

  List<Committees> getByClient(String client); // read

  List<Committees> getCommitteesByCycle(String cycle) throws SQLException;

  Committees get(Committees committees); // read

  Committees update(Committees committees);

  void delete(Committees committees);
}
