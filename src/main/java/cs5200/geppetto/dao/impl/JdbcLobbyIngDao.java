package cs5200.geppetto.dao.impl;

import cs5200.geppetto.dao.LobbyingDao;
import cs5200.geppetto.model.Lobbying;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JdbcLobbyIngDao extends MyJdbcDaoSupport implements LobbyingDao {

    @Override
    public Lobbying create(Lobbying lobbying) {
		String sql = "INSERT INTO Lobbying " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			if(affectedRows == 0) {
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
				} catch (SQLException e) {}
			}
		}
    }

	@Override
	public Lobbying get(Lobbying lobbyingGetter) {
		String sql = "SELECT * FROM Lobbying WHERE uniqid = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lobbyingGetter.getUniqId());
			ResultSet rs = ps.executeQuery();
            Lobbying lobbying = null;
			if(rs.next()) {
				lobbying = new Lobbying(
						rs.getString("uniqid"),
						rs.getString("registrant_raw"),
						rs.getString("registrant"),
						rs.getString("isfirm"),
						rs.getString("client_raw"),
						rs.getString("client"),
						rs.getString("ultorg"),
						rs.getFloat("amount"),
						rs.getString("catcode"),
						rs.getString("source"),
						rs.getString("self"),
						rs.getString("IncludeNSFS"),
						rs.getString("use"),
						rs.getString("ind"),
						rs.getString("year"),
						rs.getString("type"),
						rs.getString("typelong"),
						rs.getString("affiliate")
				);
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
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public Lobbying update(Lobbying lobbying) {
		String sql = "UPDATE LobbyIndus SET " +
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
				"use = ?, " +
				"ind = ?, " +
				"year = ?, " +
				"type = ?, " +
				"typeLong = ?, " +
				"affiliate = ?, " +
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
				} catch (SQLException e) {}
			}
		}
	}

    @Override
    public void delete(Lobbying lobbying) {
		String sql = "DELETE FROM Lobbying WHERE uniqid = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, lobbying.getUniqId());
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
