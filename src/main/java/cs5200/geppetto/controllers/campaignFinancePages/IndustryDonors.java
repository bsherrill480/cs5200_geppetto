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

import cs5200.geppetto.dao.PacToCandidateDao;
import cs5200.geppetto.model.campaignFinance.PacDonation;
import cs5200.geppetto.model.campaignFinance.PacDonationToCandidate;
import cs5200.geppetto.model.campaignFinance.PacIndustryTotalDonation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Controller
public class IndustryDonors {
  private static final String baseUrl = "/CampaignFinance/TopIndustryDonors";

  static Logger log = Logger.getLogger(IndustryDonors.class.getName());
  @Autowired
  private PacToCandidateDao pacToCandidateDao;

  @GetMapping(baseUrl)
  public String welcome(Map<String, Object> model)  throws SQLException {
    List<PacIndustryTotalDonation> pacIndustryTotalDonationList =
            pacToCandidateDao.getPacIndustryTotalDonations();
    model.put("pacIndustryTotalDonationList", pacIndustryTotalDonationList);

    return "campaignFinancePages/industryDonors";
  }

  @GetMapping(baseUrl + "/PrimCode/{PrimCode}")
  public String welcome(Map<String, Object> model,
                        @PathVariable(value="PrimCode") String primCode)  throws SQLException {
    List<PacDonation> pacDonationList = pacToCandidateDao.getPacDonationsByIndustry(primCode);
    model.put("pacDonationList", pacDonationList);

    return "campaignFinancePages/industryDonorsByIndustry";
  }

  @GetMapping(baseUrl + "/PACID/{PACID}")
  public String PacToCandidates(Map<String, Object> model,
                        @PathVariable(value="PACID") String pacID)  throws SQLException {
    List<PacDonationToCandidate> pacDonationToCandidateList =
            pacToCandidateDao.getPacDonationsToCandsByPac(pacID);
    model.put("pacDonationToCandidateList", pacDonationToCandidateList);

    return "campaignFinancePages/industryDonorsToCandidate";
  }
}
