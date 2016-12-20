package cs5200.geppetto.dao;

import java.sql.SQLException;
import java.util.List;

import cs5200.geppetto.controllers.lobbyingPages.TopPaidBillThroughLobbying;
import cs5200.geppetto.model.LobbyingBills;
import cs5200.geppetto.model.lobbying.TopLobbyiedBills;
import cs5200.geppetto.model.lobbying.TopLobbyiedIssues;

public interface LobbyingBillsInterface {
  LobbyingBills create(LobbyingBills lobbyingbill);

  List<LobbyingBills> getLobbyingBills(Integer siId);

  LobbyingBills getLobbyingBill(String B_ID);

  LobbyingBills update(LobbyingBills lobbybill);

  LobbyingBills delete(LobbyingBills lobbybill);
  
  List<TopLobbyiedBills> getTop() throws SQLException;
}
