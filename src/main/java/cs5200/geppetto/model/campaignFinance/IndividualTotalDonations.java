package cs5200.geppetto.model.campaignFinance;

/**
 * Created by brian on 12/6/16.
 */
public class IndividualTotalDonations {
    private String totalGiven;
    private String numDonations;
    private String contributor;
    private String contribID;

    public IndividualTotalDonations(String totalGiven, String numDonations, String contributor,
                                    String contribID) {
        this.totalGiven = totalGiven;
        this.numDonations = numDonations;
        this.contributor = contributor;
        this.contribID = contribID;
    }

    public String getTotalGiven() {
        return totalGiven;
    }

    public void setTotalGiven(String totalGiven) {
        this.totalGiven = totalGiven;
    }

    public String getNumDonations() {
        return numDonations;
    }

    public void setNumDonations(String numDonations) {
        this.numDonations = numDonations;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getContribID() {
        return contribID;
    }

    public void setContribID(String contribID) {
        this.contribID = contribID;
    }
}
