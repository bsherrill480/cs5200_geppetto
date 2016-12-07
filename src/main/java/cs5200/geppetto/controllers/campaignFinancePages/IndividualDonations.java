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
public class IndividualDonations {

  private static final String baseUrl = "/CampaignFinance/IndividualDonations";

  static Logger log = Logger.getLogger(IndividualDonations.class.getName());

  @Autowired
  private CandidateDao candDao;

  @GetMapping(IndividualDonations.baseUrl + "/AverageToCandidate")
  public String averageToCandidate(Map<String, Object> model) throws SQLException {
    Map<String, Double> averageDonationsFromIndividuals =
        this.candDao.averageDonationsFromIndividuals();
    model.put("averageDonationsFromIndividuals", averageDonationsFromIndividuals);
    return "campaignFinancePages/averageIndividualDonations";
  }

  @GetMapping(IndividualDonations.baseUrl + "/TotalToCandidate")
  public String totalToCandidate(Map<String, Object> model) throws SQLException {
    return "campaignFinancePages/totalIndividualDonations";
  }
}
