package cs5200.geppetto.model;

/**
 * Created by brian on 11/15/16.
 */
public class Lobbying {
    private String uniqId;
    private String registrantRaw;
    private String registrant;
    private String isFirm;
    private String clientRaw;
    private String client;
    private String ultorg;
    private float amount;
    private String catcode;
    private String source;
    private String self;
    private String includesNsfs;
    private String use;
    private String ind;
    private String year;
    private String type;
    private String typeLong;
    private String affiliate;

    public Lobbying(String uniqId, String registrantRaw, String registrant, String isFirm,
                    String clientRaw, String client, String ultorg, float amount, String catcode,
                    String source, String self, String includesNsfs, String use, String ind,
                    String year, String type, String typeLong, String affiliate) {
        this.uniqId = uniqId;
        this.registrantRaw = registrantRaw;
        this.registrant = registrant;
        this.isFirm = isFirm;
        this.clientRaw = clientRaw;
        this.client = client;
        this.ultorg = ultorg;
        this.amount = amount;
        this.catcode = catcode;
        this.source = source;
        this.self = self;
        this.includesNsfs = includesNsfs;
        this.use = use;
        this.ind = ind;
        this.year = year;
        this.type = type;
        this.typeLong = typeLong;
        this.affiliate = affiliate;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public String getRegistrantRaw() {
        return registrantRaw;
    }

    public void setRegistrantRaw(String registrantRaw) {
        this.registrantRaw = registrantRaw;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getIsFirm() {
        return isFirm;
    }

    public void setIsFirm(String isFirm) {
        this.isFirm = isFirm;
    }

    public String getClientRaw() {
        return clientRaw;
    }

    public void setClientRaw(String clientRaw) {
        this.clientRaw = clientRaw;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUltorg() {
        return ultorg;
    }

    public void setUltorg(String ultorg) {
        this.ultorg = ultorg;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCatcode() {
        return catcode;
    }

    public void setCatcode(String catcode) {
        this.catcode = catcode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getIncludesNsfs() {
        return includesNsfs;
    }

    public void setIncludesNsfs(String includesNsfs) {
        this.includesNsfs = includesNsfs;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeLong() {
        return typeLong;
    }

    public void setTypeLong(String typeLong) {
        this.typeLong = typeLong;
    }

    public String getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(String affiliate) {
        this.affiliate = affiliate;
    }
}
