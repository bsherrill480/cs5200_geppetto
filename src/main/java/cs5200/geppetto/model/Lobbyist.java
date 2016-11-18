package cs5200.geppetto.model;

public class Lobbyist {
  protected String uniqId;
  protected String lobbyistRaw;
  protected String lobbyist;
  protected String lobbyistId;
  protected String year;
  protected String officialPosition;
  protected String cid;
  protected String formercongmen;

  public Lobbyist(String uniqId, String lobbyistRaw, String lobbyist, String lobbyistId,
      String year, String officialPosition, String cid, String formercongmen) {
    this.uniqId = uniqId;
    this.lobbyistRaw = lobbyistRaw;
    this.lobbyist = lobbyist;
    this.lobbyistId = lobbyistId;
    this.year = year;
    this.officialPosition = officialPosition;
    this.cid = cid;
    this.formercongmen = formercongmen;
  }

  public Lobbyist(String uniqId) {
    this.uniqId = uniqId;
  }

  public String getUniqId() {
    return this.uniqId;
  }

  public void setUniqId(String uniqId) {
    this.uniqId = uniqId;
  }

  public String getLobbyistRaw() {
    return this.lobbyistRaw;
  }

  public void setLobbyistRaw(String lobbyistRaw) {
    this.lobbyistRaw = lobbyistRaw;
  }

  public String getLobbyist() {
    return this.lobbyist;
  }

  public void setLobbyist(String lobbyist) {
    this.lobbyist = lobbyist;
  }

  public String getLobbyistId() {
    return this.lobbyistId;
  }

  public void setLobbyistId(String lobbyistId) {
    this.lobbyistId = lobbyistId;
  }

  public String getYear() {
    return this.year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getOfficialPosition() {
    return this.officialPosition;
  }

  public void setOfficialPosition(String officialPosition) {
    this.officialPosition = officialPosition;
  }

  public String getCid() {
    return this.cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public String getFormercongmen() {
    return this.formercongmen;
  }

  public void setFormercongmen(String formercongmen) {
    this.formercongmen = formercongmen;
  }

}
