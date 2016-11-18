package cs5200.geppetto.model;

/**
 * @author joshuaveden
 */
public class Candidate {
  private String cycle;
  private String fecCandId;
  private String cid;
  private String firstLastP;
  private String party;
  private String distIdRunFor;
  private String distIdCurr;
  private String currCand;
  private String cycleCand;
  private String cprico;
  private String recipCode;
  private String noPacs;

  public Candidate(String cycle, String firstLastP, String party, String distIdRunFor,
      String distIdCurr) {
    super();
    this.cycle = cycle;
    this.firstLastP = firstLastP;
    this.party = party;
    this.distIdRunFor = distIdRunFor;
    this.distIdCurr = distIdCurr;
  }

  public Candidate(String cycle, String fecCandId, String cid, String firstLastP, String party,
      String distIdRunFor, String distIdCurr, String currCand, String cycleCand, String cprico,
      String recipCode, String noPacs) {
    super();
    this.cycle = cycle;
    this.fecCandId = fecCandId;
    this.cid = cid;
    this.firstLastP = firstLastP;
    this.party = party;
    this.distIdRunFor = distIdRunFor;
    this.distIdCurr = distIdCurr;
    this.currCand = currCand;
    this.cycleCand = cycleCand;
    this.cprico = cprico;
    this.recipCode = recipCode;
    this.noPacs = noPacs;
  }

  /**
   * @return the cycle
   */
  public String getCycle() {
    return this.cycle;
  }

  /**
   * @param cycle the cycle to set
   */
  public void setCycle(String cycle) {
    this.cycle = cycle;
  }

  /**
   * @return the fecCandId
   */
  public String getFecCandId() {
    return this.fecCandId;
  }

  /**
   * @param fecCandId the fecCandId to set
   */
  public void setFecCandId(String fecCandId) {
    this.fecCandId = fecCandId;
  }

  /**
   * @return the cid
   */
  public String getCid() {
    return this.cid;
  }

  /**
   * @param cid the cid to set
   */
  public void setCid(String cid) {
    this.cid = cid;
  }

  /**
   * @return the firstLastP
   */
  public String getFirstLastP() {
    return this.firstLastP;
  }

  /**
   * @param firstLastP the firstLastP to set
   */
  public void setFirstLastP(String firstLastP) {
    this.firstLastP = firstLastP;
  }

  /**
   * @return the party
   */
  public String getParty() {
    return this.party;
  }

  /**
   * @param party the party to set
   */
  public void setParty(String party) {
    this.party = party;
  }

  /**
   * @return the distIdRunFor
   */
  public String getDistIdRunFor() {
    return this.distIdRunFor;
  }

  /**
   * @param distIdRunFor the distIdRunFor to set
   */
  public void setDistIdRunFor(String distIdRunFor) {
    this.distIdRunFor = distIdRunFor;
  }

  /**
   * @return the distIdCurr
   */
  public String getDistIdCurr() {
    return this.distIdCurr;
  }

  /**
   * @param distIdCurr the distIdCurr to set
   */
  public void setDistIdCurr(String distIdCurr) {
    this.distIdCurr = distIdCurr;
  }

  /**
   * @return the currCand
   */
  public String getCurrCand() {
    return this.currCand;
  }

  /**
   * @param currCand the currCand to set
   */
  public void setCurrCand(String currCand) {
    this.currCand = currCand;
  }

  /**
   * @return the cycleCand
   */
  public String getCycleCand() {
    return this.cycleCand;
  }

  /**
   * @param cycleCand the cycleCand to set
   */
  public void setCycleCand(String cycleCand) {
    this.cycleCand = cycleCand;
  }

  /**
   * @return the cprico
   */
  public String getCprico() {
    return this.cprico;
  }

  /**
   * @param cprico the cprico to set
   */
  public void setCprico(String cprico) {
    this.cprico = cprico;
  }

  /**
   * @return the recipCode
   */
  public String getRecipCode() {
    return this.recipCode;
  }

  /**
   * @param recipCode the recipCode to set
   */
  public void setRecipCode(String recipCode) {
    this.recipCode = recipCode;
  }

  /**
   * @return the noPacs
   */
  public String getNoPacs() {
    return this.noPacs;
  }

  /**
   * @param noPacs the noPacs to set
   */
  public void setNoPacs(String noPacs) {
    this.noPacs = noPacs;
  }
}
