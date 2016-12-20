package cs5200.geppetto.controllers.lobbyingPages;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs5200.geppetto.dao.impl.LobbyIssuesDao;
import cs5200.geppetto.model.lobbying.TopLobbyiedIssues;

@Controller
public class TopLobbyIssues {
  static Logger log = Logger.getLogger(TopLobbyIssues.class.getName());

  @Autowired
  private LobbyIssuesDao lobbyIssuesDao;

  @GetMapping("/lobbying/TopLobbiedIssues")
  public String welcome(Map<String, Object> model, @RequestParam(defaultValue = "") String city,
      @RequestParam(defaultValue = "") String state) throws SQLException {
    String tableTitleBy;
    List<TopLobbyiedIssues> topLobbyIssuesList;
    tableTitleBy = "";
    topLobbyIssuesList = this.lobbyIssuesDao.getTop();
    model.put("tableTitleBy", tableTitleBy);
    model.put("topLobbyIssuesList", topLobbyIssuesList);
    return "lobbyingPages/topLobbiedIssues";
  }
}
