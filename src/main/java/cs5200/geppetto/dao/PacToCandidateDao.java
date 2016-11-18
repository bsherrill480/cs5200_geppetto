package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cs5200.geppetto.model.PacToCandidateDonation;

public interface PacToCandidateDao {
  PacToCandidateDonation create(PacToCandidateDonation donation) throws SQLException;

  List<PacToCandidateDonation> getDonationsByCandidateName(String candidateName)
      throws SQLException;

  PacToCandidateDonation updateDonationDate(PacToCandidateDonation donation, Date date)
      throws SQLException;

  PacToCandidateDonation deleteDonation(String fecRecNo) throws SQLException;
}
