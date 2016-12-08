/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package cs5200.geppetto.controllers.campaignFinancePages;

import cs5200.geppetto.dao.LobbyingDao;
import cs5200.geppetto.model.campaignFinance.Industry;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Controller
public class AvgSpendByIndustryController {

		static Logger log = Logger.getLogger(AvgSpendByIndustryController.class.getName());

		@Autowired
		private LobbyingDao lobbyingDao;

		@GetMapping("CampaignFinance/averageSpendingByIndustry")
		public String welcome(Map<String, Object> model) throws SQLException {
				List<Industry> averageIndustryList = lobbyingDao.getAverageByIndustry();
				model.put("averageIndustryList", averageIndustryList);
				return "campaignFinancePages/averageSpendingByIndustry";
		}
}
