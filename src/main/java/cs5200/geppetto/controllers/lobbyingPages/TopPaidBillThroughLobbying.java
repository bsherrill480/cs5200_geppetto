package cs5200.geppetto.controllers.lobbyingPages;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import cs5200.geppetto.dao.impl.LobbyingBillsDao;
import cs5200.geppetto.model.lobbying.TopLobbyiedBills;

@Controller
public class TopPaidBillThroughLobbying {
	static Logger log = Logger.getLogger(TopPaidBillThroughLobbying.class.getName());
	  @Autowired
	  private LobbyingBillsDao lobbybillsDao;

	  @GetMapping("/lobbying/TopLobbyingBills")
	  public String welcome(Map<String, Object> model) throws SQLException {

	    List<TopLobbyiedBills> toplobbybills = lobbybillsDao.getTop();
	    model.put("toplobbybills", toplobbybills);

	    return "lobbyingPages/toplobbybills";
	  }
}
