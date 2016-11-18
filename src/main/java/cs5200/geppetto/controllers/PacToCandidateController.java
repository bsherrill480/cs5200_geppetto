package cs5200.geppetto.controllers;

import java.sql.SQLException;
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
      model.put("candidates", candidates);
      model.put("committees", committees);
    } catch (SQLException e) {
    }
    return "pacToCandidate/index";
  }
}
