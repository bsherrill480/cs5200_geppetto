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

import java.sql.SQLException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cs5200.geppetto.dao.CandidateDao;


@Controller
public class PacDonations {

  private static final String baseUrl = "/CampaignFinance/PacDonations";

  static Logger log = Logger.getLogger(PacDonations.class.getName());

  @Autowired
  private CandidateDao candDao;

  @GetMapping(PacDonations.baseUrl + "/AverageToCandidate")
  public String averageToCandidate(Map<String, Object> model) throws SQLException {
    Map<String, Double> candidatesToAverageDonation = this.candDao.averageDonationsFromPacs();
    model.put("candidatesToAverageDonation", candidatesToAverageDonation);
    return "campaignFinancePages/averagePacDonations";
  }
}
