package cs5200.geppetto.model.campaignFinance;

/**
 * Created by andrewdickens on 12/7/16.
 */
public class Industry {
		String org;
		String amount;

		public Industry(String org, String amount) {
				this.org = org;
				this.amount = amount;
		}

		public String getOrg() {
				return org;
		}

		public void setOrg(String org) {
				this.org = org;
		}

		public String getAmount() {
				return amount;
		}

		public void setAmount(String amount) {
				this.amount = amount;
		}
}
