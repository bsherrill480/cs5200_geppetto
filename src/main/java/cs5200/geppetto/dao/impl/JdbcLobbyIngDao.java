package cs5200.geppetto.dao.impl;

import cs5200.geppetto.dao.LobbyingDao;
import cs5200.geppetto.model.Lobbying;
import cs5200.geppetto.model.campaignFinance.Industry;
import cs5200.geppetto.model.campaignFinance.LobbyingFirms;
import cs5200.geppetto.model.campaignFinance.OrganizationsPaying;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service public class JdbcLobbyIngDao extends MyJdbcDaoSupport implements LobbyingDao {

		@Override public List<Industry> getAverageByIndustry() throws SQLException {
				List<Industry> averageByIndustryList = new ArrayList<Industry>();
				String averageByIndustry =
						"SELECT l.client AS ORG, l.amount FROM Lobbying l ORDER BY l.amount DESC LIMIT 10;";
				Connection connection = null;
				PreparedStatement selectStmt = null;
				ResultSet results = null;
				try {
						connection = getConnection();
						selectStmt = connection.prepareStatement(averageByIndustry);
						results = selectStmt.executeQuery();
						while (results.next()) { Industry industry = new Industry(results.getString("Org"),
										results.getString("amount"));
								averageByIndustryList.add(industry);
						}
				} catch (SQLException e) {
						e.printStackTrace();
						throw e;
				} finally {
						if (connection != null) {
								connection.close();
						}
						if (selectStmt != null) {
								selectStmt.close();
						}
						if (results != null) {
								results.close();
						}
				}
				return averageByIndustryList;
		}

		@Override public List<LobbyingFirms> getTopPaidLobbyingFirms() throws SQLException {
				List<LobbyingFirms> topPaidLobbyingFirmList = new ArrayList<LobbyingFirms>();
				String topPaidLobbyingFirms =
						"SELECT l.registrant AS Firm, l.amount FROM Lobbying l WHERE l.isfirm LIKE '%y%' ORDER BY l.amount DESC;";
				Connection connection = null;
				PreparedStatement selectStmt = null;
				ResultSet results = null;
				try {
						connection = getConnection();
						selectStmt = connection.prepareStatement(topPaidLobbyingFirms);
						results = selectStmt.executeQuery();
						while (results.next()) { LobbyingFirms lobbyingFirms = new LobbyingFirms(results.getString("Firm"),
										results.getString("amount"));
								topPaidLobbyingFirmList.add(lobbyingFirms);
						}
				} catch (SQLException e) {
						e.printStackTrace();
						throw e;
				} finally {
						if (connection != null) {
								connection.close();
						}
						if (selectStmt != null) {
								selectStmt.close();
						}
						if (results != null) {
								results.close();
						}
				}
				return topPaidLobbyingFirmList;
		}

		@Override public Lobbying create(Lobbying lobbying) {
				String sql = "INSERT INTO Lobbying "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, lobbying.getUniqId());
						ps.setString(2, lobbying.getRegistrantRaw());
						ps.setString(3, lobbying.getRegistrant());
						ps.setString(4, lobbying.getIsFirm());
						ps.setString(5, lobbying.getClientRaw());
						ps.setString(6, lobbying.getClient());
						ps.setString(7, lobbying.getUltorg());
						ps.setFloat(8, lobbying.getAmount());
						ps.setString(9, lobbying.getCatcode());
						ps.setString(10, lobbying.getSource());
						ps.setString(11, lobbying.getSelf());
						ps.setString(12, lobbying.getIncludesNsfs());
						ps.setString(13, lobbying.getUse());
						ps.setString(14, lobbying.getInd());
						ps.setString(15, lobbying.getYear());
						ps.setString(16, lobbying.getType());
						ps.setString(17, lobbying.getTypeLong());
						ps.setString(18, lobbying.getAffiliate());
						int affectedRows = ps.executeUpdate();
						if (affectedRows == 0) {
								throw new SQLException("Creating Lobbying failed, no rows affected.");
						}
						ps.close();
						return lobbying;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {
								}
						}
				}
		}

		@Override public Lobbying getByUniqId(String uniqId) {
				String sql = "SELECT * FROM Lobbying WHERE uniqid = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, uniqId);
						ResultSet rs = ps.executeQuery();
						Lobbying lobbying = null;
						if (rs.next()) {
								lobbying = new Lobbying(rs.getString("uniqid"), rs.getString("registrant_raw"),
										rs.getString("registrant"), rs.getString("isfirm"), rs.getString("client_raw"),
										rs.getString("client"), rs.getString("ultorg"), rs.getFloat("amount"),
										rs.getString("catcode"), rs.getString("source"), rs.getString("self"),
										rs.getString("IncludeNSFS"), rs.getString("use"), rs.getString("ind"),
										rs.getString("year"), rs.getString("type"), rs.getString("typelong"),
										rs.getString("affiliate"));
						}
						rs.close();
						ps.close();
						return lobbying;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {
								}
						}
				}
		}

		@Override public Lobbying update(Lobbying lobbying) {
				String sql = "UPDATE Lobbying SET " +
						"uniqid = ?, " +
						"registrant_raw = ?, " +
						"registrant = ?, " +
						"isfirm = ?, " +
						"client_raw = ?, " +
						"client = ?, " +
						"ultorg = ?, " +
						"amount = ?, " +
						"catcode = ?, " +
						"source = ?, " +
						"self = ?, " +
						"IncludeNSFS = ?, " +
						"`use` = ?, " +
						"ind = ?, " +
						"`year` = ?, " +
						"`type` = ?, " +
						"typeLong = ?, " +
						"affiliate = ? " +
						"WHERE uniqid = ?";
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, lobbying.getUniqId());
						ps.setString(2, lobbying.getRegistrantRaw());
						ps.setString(3, lobbying.getRegistrant());
						ps.setString(4, lobbying.getIsFirm());
						ps.setString(5, lobbying.getClientRaw());
						ps.setString(6, lobbying.getClient());
						ps.setString(7, lobbying.getUltorg());
						ps.setFloat(8, lobbying.getAmount());
						ps.setString(9, lobbying.getCatcode());
						ps.setString(10, lobbying.getSource());
						ps.setString(11, lobbying.getSelf());
						ps.setString(12, lobbying.getIncludesNsfs());
						ps.setString(13, lobbying.getUse());
						ps.setString(14, lobbying.getInd());
						ps.setString(15, lobbying.getYear());
						ps.setString(16, lobbying.getType());
						ps.setString(17, lobbying.getTypeLong());
						ps.setString(18, lobbying.getAffiliate());
						ps.setString(19, lobbying.getUniqId());
						ps.executeUpdate();
						ps.close();
						return lobbying;
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {
								}
						}
				}
		}

		@Override public void deleteByUniqId(String uniqId) {
				String sql = "DELETE FROM Lobbying WHERE uniqid = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, uniqId);
						ps.executeUpdate();
						ps.close();
				} catch (SQLException e) {
						throw new RuntimeException(e);
				} finally {
						if (conn != null) {
								try {
										conn.close();
								} catch (SQLException e) {
								}
						}
				}
		}
}
