package cs5200.geppetto.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cs5200.geppetto.dao.impl.LobbyingBillsDao;
import cs5200.geppetto.model.LobbyingBills;

@Controller
public class LobbyingBillsController {

  static Logger log = Logger.getLogger(WelcomeController.class.getName());

  private static final String B_IDsi_idCongNoVariables =
      "/B_ID/{B_ID}/si_id/{si_id}/CongNo/{CongNo}";

  public static final String baseUrl = "/LobbyingBills";

  @Autowired
  private LobbyingBillsDao lobbyBillsDao;

  @GetMapping(LobbyingBillsController.baseUrl)
  public String index(Map<String, Object> model,
      @RequestParam(value = "si_id", defaultValue = "") Integer si_id) {
    List<LobbyingBills> lobbybills = this.lobbyBillsDao.getLobbyingBills(si_id);
    model.put("lobbybills", lobbybills);
    model.put("si_id", si_id);
    return "lobbybill/index";
  }

  @GetMapping(LobbyingBillsController.baseUrl + "/update"
      + LobbyingBillsController.B_IDsi_idCongNoVariables)
  public String update(Map<String, Object> model, @PathVariable(value = "B_ID") String B_ID,
      @PathVariable(value = "si_id") Integer si_id, @PathVariable(value = "CongNo") String CongNo) {
    LobbyingBills lobbybill = this.lobbyBillsDao.getLobbyingBill(B_ID);
    model.put("lobbybill", lobbybill);
    return "lobbybill/update";
  }

  @PostMapping(LobbyingBillsController.baseUrl + "/update"
      + LobbyingBillsController.B_IDsi_idCongNoVariables)
  public String doUpdate(Map<String, Object> model, @RequestParam("B_ID") String B_ID,
      @RequestParam("si_id") Integer si_id, @RequestParam("CongNo") String CongNo,
      @RequestParam("Bill_Name") String bill_name) {
    LobbyingBills updatedLobbyBill = new LobbyingBills(B_ID, si_id, CongNo, bill_name);
    LobbyingBills lobbybill = this.lobbyBillsDao.update(updatedLobbyBill);
    model.put("lobbybill", lobbybill);
    return "lobbybill/update";
  }


  @GetMapping(LobbyingBillsController.baseUrl + "/delete"
      + LobbyingBillsController.B_IDsi_idCongNoVariables)
  public String delete(Map<String, Object> model, @PathVariable("B_ID") String B_ID,
      @PathVariable("si_id") Integer si_id, @PathVariable("CongNo") String CongNo,
      @PathVariable("Bill_Name") String bill_name) {
    LobbyingBills lobbybill = this.lobbyBillsDao.getLobbyingBill(B_ID);
    model.put("lobbybill", lobbybill);
    return "lobbybill/delete";
  }


  @PostMapping(LobbyingBillsController.baseUrl + "/delete"
      + LobbyingBillsController.B_IDsi_idCongNoVariables)
  public String doDelete(HttpServletRequest request, @PathVariable("B_ID") String B_ID,
      @PathVariable("si_id") Integer si_id, @PathVariable("CongNo") String CongNo,
      @PathVariable("Bill_Name") String bill_name) {
    this.lobbyBillsDao.delete(this.lobbyBillsDao.getLobbyingBill(B_ID));
    return "redirect:" + LobbyingBillsController.baseUrl;
  }

  @GetMapping(LobbyingBillsController.baseUrl + "/create")
  public String create(Map<String, Object> model) {
    return "lobbybill/create";
  }

  @PostMapping(LobbyingBillsController.baseUrl + "/create")
  // public String doCreate(Map<String, Object> model,
  public String doCreate(HttpServletRequest request, @RequestParam(value = "B_ID") String B_ID,
      @RequestParam(value = "si_id") Integer si_id, @RequestParam(value = "CongNo") String CongNo,
      @RequestParam(value = "Bill_Name") String bill_name) {
    LobbyingBills lobbyingbill =
        this.lobbyBillsDao.create(new LobbyingBills(B_ID, si_id, CongNo, bill_name));
    return "redirect:" + LobbyingBillsController.baseUrl;
  }

}
