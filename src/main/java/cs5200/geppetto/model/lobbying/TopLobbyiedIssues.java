package cs5200.geppetto.model.lobbying;

public class TopLobbyiedIssues {

  String issue;
  String count;

  public TopLobbyiedIssues(String issue, String count) {
    this.issue = issue;
    this.count = count;
  }

  public String getIssue() {
    return this.issue;
  }

  public void setIssue(String issue) {
    this.issue = issue;
  }

  public String getCount() {
    return this.count;
  }

  public void setCount(String count) {
    this.count = count;
  }


}
