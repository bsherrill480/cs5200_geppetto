package cs5200.geppetto.dao;

import cs5200.geppetto.model.IndividualContributions;

import java.util.List;

/**
 * Created by andrewdickens on 11/17/16.
 */
public interface IndividualContributionsDao {

		IndividualContributions create(IndividualContributions individualContributions);
		List<IndividualContributions> getByClient(String client); // read
		IndividualContributions get(IndividualContributions individualContributions); // read
		IndividualContributions update(IndividualContributions individualContributions);
		void delete(IndividualContributions individualContributions);
}
