package cs5200.geppetto.model.campaignFinance;

/**
 * Created by andrewdickens on 12/7/16.
 */
public class Industry {
		String sumDonated;
		String industryCode;

		public Industry(String sumDonated, String industryCode) {
				this.sumDonated = sumDonated;
				this.industryCode = industryCode;
		}

		public String getSumDonated() {
				return sumDonated;
		}

		public void setSumDonated(String sumDonated) {
				this.sumDonated = sumDonated;
		}

		public String getIndustryCode() {
				return industryCode;
		}

		public void setIndustryCode(String industryCode) {
				this.industryCode = industryCode;
		}
}
