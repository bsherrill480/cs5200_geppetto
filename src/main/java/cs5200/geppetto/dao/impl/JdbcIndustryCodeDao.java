package cs5200.geppetto.dao.impl;

import cs5200.geppetto.dao.IndustryCodeDao;
import cs5200.geppetto.model.IndustryCode;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class JdbcIndustryCodeDao extends MyJdbcDaoSupport implements IndustryCodeDao {

    @Override
    public IndustryCode create(IndustryCode industryCode) {
		String sql = "INSERT INTO IndusCodes VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		try {
		    conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, industryCode.getCatCode());
			ps.setString(2, industryCode.getCatName());
			ps.setString(3, industryCode.getCatOrder());
			ps.setString(4, industryCode.getIndustry());
			ps.setString(5, industryCode.getSector());
			ps.setString(6, industryCode.getSectorLong());
			int affectedRows = ps.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("Creating IndustryCode failed, no rows affected.");
			}
			ps.close();
		    return industryCode;
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
    public IndustryCode getByCatCode(String catCode) {
		String sql = "SELECT * FROM IndusCodes WHERE Catcode = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, catCode);
			ResultSet rs = ps.executeQuery();
			IndustryCode industryCode = null;
			if(rs.next()) {
				industryCode = new IndustryCode(
						rs.getString("Catcode"),
						rs.getString("Catname"),
						rs.getString("Catorder"),
						rs.getString("Industry"),
						rs.getString("Sector"),
						rs.getString("SectorLong")
				);
			}
			rs.close();
			ps.close();
			return industryCode;
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
	public IndustryCode update(IndustryCode industryCode) {
		String sql = "UPDATE IndusCodes SET Catname = ?, Catorder = ?, Industry = ?, Sector = ?, " +
				"SectorLong = ? WHERE Catcode = ?";
		Connection conn = null;
		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, industryCode.getCatName());
			ps.setString(2, industryCode.getCatOrder());
			ps.setString(3, industryCode.getIndustry());
			ps.setString(4, industryCode.getSector());
			ps.setString(5, industryCode.getSectorLong());
			ps.setString(6, industryCode.getCatCode());
			ps.executeUpdate();
			ps.close();
            return industryCode;
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
    public void delete(IndustryCode industryCode) {
		String sql = "DELETE FROM IndusCodes WHERE Catcode = ?";

		Connection conn = null;

		try {
            conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, industryCode.getCatCode());
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
