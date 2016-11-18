package cs5200.geppetto.dao;

import cs5200.geppetto.model.Committees;

import java.util.List;

/**
 * Created by andrewdickens on 11/17/16.
 */
public interface CommitteesDao {

		Committees create(Committees committees);
		List<Committees> getByClient(String client); // read
		Committees get(Committees committees); // read
		Committees update(Committees committees);
		void delete(Committees committees);
}
