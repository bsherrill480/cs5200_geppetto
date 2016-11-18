package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.PacToPacDonation;

public interface PacToPacDao {

  PacToPacDonation create(PacToPacDonation donation) throws SQLException;

  List<PacToPacDonation> getDonationsToPac(Committees pac) throws SQLException;

  PacToPacDonation updateDonationDate(PacToPacDonation donation, Date date) throws SQLException;

  PacToPacDonation deleteDonation(PacToPacDonation donation) throws SQLException;
}
