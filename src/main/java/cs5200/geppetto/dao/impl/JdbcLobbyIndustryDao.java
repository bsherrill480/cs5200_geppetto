package cs5200.geppetto.dao.impl;

import cs5200.geppetto.dao.LobbyIndustryDao;
import cs5200.geppetto.model.LobbyIndustry;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcLobbyIndustryDao extends MyJdbcDaoSupport implements LobbyIndustryDao {

    @Override
    public LobbyIndustry create(LobbyIndustry lobbyIndustry) {
		String sql = "INSERT INTO LobbyIndus VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
		    conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lobbyIndustry.getClient());
			ps.setString(2, lobbyIndustry.getSub());
			ps.setFloat(3, lobbyIndustry.getTotal());
			ps.setString(4, lobbyIndustry.getYear());
			ps.setString(5, lobbyIndustry.getCatcode());
			int affectedRows = ps.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("Creating LobbyIndustry failed, no rows affected.");
			}
			ps.close();
		    return lobbyIndustry;
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
    public List<LobbyIndustry> getByClient(String client) {
		String sql = "SELECT * FROM LobbyIndus WHERE client = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, client);
			ResultSet rs = ps.executeQuery();
			List<LobbyIndustry> lobbyIndustries = new ArrayList<LobbyIndustry>();
			while (rs.next()) {
				LobbyIndustry lobbyIndustry = new LobbyIndustry(
						rs.getString("client"),
						rs.getString("sub"),
						rs.getFloat("total"),
						rs.getString("year"),
						rs.getString("catcode")
				);
				lobbyIndustries.add(lobbyIndustry);
			}
			rs.close();
			ps.close();
			return lobbyIndustries;
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
	public LobbyIndustry get(LobbyIndustry lobbyIndustryGetter) {
		String sql = "SELECT * FROM LobbyIndus WHERE client = ? AND sub = ? AND year = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lobbyIndustryGetter.getClient());
			ps.setString(2, lobbyIndustryGetter.getSub());
			ps.setString(3, lobbyIndustryGetter.getYear());
			ResultSet rs = ps.executeQuery();
            LobbyIndustry lobbyIndustry = null;
			if(rs.next()) {
				lobbyIndustry = new LobbyIndustry(
						rs.getString("client"),
						rs.getString("sub"),
						rs.getFloat("total"),
						rs.getString("year"),
						rs.getString("catcode")
				);
			}
			rs.close();
			ps.close();
			return lobbyIndustry;
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
	public LobbyIndustry update(LobbyIndustry lobbyIndustry) {
		String sql = "UPDATE LobbyIndus SET client = ?, sub = ?, total = ?, year = ?, catcode = ?" +
				" WHERE client = ? AND sub = ? AND year = ?";
		Connection conn = null;
		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lobbyIndustry.getClient());
			ps.setString(2, lobbyIndustry.getSub());
			ps.setFloat(3, lobbyIndustry.getTotal());
			ps.setString(4, lobbyIndustry.getYear());
			ps.setString(5, lobbyIndustry.getCatcode());
			ps.setString(6, lobbyIndustry.getClient());
			ps.setString(7, lobbyIndustry.getSub());
			ps.setString(8, lobbyIndustry.getYear());
			ps.executeUpdate();
			ps.close();
            return lobbyIndustry;
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
    public void delete(LobbyIndustry lobbyIndustry) {
		String sql = "DELETE FROM LobbyIndus WHERE client = ? AND sub = ? AND year = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lobbyIndustry.getClient());
			ps.setString(2, lobbyIndustry.getSub());
			ps.setString(3, lobbyIndustry.getYear());
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
