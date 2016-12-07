package cs5200.geppetto.controllers.lobbyingPages;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cs5200.geppetto.dao.impl.LobbyistDao;

@Controller
public class FormerCongressMemberLobbyists {

  static Logger log = Logger.getLogger(FormerCongressMemberLobbyists.class.getName());
  @Autowired
  private LobbyistDao lobbyistDao;

  @GetMapping("/lobbying/FormerCongressMemberLobbyists")
  public String welcome(Map<String, Object> model) {

    // to-do

    return "lobbyingPages/formerCongressMemberLobbyists";
  }


}
