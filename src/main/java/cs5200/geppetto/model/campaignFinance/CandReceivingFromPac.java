package cs5200.geppetto.model.campaignFinance;

import cs5200.geppetto.model.Candidate;
import cs5200.geppetto.model.Committees;

/**
 * Created by brian on 12/6/16.
 */
public class CandReceivingFromPac {
    String amount;
    Committees committees;
    String numDonations;
    public CandReceivingFromPac(String amount, String numDonations, Committees committees) {
        this.amount = amount;
        this.committees = committees;
        this.numDonations = numDonations;
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

    public Committees getCommittees() {
        return committees;
    }

    public void setCommittees(Committees committees) {
        this.committees = committees;
    }


}
