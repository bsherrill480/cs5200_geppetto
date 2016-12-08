package cs5200.geppetto.model.campaignFinance;

import cs5200.geppetto.model.Candidate;

/**
 * Created by brian on 12/6/16.
 */
public class CandReceivingFromPacs {
    String amount;
    String numDonations;
    Candidate candidate;

    public CandReceivingFromPacs(String amount, String numDonations, Candidate candidate) {
        this.amount = amount;
        this.numDonations = numDonations;
        this.candidate = candidate;
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

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
