package cs5200.geppetto.model.campaignFinance;

/**
 * Created by andrewdickens on 12/7/16.
 */
public class LobbyingFirms {
		String firm;
		String amount;

		public LobbyingFirms(String firm, String amount) {
				this.firm = firm;
				this.amount = amount;
		}

		public String getFirm() {
				return firm;
		}

		public void setFirm(String firm) {
				this.firm = firm;
		}

		public String getAmount() {
				return amount;
		}

		public void setAmount(String amount) {
				this.amount = amount;
		}
}
