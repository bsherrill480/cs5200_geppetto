package cs5200.geppetto.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs5200.geppetto.dao.CandidateDao;
import cs5200.geppetto.model.Candidate;

@Controller
public class CandidatesController {

  static Logger log = Logger.getLogger(WelcomeController.class.getName());

  public static final String baseUrl = "/Candidates";

  @Autowired
  private CandidateDao candidateDao;

  @GetMapping(CandidatesController.baseUrl)
  public String index(Map<String, Object> model,
      @RequestParam(value = "year", defaultValue = "") String year) {
    try {
      List<Candidate> candidates = this.candidateDao.getCandidatesByCycle(year);
      System.out.println(candidates.size());
      model.put("candidates", candidates);
      model.put("year", year);
    } catch (SQLException e) {
    }
    return "candidate/index";
  }

  @GetMapping(CandidatesController.baseUrl + "/create")
  public String create(Map<String, Object> model) {
    return "candidate/create";
  }

  @PostMapping(CandidatesController.baseUrl + "/create")
  public String doCreate(HttpServletRequest request) {
    String firstName = request.getParameter("first");
    String lastName = request.getParameter("last");
    String party = request.getParameter("party");
    String cycle = request.getParameter("cycle");
    String idRunFor = request.getParameter("distIdRunFor");
    String idCurr = request.getParameter("distIdCurr");

    String firstLastP = firstName + " " + lastName + " " + "(" + party + ")";
    Candidate candidate = new Candidate(cycle, firstLastP, party, idRunFor, idCurr);
    try {
      this.candidateDao.create(candidate);
    } catch (SQLException e) {

    }
    return "redirect:" + CandidatesController.baseUrl;
  }

  @GetMapping(CandidatesController.baseUrl + "/updateCycle/fecCandId/{fecCandId}")
  public String update(Map<String, Object> model,
      @PathVariable(value = "fecCandId") String fecCandId) {
    try {
      Candidate candidate = this.candidateDao.getCandidateByFECCandId(fecCandId);
      model.put("candidate", candidate);
    } catch (SQLException e) {
    }
    return "candidate/updateCycle";
  }

  @PostMapping(CandidatesController.baseUrl + "/updateCycle/fecCandId/{fecCandId}")
  public String doUpdate(HttpServletRequest request,
      @PathVariable(value = "fecCandId") String fecCandId) {
    try {
      String cycle = request.getParameter("cycle");
      Candidate candidate = this.candidateDao.getCandidateByFECCandId(fecCandId);
      this.candidateDao.updateCycle(candidate, cycle);
    } catch (SQLException e) {
    }
    return "redirect:" + CandidatesController.baseUrl;
  }

  @GetMapping(CandidatesController.baseUrl + "/delete/fecCandId/{fecCandId}")
  public String delete(Map<String, Object> model,
      @PathVariable(value = "fecCandId") String fecCandId) {
    try {
      Candidate candidate = this.candidateDao.getCandidateByFECCandId(fecCandId);
      model.put("candidate", candidate);
    } catch (SQLException e) {
    }
    return "candidate/delete";
  }

  @PostMapping(CandidatesController.baseUrl + "/delete/fecCandId/{fecCandId}")
  public String doDelete(HttpServletRequest request,
      @PathVariable(value = "fecCandId") String fecCandId) {
    try {
      this.candidateDao.delete(fecCandId);
    } catch (SQLException e) {

    }
    return "redirect:" + CandidatesController.baseUrl;
  }
}

