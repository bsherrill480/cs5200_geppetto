package cs5200.geppetto.model.campaignFinance;

/**
 * Created by brian on 12/7/16.
 */
public class PacIndustryTotalDonation {
    String amount;
    String name;
    String primCode;

    public PacIndustryTotalDonation(String amount, String name, String primCode) {
        this.amount = amount;
        this.name = name;
        this.primCode = primCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimCode() {
        return primCode;
    }

    public void setPrimCode(String primCode) {
        this.primCode = primCode;
    }
}
