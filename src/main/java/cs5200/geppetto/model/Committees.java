package cs5200.geppetto.model;

/**
 * Created by andrewdickens on 11/17/16.
 */
public class Committees {

  protected String Cycle;
  protected String CmteId;
  protected String PACShort;
  protected String Affiliate;
  protected String Ultorg;
  protected String RecipId;
  protected String RecipCode;
  protected String FECCandId;
  protected String Party;
  protected String PrimCode;
  protected String Source;
  protected String Sensitive;
  protected Integer Foreign;
  protected Integer Active;

  public Committees(String cycle, String cmteld, String PACShort, String affiliate, String ultorg,
      String recipId, String recipCode, String FECCandId, String party, String primCode,
      String source, String sensitive, Integer foreign, Integer active) {
    this.Cycle = cycle;
    this.CmteId = cmteld;
    this.PACShort = PACShort;
    this.Affiliate = affiliate;
    this.Ultorg = ultorg;
    this.RecipId = recipId;
    this.RecipCode = recipCode;
    this.FECCandId = FECCandId;
    this.Party = party;
    this.PrimCode = primCode;
    this.Source = source;
    this.Sensitive = sensitive;
    this.Foreign = foreign;
    this.Active = active;
  }

  public String getCycle() {
    return this.Cycle;
  }

  public void setCycle(String cycle) {
    this.Cycle = cycle;
  }

  public String getCmteId() {
    return this.CmteId;
  }

  public void setCmteId(String cmteld) {
    this.CmteId = cmteld;
  }

  public String getPACShort() {
    return this.PACShort;
  }

  public void setPACShort(String PACShort) {
    this.PACShort = PACShort;
  }

  public String getAffiliate() {
    return this.Affiliate;
  }

  public void setAffiliate(String affiliate) {
    this.Affiliate = affiliate;
  }

  public String getUltorg() {
    return this.Ultorg;
  }

  public void setUltorg(String ultorg) {
    this.Ultorg = ultorg;
  }

  public String getRecipId() {
    return this.RecipId;
  }

  public void setRecipId(String recipId) {
    this.RecipId = recipId;
  }

  public String getRecipCode() {
    return this.RecipCode;
  }

  public void setRecipCode(String recipCode) {
    this.RecipCode = recipCode;
  }

  public String getFECCandId() {
    return this.FECCandId;
  }

  public void setFECCandId(String FECCandId) {
    this.FECCandId = FECCandId;
  }

  public String getParty() {
    return this.Party;
  }

  public void setParty(String party) {
    this.Party = party;
  }

  public String getPrimCode() {
    return this.PrimCode;
  }

  public void setPrimCode(String primCode) {
    this.PrimCode = primCode;
  }

  public String getSource() {
    return this.Source;
  }

  public void setSource(String source) {
    this.Source = source;
  }

  public String getSensitive() {
    return this.Sensitive;
  }

  public void setSensitive(String sensitive) {
    this.Sensitive = sensitive;
  }

  public Integer getForeign() {
    return this.Foreign;
  }

  public void setForeign(Integer foreign) {
    this.Foreign = foreign;
  }

  public Integer getActive() {
    return this.Active;
  }

  public void setActive(Integer active) {
    this.Active = active;
  }
}

