package cs5200.geppetto.controllers;

import cs5200.geppetto.dao.LobbyIndustryDao;
import cs5200.geppetto.model.LobbyIndustry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@Controller
public clasLobbyingIndustriesController {
	static Logger log = Logger.getLogger(WelcomeController.class.getName());

	private static final String clientSubYearPathVariables =
			"/client/{client}/sub/{sub}/year/{year}";

	public static final String baseUrl = "/LobbyIndustries";

	@Autowired
	private LobbyIndustryDao lobbyIndustryDao;

    @GetMapping(baseUrl)
	public String index(Map<String, Object> model,
						@RequestParam(value = "client", defaultValue = "") String client) {
		List<LobbyIndustry> lobbyIndustries = lobbyIndustryDao.getByClient(client);
		model.put("lobbyIndustries", lobbyIndustries);
		model.put("client", client);
		return "lobbyIndustry/index";
	}

	@GetMapping(baseUrl + "/update" + clientSubYearPathVariables)
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

	@PostMapping(baseUrl + "/update" + clientSubYearPathVariables)
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


	@GetMapping(baseUrl + "/delete" + clientSubYearPathVariables)
	public String delete(Map<String, Object> model,
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
		return "lobbyIndustry/delete";
	}


	@PostMapping(baseUrl + "/delete" + clientSubYearPathVariables)
    public String doDelete(HttpServletRequest request,
						 @PathVariable(value="client") String client,
						 @PathVariable(value="sub") String sub,
						 @PathVariable(value="year") String year) {
        lobbyIndustryDao.delete(new LobbyIndustry(
        		client,
				sub,
				0.0f,
				year,
				""
		));
        return "redirect:" + baseUrl;
	}

	@GetMapping(baseUrl + "/create")
	public String create(Map<String, Object> model) {
		return "lobbyIndustry/create";
	}

	@PostMapping(baseUrl + "/create")
//	public String doCreate(Map<String, Object> model,
	public String doCreate(HttpServletRequest request,
						 @RequestParam(value="client") String client,
						 @RequestParam(value="sub") String sub,
						 @RequestParam(value="year") String year,
						 @RequestParam(value="catcode") String catcode,
						 @RequestParam(value="total") float total) {
        LobbyIndustry lobbyIndustry = lobbyIndustryDao.create(new LobbyIndustry(
        		client,
				sub,
				total,
				year,
				catcode
		));
        return "redirect:" + baseUrl;
	}

}
