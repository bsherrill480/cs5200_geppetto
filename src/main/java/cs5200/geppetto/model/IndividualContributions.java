package cs5200.geppetto.model;

import cs5200.geppetto.dao.CandidateDao;
import cs5200.geppetto.dao.CommitteesDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * Created by andrewdickens on 11/17/16.
 */
public class IndividualContributions {


		protected String Cycle;
		protected String FECTTransId;
		protected String ContribId;
		protected String Contrib;
		protected String RecipId;
		protected String Orgname;
		protected String UltOrg;
		protected String RealCode;
		protected String Date;
		protected String Amount;
		protected String Street;
		protected String City;
		protected String State;
		protected String Zip;
		protected String RecipCode;
		protected String Type;
		protected String Cmteld;
		protected String OtherId;
		protected String Gender;
		protected String Microfilm;
		protected String Occupation;
		protected String Employer;
		protected String Source;
		protected String recipName = null;
    	protected Candidate candidate;
		protected Committees committees;

		public IndividualContributions(String cycle, String FECTTransId, String contribId,
				String contrib, String recipId, String orgname, String ultOrg, String realCode, String date,
				String amount, String street, String city, String state, String zip, String recipCode,
				String type, String cmteld, String otherId, String gender, String microfilm,
				String occupation, String employer, String source, Candidate candidate,
									   Committees committees) {
				Cycle = cycle;
				this.FECTTransId = FECTTransId;
				ContribId = contribId;
				Contrib = contrib;
				RecipId = recipId;
				Orgname = orgname;
				UltOrg = ultOrg;
				RealCode = realCode;
				Date = date;
				Amount = amount;
				Street = street;
				City = city;
				State = state;
				Zip = zip;
				RecipCode = recipCode;
				Type = type;
				Cmteld = cmteld;
				OtherId = otherId;
				Gender = gender;
				Microfilm = microfilm;
				Occupation = occupation;
				Employer = employer;
				Source = source;
				this.candidate = candidate;
				this.committees = committees;
		}

		public String getCycle() {
				return Cycle;
		}

		public void setCycle(String cycle) {
				Cycle = cycle;
		}

		public String getFECTTransId() {
				return FECTTransId;
		}

		public void setFECTTransId(String FECTTransId) {
				this.FECTTransId = FECTTransId;
		}

		public String getContribId() {
				return ContribId;
		}

		public void setContribId(String contribId) {
				ContribId = contribId;
		}

		public String getContrib() {
				return Contrib;
		}

		public void setContrib(String contrib) {
				Contrib = contrib;
		}

		public String getRecipId() {
				return RecipId;
		}

		public void setRecipId(String recipId) {
				RecipId = recipId;
		}

		public String getOrgname() {
				return Orgname;
		}

		public void setOrgname(String orgname) {
				Orgname = orgname;
		}

		public String getUltOrg() {
				return UltOrg;
		}

		public void setUltOrg(String ultOrg) {
				UltOrg = ultOrg;
		}

		public String getRealCode() {
				return RealCode;
		}

		public void setRealCode(String realCode) {
				RealCode = realCode;
		}

		public String getDate() {
				return Date;
		}

		public String getDateWithoutTime() {
            String d = getDate();
			return d.substring(0, d.length() - 10);
		}

		public void setDate(String date) {
				Date = date;
		}

		public String getAmount() {
				return Amount;
		}

		public void setAmount(String amount) {
				Amount = amount;
		}

		public String getStreet() {
				return Street;
		}

		public void setStreet(String street) {
				Street = street;
		}

		public String getCity() {
				return City;
		}

		public void setCity(String city) {
				City = city;
		}

		public String getState() {
				return State;
		}

		public void setState(String state) {
				State = state;
		}

		public String getZip() {
				return Zip;
		}

		public void setZip(String zip) {
				Zip = zip;
		}

		public String getRecipCode() {
				return RecipCode;
		}

		public void setRecipCode(String recipCode) {
				RecipCode = recipCode;
		}

		public String getType() {
				return Type;
		}

		public void setType(String type) {
				Type = type;
		}

		public String getCmteld() {
				return Cmteld;
		}

		public void setCmteld(String cmteld) {
				Cmteld = cmteld;
		}

		public String getOtherId() {
				return OtherId;
		}

		public void setOtherId(String otherId) {
				OtherId = otherId;
		}

		public String getGender() {
				return Gender;
		}

		public void setGender(String gender) {
				Gender = gender;
		}

		public String getMicrofilm() {
				return Microfilm;
		}

		public void setMicrofilm(String microfilm) {
				Microfilm = microfilm;
		}

		public String getOccupation() {
				return Occupation;
		}

		public void setOccupation(String occupation) {
				Occupation = occupation;
		}

		public String getEmployer() {
				return Employer;
		}

		public void setEmployer(String employer) {
				Employer = employer;
		}

		public String getSource() {
				return Source;
		}

		public void setSource(String source) {
				Source = source;
		}

		// either a candidate or committee
		public String getRecipName() throws SQLException{
			if(recipName == null) {
				recipName = candidate == null ? "" : candidate.getFirstLastP();
				if (recipName.isEmpty()) {
					recipName = committees == null ? "" : committees.getPACShort();
				}
			}
			return recipName;
		}
}
