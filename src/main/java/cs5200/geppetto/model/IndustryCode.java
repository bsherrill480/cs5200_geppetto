package cs5200.geppetto.model;

/**
 * Created by brian on 11/17/16.
 */
public class IndustryCode {
    private String catCode;
    private String catName;
    private String catOrder;
    private String industry;
    private String sector;
    private String sectorLong;

    public IndustryCode(String catCode, String catName, String catOrder, String industry, String sector, String sectorLong) {
        this.catCode = catCode;
        this.catName = catName;
        this.catOrder = catOrder;
        this.industry = industry;
        this.sector = sector;
        this.sectorLong = sectorLong;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatOrder() {
        return catOrder;
    }

    public void setCatOrder(String catOrder) {
        this.catOrder = catOrder;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getSectorLong() {
        return sectorLong;
    }

    public void setSectorLong(String sectorLong) {
        this.sectorLong = sectorLong;
    }
}
