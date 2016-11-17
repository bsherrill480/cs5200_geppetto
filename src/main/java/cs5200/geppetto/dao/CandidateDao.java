package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.List;

import cs5200.geppetto.model.Candidate;

/**
 * @author joshuaveden
 */
public interface CandidateDao {
  Candidate create(Candidate candidate) throws SQLException;

  List<Candidate> getCandidatesByCycle(String year) throws SQLException;

  Candidate getCandidateByFECCandId(String fecCandId) throws SQLException;

  Candidate updateCycle(Candidate candidate, String cycle) throws SQLException;

  Candidate delete(String fecCandId) throws SQLException;
}
