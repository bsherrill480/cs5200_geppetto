package cs5200.geppetto.dao;

import java.util.List;

import cs5200.geppetto.model.LobbyingBills;

public interface LobbyingBillsInterface {
  LobbyingBills create(LobbyingBills lobbyingbill);

  List<LobbyingBills> getLobbyingBills(Integer siId);

  LobbyingBills getLobbyingBill(String B_ID);

  LobbyingBills update(LobbyingBills lobbybill);

  LobbyingBills delete(LobbyingBills lobbybill);
}
