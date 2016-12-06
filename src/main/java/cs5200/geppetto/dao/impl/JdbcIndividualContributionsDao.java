package cs5200.geppetto.dao.impl;

/**
 * Created by andrewdickens on 11/17/16.
 */
import cs5200.geppetto.model.IndividualContributions;
import cs5200.geppetto.dao.IndividualContributionsDao;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.campaignFinance.IndividualTotalDonations;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class JdbcIndividualContributionsDao extends MyJdbcDaoSupport implements
		IndividualContributionsDao {
		private static final String GET_TOP_AMOUNT = "100";
//		@Override
		public IndividualContributions create(IndividualContributions individualContributions) {
				String sql = "INSERT INTO Committees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, individualContributions.getCycle());
						ps.setString(2, individualContributions.getFECTTransId());
						ps.setString(3, individualContributions.getContribId());
						ps.setString(4, individualContributions.getContrib());
						ps.setString(5, individualContributions.getRecipId());
						ps.setString(6, individualContributions.getOrgname());
						ps.setString(7, individualContributions.getUltOrg());
						ps.setString(8, individualContributions.getRealCode());
						ps.setString(9, individualContributions.getDate());
						ps.setString(10, individualContributions.getAmount());
						ps.setString(11, individualContributions.getStreet());
						ps.setString(12, individualContributions.getCity());
						ps.setString(13, individualContributions.getState());
						ps.setString(14, individualContributions.getZip());
						ps.setString(15, individualContributions.getRecipCode());
						ps.setString(16, individualContributions.getType());
						ps.setString(17, individualContributions.getCmteld());
						ps.setString(18, individualContributions.getOtherId());
						ps.setString(19, individualContributions.getGender());
						ps.setString(20, individualContributions.getMicrofilm());
						ps.setString(21, individualContributions.getOccupation());
						ps.setString(22, individualContributions.getEmployer());
						ps.setString(23, individualContributions.getSource());
						int affectedRows = ps.executeUpdate();
						if(affectedRows == 0) {
								throw new SQLException("Creating LobbyAgency failed, no rows affected.");
						}
						ps.close();
						return individualContributions;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {}
						}
				}
		}

				@Override
		public List<IndividualContributions> getByClient(String Id) {
				String sql = "SELECT * FROM Committees WHERE ContribId = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, Id);
						ResultSet rs = ps.executeQuery();
						List<IndividualContributions> individualContributionses = new ArrayList<IndividualContributions>();
						while (rs.next()) {
								IndividualContributions individualContributions = new IndividualContributions(
										rs.getString("Cycle"),
										rs.getString("FECTransid"),
										rs.getString("ContribId"),
										rs.getString("Contrib"),
										rs.getString("RecipId"),
										rs.getString("Orgname"),
										rs.getString("UltOrg"),
										rs.getString("RealCode"),
										rs.getString("Date"),
										rs.getString("Amount"),
										rs.getString("Street"),
										rs.getString("City"),
										rs.getString("State"),
										rs.getString("Zip"),
										rs.getString("RecipCode"),
										rs.getString("Type"),
										rs.getString("CmteId"),
										rs.getString("OtherId"),
										rs.getString("Gender"),
										rs.getString("Microfilm"),
										rs.getString("Occupation"),
										rs.getString("Employer"),
										rs.getString("Source")
								);
								individualContributionses.add(individualContributions);
						}
						rs.close();
						ps.close();
						return individualContributionses;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {}
						}
				}
		}

        @Override
		public List<IndividualContributions> get(String contribID) {
			return get(new IndividualContributions(
					"",
					"",
					contribID,
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					"",
					""
			));
		}

		@Override
		public List<IndividualContributions> get(IndividualContributions
															 individualContributionsGetter) {
				String sql = "SELECT * FROM Indivs16 WHERE ContribId = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, individualContributionsGetter.getContribId());
						ResultSet rs = ps.executeQuery();
						List<IndividualContributions> individualContributionsList =
								new LinkedList<IndividualContributions>();
						while(rs.next()) {
								IndividualContributions individualContributions = new
										IndividualContributions(
										rs.getString("Cycle"),
										rs.getString("FECTransid"),
										rs.getString("ContribId"),
										rs.getString("Contrib"),
										rs.getString("RecipId"),
										rs.getString("Orgname"),
										rs.getString("UltOrg"),
										rs.getString("RealCode"),
										rs.getString("Date"),
										rs.getString("Amount"),
										rs.getString("Street"),
										rs.getString("City"),
										rs.getString("State"),
										rs.getString("Zip"),
										rs.getString("RecipCode"),
										rs.getString("Type"),
										rs.getString("CmteId"),
										rs.getString("OtherId"),
										rs.getString("Gender"),
										rs.getString("Microfilm"),
										rs.getString("Occupation"),
										rs.getString("Employer"),
										rs.getString("Source")
								);
							individualContributionsList.add(individualContributions);
						}
						rs.close();
						ps.close();
						return individualContributionsList;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {}
						}
				}
		}

		@Override
		public IndividualContributions update(IndividualContributions individualContributions) {
				String sql = "UPDATE Committees SET Cycle = ? AND FECTTransId = ? AND ContribId = ? AND RecipId = ? AND Orgname = ?"
						+ "AND UltOrg = ? AND RealCode = ? AND test = ? AND Amount = ? AND Street = ? AND City = ?"
						+ "AND State = ? AND Zip = ? AND RecipCode = ? AND Type = ? AND Cmteld = ? AND OtherId = ? AND Gender = ?"
						+ "AND Microfilm = ? AND Occupation = ? AND Employer = ? AND Source = ? AND test = ?";//todo
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, individualContributions.getCycle());
						ps.setString(2, individualContributions.getFECTTransId());
						ps.setString(3, individualContributions.getContribId());
						ps.setString(4, individualContributions.getContrib());
						ps.setString(5, individualContributions.getRecipId());
						ps.setString(6, individualContributions.getOrgname());
						ps.setString(7, individualContributions.getUltOrg());
						ps.setString(8, individualContributions.getRealCode());
						ps.setString(9, individualContributions.getDate());
						ps.setString(10, individualContributions.getAmount());
						ps.setString(11, individualContributions.getStreet());
						ps.setString(12, individualContributions.getCity());
						ps.setString(13, individualContributions.getState());
						ps.setString(14, individualContributions.getZip());
						ps.setString(15, individualContributions.getRecipCode());
						ps.setString(16, individualContributions.getType());
						ps.setString(17, individualContributions.getCmteld());
						ps.setString(18, individualContributions.getOtherId());
						ps.setString(19, individualContributions.getGender());
						ps.setString(20, individualContributions.getMicrofilm());
						ps.setString(21, individualContributions.getOccupation());
						ps.setString(22, individualContributions.getEmployer());
						ps.setString(23, individualContributions.getSource());
						ps.executeUpdate();
						ps.close();
						return individualContributions;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {}
						}
				}
		}

		@Override
		public void delete(IndividualContributions individualContributions) {
				String sql = "DELETE FROM Committees WHERE ContribId = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, individualContributions.getContribId());
						ps.executeUpdate();
						ps.close();
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {}
						}
				}
		}

	@Cacheable
	private List<IndividualTotalDonations> getTopByGeneric(String sql, String param) {

		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
            if(!param.isEmpty()) {
				ps.setString(1, param);
			}
			ResultSet rs = ps.executeQuery();
			List<IndividualTotalDonations> individualTotalDonationsList =
					new LinkedList<IndividualTotalDonations>();
			while(rs.next()) {
				IndividualTotalDonations individualTotalDonations  = new IndividualTotalDonations(
						rs.getString("TotGiven"),
						rs.getString("NumDonations"),
						rs.getString("contrib"),
						rs.getString("contribID")
				);
                individualTotalDonationsList.add(individualTotalDonations);
			}
			rs.close();
			ps.close();
			return individualTotalDonationsList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<IndividualTotalDonations> getByTop() {
		return this.getTopByGeneric("" +
				"SELECT ContribID, SUM(amount) AS TotGiven, COUNT(*) AS NumDonations, contrib\n" +
				"FROM Indivs16\n" +
				"WHERE ContribID != \"\"" +
				"GROUP BY ContribID\n" +
				"ORDER BY TotGiven DESC \n" +
				"LIMIT " + GET_TOP_AMOUNT, "");
	}

	@Override
	public List<IndividualTotalDonations> getByTopByCity(String location) {
		return this.getTopByGeneric("" +
				"SELECT ContribID, SUM(amount) AS TotGiven, COUNT(*) AS NumDonations, contrib\n" +
				"FROM Indivs16 USE INDEX (City)\n" +
				"WHERE ContribID != \"\" AND LOWER(City) = LOWER(?)" +
				"GROUP BY ContribID\n" +
				"ORDER BY TotGiven DESC \n" +
				"LIMIT " + GET_TOP_AMOUNT, location.toLowerCase());
	}

	@Override
	public List<IndividualTotalDonations> getByTopByState(String location) {
		return this.getTopByGeneric("" +
				"SELECT ContribID, SUM(amount) AS TotGiven, COUNT(*) AS NumDonations, contrib\n" +
				"FROM Indivs16 USE INDEX (State) \n" +
				"WHERE ContribID != \"\" AND LOWER(State) = LOWER(?)" +
				"GROUP BY ContribID\n" +
				"ORDER BY TotGiven DESC \n" +
				"LIMIT " + GET_TOP_AMOUNT, location.toLowerCase());
	}
}


