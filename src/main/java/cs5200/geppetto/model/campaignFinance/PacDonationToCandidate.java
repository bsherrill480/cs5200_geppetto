package cs5200.geppetto.model.campaignFinance;

/**
 * Created by brian on 12/7/16.
 */
public class PacDonationToCandidate {
    private String candName;
    private String amount;
    private String numDonations;
    private String pacName;
    private String CID;

    public PacDonationToCandidate(String candName, String amount, String numDonations, String pacName, String CID) {
        this.candName = candName;
        this.amount = amount;
        this.numDonations = numDonations;
        this.pacName = pacName;
        this.CID = CID;
    }

    public String getCandName() {
        return candName;
    }

    public void setCandName(String candName) {
        this.candName = candName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNumDonations() {
        return numDonations;
    }

    public void setNumDonations(String numDonations) {
        this.numDonations = numDonations;
    }

    public String getPacName() {
        return pacName;
    }

    public void setPacName(String pacName) {
        this.pacName = pacName;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }
}
