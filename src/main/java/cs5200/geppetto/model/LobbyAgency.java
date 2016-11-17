package cs5200.geppetto.model;

/**
 * Created by andrewdickens on 11/17/16.
 */
public class LobbyAgency {

		protected String UniqId;
		protected String AgencyId;
		protected String Agency;

		public LobbyAgency(String uniqId, String agencyId, String agency) {
				UniqId = uniqId;
				AgencyId = agencyId;
				Agency = agency;
		}

		public String getUniqId() {
				return UniqId;
		}

		public void setUniqId(String uniqId) {
				UniqId = uniqId;
		}

		public String getAgencyId() {
				return AgencyId;
		}

		public void setAgencyId(String agencyId) {
				AgencyId = agencyId;
		}

		public String getAgency() {
				return Agency;
		}

		public void setAgency(String agency) {
				Agency = agency;
		}
}
