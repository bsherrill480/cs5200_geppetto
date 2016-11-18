package cs5200.geppetto.model;

public class LobbyIssues {
  protected Integer si_ID;
  protected String uniqId;
  protected String issueId;
  protected String issue;
  protected String specificIssue;
  protected String year;

  public LobbyIssues(Integer si_ID, String uniqId, String issueId, String issue,
      String specificIssue, String year) {
    this.si_ID = si_ID;
    this.uniqId = uniqId;
    this.issueId = issueId;
    this.issue = issue;
    this.specificIssue = specificIssue;
    this.year = year;
  }

  public LobbyIssues(Integer si_ID) {
    this.si_ID = si_ID;
  }

  public Integer getSi_ID() {
    return this.si_ID;
  }

  public void setSi_ID(Integer si_ID) {
    this.si_ID = si_ID;
  }

  public String getUniqId() {
    return this.uniqId;
  }

  public void setUniqId(String uniqId) {
    this.uniqId = uniqId;
  }

  public String getIssueId() {
    return this.issueId;
  }

  public void setIssueId(String issueId) {
    this.issueId = issueId;
  }

  public String getIssue() {
    return this.issue;
  }

  public void setIssue(String issue) {
    this.issue = issue;
  }

  public String getSpecificIssue() {
    return this.specificIssue;
  }

  public void setSpecificIssue(String specificIssue) {
    this.specificIssue = specificIssue;
  }

  public String getYear() {
    return this.year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
