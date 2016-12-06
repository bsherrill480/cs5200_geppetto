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

import cs5200.geppetto.dao.CandidateDao;
import cs5200.geppetto.dao.CommitteesDao;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.campaignFinance.CandReceivingFromPac;
import cs5200.geppetto.model.campaignFinance.CandReceivingFromPacs;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@Controller
public class CandidatesReceivingPacMoney {

  private static final String baseUrl = "/CampaignFinance/CandidatesReceivingPacMoney";

  static Logger log = Logger.getLogger(CandidatesReceivingPacMoney.class.getName());

  @Autowired
  private CandidateDao candDao;

  @GetMapping(baseUrl)
  public String Top100(Map<String, Object> model)  throws SQLException{
    List<CandReceivingFromPacs> candReceivingFromPacsList = candDao.candsRecievingMostFromPacs();
    model.put("candReceivingFromPacsList", candReceivingFromPacsList);
    return "campaignFinancePages/candidatesReceivingPacMoney";
  }

  @GetMapping(baseUrl + "/FECCandID/{FECCandID}")
  public String Individual(Map<String, Object> model,
                           @PathVariable(value="FECCandID") String fecCandID) throws SQLException {
      List<CandReceivingFromPac> candReceivingFromPacsList =
              candDao.getCommitteesDonatingToCandidate(fecCandID);
    model.put("candReceivingFromPacsList", candReceivingFromPacsList);
    return "campaignFinancePages/candidateReceivingPacMoney";
  }
}
