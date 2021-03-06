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

import cs5200.geppetto.dao.IndividualContributionsDao;
import cs5200.geppetto.model.campaignFinance.IndividualTotalDonations;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class IndivsDonatingTheMost {

  static Logger log = Logger.getLogger(IndivsDonatingTheMost.class.getName());
  @Autowired
  private IndividualContributionsDao individualContributionsDao;

  @GetMapping("/CampaignFinance/IndividualsDonatingTheMost")
  public String welcome(Map<String, Object> model,
                        @RequestParam(defaultValue = "") String city,
                        @RequestParam(defaultValue = "") String state) {
    String tableTitleBy;
    List<IndividualTotalDonations> individualTotalDonationsList;
    if(!city.isEmpty()) {
      tableTitleBy = "In " + city;
      individualTotalDonationsList = individualContributionsDao.getByTopByCity(city);
    } else if(!state.isEmpty()) {
      tableTitleBy = "In " + state;
      individualTotalDonationsList = individualContributionsDao.getByTopByState(state);
    } else {
      tableTitleBy = "";
        // put in null list to indicate we're using top 100
        individualTotalDonationsList = null;
    }
    model.put("tableTitleBy", tableTitleBy);
    model.put("individualTotalDonationsList", individualTotalDonationsList);

    return "campaignFinancePages/indivsDonatingTheMost";
  }
}
