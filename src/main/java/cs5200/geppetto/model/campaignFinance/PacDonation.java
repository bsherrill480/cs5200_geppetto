package cs5200.geppetto.model.campaignFinance;

/**
 * Created by brian on 12/7/16.
 */
public class PacDonation {
    private String name;
    private String amount;
    private String cmteId;
    private String catName;

    public PacDonation(String name, String amount, String cmteId, String catName) {
        this.name = name;
        this.amount = amount;
        this.cmteId = cmteId;
        this.catName = catName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCmteId() {
        return cmteId;
    }

    public void setCmteId(String cmteId) {
        this.cmteId = cmteId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
