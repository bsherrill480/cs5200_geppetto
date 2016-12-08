package cs5200.geppetto.controllers;

import cs5200.geppetto.dao.LobbyingDao;
import cs5200.geppetto.model.Lobbying;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by brian on 11/17/16.
 */
@Controller
public class LobbyingController {
	private static final String catCodePathVariable =
			"/uniqId/{uniqId}";

	public static final String baseUrl = "/Lobbying";

	@Autowired
	private LobbyingDao lobbyingDao;

    @GetMapping(baseUrl)
	public String index(Map<String, Object> model,
						@RequestParam(value = "uniqId", defaultValue = "") String uniqId) {
		Lobbying lobbying = lobbyingDao.getByUniqId(uniqId);
		model.put("lobbying", lobbying);
		model.put("uniqId", uniqId);
		return "lobbying/index";
	}

	@GetMapping(baseUrl + "/update" + catCodePathVariable)
	public String update(Map<String, Object> model, @PathVariable(value="uniqId") String uniqId) {
        Lobbying lobbying = lobbyingDao.getByUniqId(uniqId);
		model.put("lobbying", lobbying);
		return "lobbying/update";
	}

	@PostMapping(baseUrl + "/update" + catCodePathVariable)
	public String doUpdate(Map<String, Object> model,
						   @RequestParam("uniqId") String uniqId,
						   @RequestParam("registrant") String registrant,
						   @RequestParam("client") String client,
						   @RequestParam("amount") float amount,
						   @RequestParam("catcode") String catcode,
						   @RequestParam("year") String year) {
		Lobbying lobbying = lobbyingDao.getByUniqId(uniqId);
		lobbying.setRegistrant(registrant);
		lobbying.setClient(client);
		lobbying.setAmount(amount);
		lobbying.setCatcode(catcode);
		lobbying.setYear(year);
		lobbying = lobbyingDao.update(lobbying);
		model.put("lobbying", lobbying);
		return "lobbying/update";
	}


	@GetMapping(baseUrl + "/delete" + catCodePathVariable)
	public String delete(Map<String, Object> model,
						 @PathVariable(value="uniqId") String uniqId) {
        Lobbying lobbying = lobbyingDao.getByUniqId(uniqId);
		model.put("lobbying", lobbying);
		return "lobbying/delete";
	}


	@PostMapping(baseUrl + "/delete" + catCodePathVariable)
    public String doDelete(HttpServletRequest request,
						 @PathVariable(value="uniqId") String uniqId) {
        lobbyingDao.deleteByUniqId(uniqId);
        return "redirect:" + baseUrl;
	}
}
