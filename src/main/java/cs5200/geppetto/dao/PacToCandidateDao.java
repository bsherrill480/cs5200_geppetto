package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cs5200.geppetto.model.Candidate;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.PacToCandidateDonation;
import cs5200.geppetto.model.campaignFinance.PacDonation;
import cs5200.geppetto.model.campaignFinance.PacDonationToCandidate;
import cs5200.geppetto.model.campaignFinance.PacIndustryTotalDonation;

public interface PacToCandidateDao {
  PacToCandidateDonation create(PacToCandidateDonation donation) throws SQLException;

  List<PacToCandidateDonation> getDonationsByCandidateName(String candidateName)
      throws SQLException;

  List<PacToCandidateDonation> getDonationsFromCommittee(Committees committee) throws SQLException;

  List<PacToCandidateDonation> getDonationsToCandidate(Candidate candidate) throws SQLException;

  PacToCandidateDonation updateDonationDate(PacToCandidateDonation donation, Date date)
      throws SQLException;

  PacToCandidateDonation deleteDonation(String fecRecNo) throws SQLException;

  List<PacIndustryTotalDonation> getPacIndustryTotalDonations() throws SQLException;

  List<PacDonation> getPacDonationsByIndustry(String primCode) throws SQLException;

  List<PacDonationToCandidate> getPacDonationsToCandsByPac(String PACID) throws SQLException;
}
