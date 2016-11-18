package cs5200.geppetto.model;

public class LobbyingBills {
  protected String b_ID;
  protected Integer si_ID;
  protected String congNo;
  protected String billName;

  public LobbyingBills(String b_ID, Integer si_ID, String congNo, String billName) {
    this.b_ID = b_ID;
    this.si_ID = si_ID;
    this.congNo = congNo;
    this.billName = billName;
  }



  public LobbyingBills(String billName, String congNo, Integer si_id) {
    this.billName = billName;
  }

  public String getB_ID() {
    return this.b_ID;
  }

  public void setB_ID(String b_ID) {
    this.b_ID = b_ID;
  }

  public Integer getSi_ID() {
    return this.si_ID;
  }

  public void setSi_ID(Integer si_ID) {
    this.si_ID = si_ID;
  }

  public String getCongNo() {
    return this.congNo;
  }

  public void setCongNo(String congNo) {
    this.congNo = congNo;
  }

  public String getBillName() {
    return this.billName;
  }

  public void setBillName(String billName) {
    this.billName = billName;
  }

}
