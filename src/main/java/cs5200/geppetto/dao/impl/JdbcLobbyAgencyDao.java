package cs5200.geppetto.dao.impl;

/**
 * Created by andrewdickens on 11/17/16.
 */
import cs5200.geppetto.dao.LobbyIndustryDao;
import cs5200.geppetto.model.LobbyIndustry;
import cs5200.geppetto.dao.LobbyAgencyDao;
import cs5200.geppetto.model.LobbyAgency;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcLobbyAgencyDao extends cs5200.geppetto.dao.impl.MyJdbcDaoSupport implements
		LobbyAgencyDao {

		@Override
		public LobbyAgency create(LobbyAgency lobbyAgency) {
				String sql = "INSERT INTO LobbyAgency VALUES (?, ?, ?)";
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, lobbyAgency.getUniqId());
						ps.setString(2, lobbyAgency.getAgencyId());
						ps.setString(3, lobbyAgency.getAgency());
						int affectedRows = ps.executeUpdate();
						if(affectedRows == 0) {
								throw new SQLException("Creating LobbyAgency failed, no rows affected.");
						}
						ps.close();
						return lobbyAgency;
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
		public List<LobbyAgency> getByUniqueId(String Id) {
				String sql = "SELECT * FROM LobbyAgency WHERE Uniqid = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, Id);
						ResultSet rs = ps.executeQuery();
						List<LobbyAgency> lobbyAgencies = new ArrayList<LobbyAgency>();
						while (rs.next()) {
								LobbyAgency lobbyagency = new LobbyAgency(
										rs.getString("UniqueId"),
										rs.getString("AgencyId"),
										rs.getString("Agency")
								);
								lobbyAgencies.add(lobbyagency);
						}
						rs.close();
						ps.close();
						return lobbyAgencies;
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
		public LobbyAgency get(LobbyAgency lobbyAgencyGetter) {
				String sql = "SELECT * FROM LobbyAgency WHERE Uniqid = ? AND AgencyID = ? AND Agency = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, lobbyAgencyGetter.getUniqId());
						ps.setString(2, lobbyAgencyGetter.getAgencyId());
						ps.setString(3, lobbyAgencyGetter.getAgency());
						ResultSet rs = ps.executeQuery();
						LobbyAgency lobbyAgency = null;
						if(rs.next()) {
								lobbyAgency = new LobbyAgency(
										rs.getString("Uniqid"),
										rs.getString("AgencyID"),
										rs.getString("Agency")
								);
						}
						rs.close();
						ps.close();
						return lobbyAgency;
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
		public LobbyAgency update(LobbyAgency lobbyAgency) {
				String sql = "UPDATE LobbyAgency SET Uniqid = ? AND AgencyID = ? AND Agency = ?";
				Connection conn = null;
				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, lobbyAgency.getUniqId());
						ps.setString(2, lobbyAgency.getAgencyId());
						ps.setString(3, lobbyAgency.getAgency());
						ps.executeUpdate();
						ps.close();
						return lobbyAgency;
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
		public void delete(LobbyAgency lobbyAgency) {
				String sql = "DELETE FROM LobbyAgency WHERE Uniqid = ? AND AgencyID = ? AND Agency = ?";

				Connection conn = null;

				try {
						conn = getConnection();
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, lobbyAgency.getUniqId());
						ps.setString(2, lobbyAgency.getAgencyId());
						ps.setString(3, lobbyAgency.getAgency());
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
