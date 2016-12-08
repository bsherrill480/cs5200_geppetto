package cs5200.geppetto.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs5200.geppetto.dao.impl.LobbyistDao;
import cs5200.geppetto.model.Lobbyist;

@Controller
public class LobbyistController {


  static Logger log = Logger.getLogger(WelcomeController.class.getName());
  private static final String uniqIDVariable = "/uniqID/{uniqID}";
  public static final String baseUrl = "/Lobbyists";

  @Autowired
  private LobbyistDao lobbyistDao;

  @GetMapping(LobbyistController.baseUrl)
  public String index(Map<String, Object> model,
      @RequestParam(value = "uniqID", defaultValue = "") String uniqID) {
    Lobbyist lobbyist = this.lobbyistDao.getLobbyistById(uniqID);
    model.put("lobbyist", lobbyist);
    model.put("uniqID", uniqID);
    return "lobbyist/index";
  }

  @GetMapping(LobbyistController.baseUrl + "/create")
  public String create(Map<String, Object> model) {
    return "lobbyist/create";
  }

  @PostMapping(LobbyistController.baseUrl + "/create")

  public String doCreate(HttpServletRequest request, @RequestParam(value = "uniqID") String uniqId,
      @RequestParam(value = "lobbyist_raw") String lobbyist_raw,
      @RequestParam(value = "lobbyist") String lobbyist,
      @RequestParam(value = "lobbyist_id") String lobbyist_id,
      @RequestParam(value = "year") String year,
      @RequestParam(value = "Official Position") String officialPostion,
      @RequestParam(value = "cid") String cid,
      @RequestParam(value = "formercongmem") String formercongmem) {
    Lobbyist alobbyist = this.lobbyistDao.create(new Lobbyist(uniqId, lobbyist_raw, lobbyist,
        lobbyist_id, year, officialPostion, cid, formercongmem));
    return "redirect:" + LobbyistController.baseUrl;
  }

  @GetMapping(LobbyistController.baseUrl + "/update" + LobbyistController.uniqIDVariable)
  public String update(Map<String, Object> model, @PathVariable(value = "uniqID") String uniqID) {
    Lobbyist lobbyist = this.lobbyistDao.getLobbyistById(uniqID);
    model.put("lobbyist", lobbyist);
    return "lobbyist/update";
  }

  @PostMapping(LobbyistController.baseUrl + "/update" + LobbyistController.uniqIDVariable)
  public String doUpdate(Map<String, Object> model, @RequestParam("uniqID") String uniqID,
      @RequestParam("lobbyist_raw") String lobbyist_raw, @RequestParam("lobbyist") String alobbyist,
      @RequestParam("lobbyist_id") String lobbyist_id, @RequestParam("year") String year,
      @RequestParam("Official Position") String officialpostion, @RequestParam("cid") String cid,
      @RequestParam("formercongmem") String formercongmem) {
    Lobbyist updatedLobbyist = new Lobbyist(uniqID, lobbyist_raw, alobbyist, lobbyist_id, year,
        officialpostion, cid, formercongmem);
    Lobbyist lobbyist = this.lobbyistDao.update(updatedLobbyist);
    model.put("lobbyist", lobbyist);
    return "lobbyist/index";
  }


  @GetMapping(LobbyistController.baseUrl + "/delete" + LobbyistController.uniqIDVariable)
  public String delete(Map<String, Object> model, @PathVariable(value = "uniqID") String uniqID) {
    Lobbyist lobbyist = this.lobbyistDao.getLobbyistById(uniqID);
    model.put("lobbyist", lobbyist);
    return "lobbyist/delete";
  }


  @PostMapping(LobbyistController.baseUrl + "/delete" + LobbyistController.uniqIDVariable)
  public String doDelete(HttpServletRequest request,
      @PathVariable(value = "uniqID") String uniqID) {
    this.lobbyistDao.delete(this.lobbyistDao.getLobbyistById(uniqID));
    return "redirect:" + LobbyistController.baseUrl;
  }
}
