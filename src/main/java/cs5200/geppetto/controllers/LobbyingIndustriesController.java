package cs5200.geppetto.controllers;

import cs5200.geppetto.dao.LobbyIndustryDao;
import cs5200.geppetto.model.LobbyIndustry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;


@Controller
public class LobbyingIndustriesController {
	static Logger log = Logger.getLogger(WelcomeController.class.getName());
	@Autowired
	private LobbyIndustryDao lobbyIndustryDao;

    @GetMapping("/LobbyIndustries")
	public String index(Map<String, Object> model,
						@RequestParam(value = "client", defaultValue = "") String client) {
		List<LobbyIndustry> lobbyIndustries = lobbyIndustryDao.getByClient(client);
		model.put("lobbyIndustries", lobbyIndustries);
		model.put("client", client);
		return "lobbyIndustry/index";
	}

	@GetMapping("/LobbyIndustries/update/client/{client}/sub/{sub}/year/{year}/")
	public String update(Map<String, Object> model,
						 @PathVariable(value="client") String client,
						 @PathVariable(value="sub") String sub,
						 @PathVariable(value="year") String year) {
        LobbyIndustry lobbyIndustry = lobbyIndustryDao.get(new LobbyIndustry(
        		client,
				sub,
				0.0f,
				year,
				""
		));
		model.put("lobbyIndustry", lobbyIndustry);
		return "lobbyIndustry/update";
	}

	@PostMapping("/LobbyIndustries/update/client/{client}/sub/{sub}/year/{year}/")
	public String doUpdate(Map<String, Object> model,
						   @RequestParam("client") String client,
						   @RequestParam("sub") String sub,
						   @RequestParam("year") String year,
						   @RequestParam("total") float total,
						   @RequestParam("catcode") String catcode) {
		LobbyIndustry updatedLobbyIndustry = new LobbyIndustry(
				client,
				sub,
				total,
				year,
				catcode
		);
		LobbyIndustry lobbyIndustry = lobbyIndustryDao.update(updatedLobbyIndustry);
		model.put("lobbyIndustry", lobbyIndustry);
		return "lobbyIndustry/update";
	}
}
