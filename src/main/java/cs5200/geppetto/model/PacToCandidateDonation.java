package cs5200.geppetto.model;

import java.util.Date;

public class PacToCandidateDonation {
  private String cycle;
  private String fecRecNo;
  private Candidate candidate;
  private Committees committee;
  private float amount;
  private Date date;
  private String realCode;
  private String type;
  private String di;
  private String fecCandId;

  public PacToCandidateDonation(String cycle, String fecRecNo, Candidate candidate,
      Committees committee, float amount, Date date, String realCode, String type, String di,
      String fecCandId) {
    super();
    this.cycle = cycle;
    this.fecRecNo = fecRecNo;
    this.candidate = candidate;
    this.committee = committee;
    this.amount = amount;
    this.date = date;
    this.realCode = realCode;
    this.type = type;
    this.di = di;
    this.fecCandId = fecCandId;
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
   * @return the fecRecNo
   */
  public String getFecRecNo() {
    return this.fecRecNo;
  }

  /**
   * @param fecRecNo the fecRecNo to set
   */
  public void setFecRecNo(String fecRecNo) {
    this.fecRecNo = fecRecNo;
  }

  /**
   * @return the candidate
   */
  public Candidate getCandidate() {
    return this.candidate;
  }

  /**
   * @param candidate the candidate to set
   */
  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  /**
   * @return the committee
   */
  public Committees getCommittee() {
    return this.committee;
  }

  /**
   * @param committee the committee to set
   */
  public void setCommittee(Committees committee) {
    this.committee = committee;
  }

  /**
   * @return the amount
   */
  public float getAmount() {
    return this.amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(float amount) {
    this.amount = amount;
  }

  /**
   * @return the date
   */
  public Date getDate() {
    return this.date;
  }

  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * @return the realCode
   */
  public String getRealCode() {
    return this.realCode;
  }

  /**
   * @param realCode the realCode to set
   */
  public void setRealCode(String realCode) {
    this.realCode = realCode;
  }

  /**
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the di
   */
  public String getDi() {
    return this.di;
  }

  /**
   * @param di the di to set
   */
  public void setDi(String di) {
    this.di = di;
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
}
