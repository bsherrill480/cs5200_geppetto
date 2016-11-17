package cs5200.geppetto.controllers;

import cs5200.geppetto.dao.IndustryCodeDao;
import cs5200.geppetto.model.IndustryCode;
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
public class IndustryCodesController {
	private static final String catCodePathVariable =
			"/catCode/{catCode}";

	public static final String baseUrl = "/IndustryCodes";

	@Autowired
	private IndustryCodeDao industryCodeDao;

    @GetMapping(baseUrl)
	public String index(Map<String, Object> model,
						@RequestParam(value = "catCode", defaultValue = "") String catCode) {
		IndustryCode industryCode = industryCodeDao.getByCatCode(catCode);
		model.put("industryCode", industryCode);
		model.put("catCode", catCode);
		return "industryCode/index";
	}

	@GetMapping(baseUrl + "/update" + catCodePathVariable)
	public String update(Map<String, Object> model, @PathVariable(value="catCode") String catCode) {
        IndustryCode industryCode = industryCodeDao.getByCatCode(catCode);
		model.put("industryCode", industryCode);
		return "industryCode/update";
	}

	@PostMapping(baseUrl + "/update" + catCodePathVariable)
	public String doUpdate(Map<String, Object> model,
						   @RequestParam("catCode") String catCode,
						   @RequestParam("catName") String catName,
						   @RequestParam("catOrder") String catOrder,
						   @RequestParam("industry") String industry,
						   @RequestParam("sector") String sector,
						   @RequestParam("sectorLong") String sectorLong) {
		IndustryCode updatedIndustryCode = new IndustryCode(
				catCode,
				catName,
				catOrder,
				industry,
				sector,
				sectorLong
		);
		IndustryCode industryCode = industryCodeDao.update(updatedIndustryCode);
		model.put("industryCode", industryCode);
		return "industryCode/update";
	}


	@GetMapping(baseUrl + "/delete" + catCodePathVariable)
	public String delete(Map<String, Object> model,
						 @PathVariable(value="catCode") String catCode) {
        IndustryCode industryCode = industryCodeDao.getByCatCode(catCode);
		model.put("industryCode", industryCode);
		return "industryCode/delete";
	}


	@PostMapping(baseUrl + "/delete" + catCodePathVariable)
    public String doDelete(HttpServletRequest request,
						 @PathVariable(value="catCode") String catCode) {
        industryCodeDao.delete(new IndustryCode(
        		catCode,
				"",
				"",
				"",
				"",
				""
		));
        return "redirect:" + baseUrl;
	}

	@GetMapping(baseUrl + "/create")
	public String create(Map<String, Object> model) {
		return "industryCode/create";
	}

	@PostMapping(baseUrl + "/create")
	public String doCreate(HttpServletRequest request,
						   @RequestParam(value="catCode") String catCode,
						   @RequestParam(value="catName") String catName,
						   @RequestParam(value="catOrder") String catOrder,
						   @RequestParam(value="industry") String industry,
						   @RequestParam(value="sector") String sector,
						   @RequestParam(value="sectorLong") String sectorLong) {
		IndustryCode industryCode = industryCodeDao.create(new IndustryCode(
				catCode,
				catName,
				catOrder,
				industry,
				sector,
				sectorLong
		));
        return "redirect:" + baseUrl;
	}
}
