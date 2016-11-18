package cs5200.geppetto.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cs5200.geppetto.dao.LobbyIssuesInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs5200.geppetto.model.LobbyIssues;

@Controller
public class LobbyissuesController {


  static Logger log = Logger.getLogger(WelcomeController.class.getName());
  private static final String SI_IDVariable = "/SI_ID/{SI_ID}";
  public static final String baseUrl = "/Lobbyissues";

  @Autowired
  private LobbyIssuesInterface lobbyIssuesInterface;

  @GetMapping(LobbyissuesController.baseUrl)
  public String index(Map<String, Object> model,
      @RequestParam(value = "SI_ID", defaultValue = "0") int SI_ID) {
    log.info("===SID====");
    log.info(SI_ID);
    log.info("===SID====");
    LobbyIssues lobbyissue = this.lobbyIssuesInterface.get(SI_ID);
    model.put("lobbyissue", lobbyissue);
    model.put("SI_ID", SI_ID);
    return "lobbyissue/index";
  }

  @GetMapping(LobbyissuesController.baseUrl + "/create")
  public String create(Map<String, Object> model) {
    return "lobbyissue/create";
  }

  @PostMapping(LobbyissuesController.baseUrl + "/create")

  public String doCreate(HttpServletRequest request, @RequestParam(value = "SI_ID") Integer SI_ID,
      @RequestParam(value = "uniqID") String uniqID,
      @RequestParam(value = "issueID") String issueID, @RequestParam(value = "issue") String issue,
      @RequestParam(value = "SpecificIssue") String specificIssue,
      @RequestParam(value = "year") String year) {
    LobbyIssues lobbyissue = this.lobbyIssuesInterface
        .create(new LobbyIssues(SI_ID, uniqID, issueID, issue, specificIssue, year));
    return "redirect:" + LobbyissuesController.baseUrl;
  }

  @GetMapping(LobbyissuesController.baseUrl + "/update" + LobbyissuesController.SI_IDVariable)
  public String update(Map<String, Object> model, @PathVariable(value = "SI_ID") Integer SI_ID) {
    LobbyIssues lobbyissue = this.lobbyIssuesInterface.get(SI_ID);
    model.put("lobbyissue", lobbyissue);
    return "lobbyissue/update";
  }

  @PostMapping(LobbyissuesController.baseUrl + "/update" + LobbyissuesController.SI_IDVariable)
  public String doUpdate(Map<String, Object> model, @RequestParam("SI_ID") Integer SI_ID,
      @RequestParam("uniqID") String uniqID, @RequestParam("issueID") String issueID,
      @RequestParam("issue") String issue, @RequestParam("SpecificIssue") String specificIssue,
      @RequestParam("year") String year) {
    LobbyIssues updatedLobbyissue =
        new LobbyIssues(SI_ID, uniqID, issueID, issue, specificIssue, year);
    LobbyIssues lobbyissue = this.lobbyIssuesInterface.update(updatedLobbyissue);
    model.put("lobbyisue", lobbyissue);
    return "lobbyissue/index";
  }


  @GetMapping(LobbyissuesController.baseUrl + "/delete" + LobbyissuesController.SI_IDVariable)
  public String delete(Map<String, Object> model, @PathVariable(value = "SI_ID") Integer SI_ID) {
    LobbyIssues lobbyissue = this.lobbyIssuesInterface.delete(this.lobbyIssuesInterface.get(SI_ID));
    model.put("lobbyissue", lobbyissue);
    return "lobbyissue/delete";
  }


  @PostMapping(LobbyissuesController.baseUrl + "/delete" + LobbyissuesController.SI_IDVariable)
  public String doDelete(HttpServletRequest request, @PathVariable(value = "SI_ID") Integer SI_ID) {
    this.lobbyIssuesInterface.delete(this.lobbyIssuesInterface.get(SI_ID));
    return "redirect:" + LobbyissuesController.baseUrl;
  }
}
