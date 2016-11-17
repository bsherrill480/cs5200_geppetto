package cs5200.geppetto.model;

/**
 * Created by andrewdickens on 11/17/16.
 */
public class Committees {

		protected String Cycle;
		protected String Cmteld;
		protected String PACShort;
		protected String Affiliate;
		protected String Ultorg;
		protected String RecipId;
		protected String RecipCode;
		protected String FECCandId;
		protected String Party;
		protected String PrimCode;
		protected String Source;
		protected String Sensitive;
		protected Integer Foreign;
		protected Integer Active;

		public Committees(String cycle, String cmteld, String PACShort, String affiliate, String ultorg,
				String recipId, String recipCode, String FECCandId, String party, String primCode,
				String source, String sensitive, Integer foreign, Integer active) {
				Cycle = cycle;
				Cmteld = cmteld;
				this.PACShort = PACShort;
				Affiliate = affiliate;
				Ultorg = ultorg;
				RecipId = recipId;
				RecipCode = recipCode;
				this.FECCandId = FECCandId;
				Party = party;
				PrimCode = primCode;
				Source = source;
				Sensitive = sensitive;
				Foreign = foreign;
				Active = active;
		}

		public String getCycle() {
				return Cycle;
		}

		public void setCycle(String cycle) {
				Cycle = cycle;
		}

		public String getCmteld() {
				return Cmteld;
		}

		public void setCmteld(String cmteld) {
				Cmteld = cmteld;
		}

		public String getPACShort() {
				return PACShort;
		}

		public void setPACShort(String PACShort) {
				this.PACShort = PACShort;
		}

		public String getAffiliate() {
				return Affiliate;
		}

		public void setAffiliate(String affiliate) {
				Affiliate = affiliate;
		}

		public String getUltorg() {
				return Ultorg;
		}

		public void setUltorg(String ultorg) {
				Ultorg = ultorg;
		}

		public String getRecipId() {
				return RecipId;
		}

		public void setRecipId(String recipId) {
				RecipId = recipId;
		}

		public String getRecipCode() {
				return RecipCode;
		}

		public void setRecipCode(String recipCode) {
				RecipCode = recipCode;
		}

		public String getFECCandId() {
				return FECCandId;
		}

		public void setFECCandId(String FECCandId) {
				this.FECCandId = FECCandId;
		}

		public String getParty() {
				return Party;
		}

		public void setParty(String party) {
				Party = party;
		}

		public String getPrimCode() {
				return PrimCode;
		}

		public void setPrimCode(String primCode) {
				PrimCode = primCode;
		}

		public String getSource() {
				return Source;
		}

		public void setSource(String source) {
				Source = source;
		}

		public String getSensitive() {
				return Sensitive;
		}

		public void setSensitive(String sensitive) {
				Sensitive = sensitive;
		}

		public Integer getForeign() {
				return Foreign;
		}

		public void setForeign(Integer foreign) {
				Foreign = foreign;
		}

		public Integer getActive() {
				return Active;
		}

		public void setActive(Integer active) {
				Active = active;
		}
}

