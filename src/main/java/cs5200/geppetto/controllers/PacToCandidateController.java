package cs5200.geppetto.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs5200.geppetto.dao.CandidateDao;
import cs5200.geppetto.dao.CommitteesDao;
import cs5200.geppetto.dao.PacToCandidateDao;
import cs5200.geppetto.model.Candidate;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.PacToCandidateDonation;

@Controller
public class PacToCandidateController {

  static Logger log = Logger.getLogger(WelcomeController.class.getName());

  public static final String baseUrl = "/Donations/PacToCandidate";

  @Autowired
  private CandidateDao candidateDao;

  @Autowired
  private CommitteesDao committeeDao;

  @Autowired
  private PacToCandidateDao pacToCandidateDao;

  @GetMapping(PacToCandidateController.baseUrl)
  public String index(Map<String, Object> model,
      @RequestParam(value = "pacShort", defaultValue = "All") String pacShort,
      @RequestParam(value = "candFirstLastP", defaultValue = "All") String candFirstLastP) {
    try {
      List<Candidate> candidates = this.candidateDao.getCandidatesByCycle("2016");
      List<Committees> committees = this.committeeDao.getCommitteesByCycle("2016");
      List<PacToCandidateDonation> donations = new ArrayList<PacToCandidateDonation>();
      if (pacShort.equals("All") && !candFirstLastP.equals("All")) {
        // retrieving donations from all committees to a specific candidate
        donations = this.pacToCandidateDao
            .getDonationsToCandidate(this.candidateDao.getCandidateByFirstLastP(candFirstLastP));
      } else if (!pacShort.equals("All") && candFirstLastP.equals("All")) {
        // retrieving donations from a specific committee to all candidates
        donations = this.pacToCandidateDao
            .getDonationsFromCommittee(this.committeeDao.getCommitteeByPACShort(pacShort));
      }

      model.put("candidates", candidates);
      model.put("committees", committees);
      model.put("donations", donations);
      model.put("selCand", candFirstLastP);
      model.put("selCmte", pacShort);

    } catch (SQLException e) {
    }
    return "pacToCandidate/index";
  }
}
