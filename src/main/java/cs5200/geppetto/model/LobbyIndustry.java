package cs5200.geppetto.model;

/**
 * Created by brian on 11/15/16.
 */
public class LobbyIndustry {
    String client;
    String sub;
    float total;
    String year;
    String catcode;

    public LobbyIndustry(String client, String sub, float total, String year, String catcode) {
        this.client = client;
        this.sub = sub;
        this.total = total;
        this.year = year;
        this.catcode = catcode;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCatcode() {
        return catcode;
    }

    public void setCatcode(String catcode) {
        this.catcode = catcode;
    }
}
