package cs5200.geppetto.dao.impl;

/**
 * Created by andrewdickens on 11/17/16.
 */
import cs5200.geppetto.dao.LobbyIndustryDao;
import cs5200.geppetto.model.LobbyIndustry;
import cs5200.geppetto.dao.CommitteesDao;
import cs5200.geppetto.model.Committees;
import cs5200.geppetto.model.LobbyAgency;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcCommitteesDao extends MyJdbcDaoSupport implements
		CommitteesDao {

		@Override
		public Committees create(Committees committees) {
				String sql = "INSERT INTO Committees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, committees.getCycle());
						ps.setString(2, committees.getCmteld());
						ps.setString(3, committees.getPACShort());
						ps.setString(4, committees.getAffiliate());
						ps.setString(5, committees.getUltorg());
						ps.setString(6, committees.getRecipId());
						ps.setString(7, committees.getRecipCode());
						ps.setString(8, committees.getFECCandId());
						ps.setString(9, committees.getParty());
						ps.setString(10, committees.getPrimCode());
						ps.setString(11, committees.getSource());
						ps.setString(12, committees.getSensitive());
						ps.setInt(13, committees.getForeign());
						ps.setInt(14, committees.getActive());
						int affectedRows = ps.executeUpdate();
						if(affectedRows == 0) {
								throw new SQLException("Creating LobbyAgency failed, no rows affected.");
						}
						ps.close();
						return committees;
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

		@Override public List<Committees> getByClient(String client) {
				return null;
		}

//		@Override
		public List<Committees> getByUniqueId(String Id) {
				String sql = "SELECT * FROM Committees WHERE Cmteld = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, Id);
						ResultSet rs = ps.executeQuery();
						List<Committees> committees = new ArrayList<Committees>();
						while (rs.next()) {
								Committees committees1 = new Committees(
										rs.getString("Cycle"),
										rs.getString("CmteId"),
										rs.getString("PACShort"),
										rs.getString("Affiliate"),
										rs.getString("Ultorg"),
										rs.getString("RecipId"),
										rs.getString("RecipCode"),
										rs.getString("FECCandId"),
										rs.getString("Party"),
										rs.getString("PrimCode"),
										rs.getString("Source"),
										rs.getString("Sensitive"),
										rs.getInt("Foreign"),
										rs.getInt("Active")
								);
								committees.add(committees1);
						}
						rs.close();
						ps.close();
						return committees;
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
		public Committees get(Committees committeesGetter) {
				String sql = "SELECT * FROM Committees WHERE CmteId = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, committeesGetter.getCmteld());
						ResultSet rs = ps.executeQuery();
						Committees committees = null;
						if(rs.next()) {
								committees = new Committees(
										rs.getString("Cycle"),
										rs.getString("CmteId"),
										rs.getString("PACShort"),
										rs.getString("Affiliate"),
										rs.getString("Ultorg"),
										rs.getString("RecipId"),
										rs.getString("RecipCode"),
										rs.getString("FECCandId"),
										rs.getString("Party"),
										rs.getString("PrimCode"),
										rs.getString("Source"),
										rs.getString("Sensitive"),
										rs.getInt("Foreign"),
										rs.getInt("Active")
								);
						}
						rs.close();
						ps.close();
						return committees;
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
		public Committees update(Committees committees) {
				String sql = "UPDATE Committees SET Cycle = ? AND CmteId = ? AND PACShort = ? AND Affiliate = ? AND Ultorg = ?"
						+ "AND RecipId = ? AND RecipCode = ? AND FECCandId = ? AND Party = ? AND PrimCode = ? AND Source = ?"
						+ "AND Sensitive = ? AND test = ? AND test = ?"; //todo
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, committees.getCycle());
						ps.setString(2, committees.getCmteld());
						ps.setString(3, committees.getPACShort());
						ps.setString(4, committees.getAffiliate());
						ps.setString(5, committees.getUltorg());
						ps.setString(6, committees.getRecipId());
						ps.setString(7, committees.getRecipCode());
						ps.setString(8, committees.getFECCandId());
						ps.setString(9, committees.getParty());
						ps.setString(10, committees.getPrimCode());
						ps.setString(11, committees.getSource());
						ps.setString(12, committees.getSensitive());
						ps.setInt(13, committees.getForeign());
						ps.setInt(14, committees.getActive());
						ps.executeUpdate();
						ps.close();
						return committees;
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
		public void delete(Committees committees) {
				String sql = "DELETE FROM Committees WHERE CmteId = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, committees.getCmteld());
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
}

