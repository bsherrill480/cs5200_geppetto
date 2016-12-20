package cs5200.geppetto.model.lobbying;

public class TopLobbyiedBills {
	String B_ID;
	String Bill_Name;
	String issueID;
	String issue;
	Integer amount;
	
	public TopLobbyiedBills(String B_ID, String Bill_Name, String issueID, String issue, Integer amount) {
		this.B_ID = B_ID;
		this.Bill_Name = Bill_Name;
		this.issueID = issueID;
		this.issue = issue;
		this.amount = amount;
	}

	public String getB_ID() {
		return B_ID;
	}

	public void setB_ID(String b_ID) {
		B_ID = b_ID;
	}

	public String getBill_Name() {
		return Bill_Name;
	}

	public void setBill_Name(String bill_Name) {
		Bill_Name = bill_Name;
	}

	public String getIssueID() {
		return issueID;
	}

	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
