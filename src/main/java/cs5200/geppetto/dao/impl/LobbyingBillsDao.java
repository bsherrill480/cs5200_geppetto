package cs5200.geppetto.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import cs5200.geppetto.dao.LobbyingBillsInterface;
import cs5200.geppetto.model.LobbyingBills;

@Service
public class LobbyingBillsDao extends MyJdbcDaoSupport implements LobbyingBillsInterface {

  @Override
  public LobbyingBills create(LobbyingBills lobbyingbill) {
    String insertLobbyBills =
        "INSERT INTO lob_bills(B_ID, si_ID, CongNo, Bill_Name) " + "VALUES(?,?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = getConnection();
      insertStmt = connection.prepareStatement(insertLobbyBills);
      insertStmt.setString(1, lobbyingbill.getB_ID());
      insertStmt.setInt(2, lobbyingbill.getSi_ID());
      insertStmt.setString(3, lobbyingbill.getCongNo());
      insertStmt.setString(4, lobbyingbill.getBillName());

      insertStmt.executeUpdate();
      return lobbyingbill;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  // @Override
  // public List<LobbyingBills> getLobbyingBills(Integer siId) {
  // String sql = "SELECT * FROM lob_bills WHERE si_id = ?";
  // Connection conn = null;
  // try {
  // conn = getConnection();
  // PreparedStatement ps = conn.prepareStatement(sql);
  // ps.setInt(1, siId);
  // ResultSet rs = ps.executeQuery();
  // List<LobbyingBills> lobbyingbills = new ArrayList<LobbyingBills>();
  // while (rs.next()) {
  // LobbyingBills lobbyingbill = new LobbyingBills(rs.getString("B_ID"), rs.getInt("si_id"),
  // rs.getString("CongNo"), rs.getString("Bill_Name"));
  // lobbyingbills.add(lobbyingbill);
  // }
  // rs.close();
  // ps.close();
  // return lobbyingbills;
  // } catch (SQLException e) {
  // throw new RuntimeException(e);
  // } finally {
  // if (conn != null) {
  // try {
  // conn.close();
  // } catch (SQLException e) {
  // }
  // }
  // }
  // }
  //

  @Override
  public LobbyingBills update(LobbyingBills lobbybill) {
    String updateLobbyingbill = "UPDATE lob_bills SET B_ID=?, si_id=?, CongNo=?, Bill_Name=? "
        + "WHERE B_ID=? AND si_id=? AND CongNo=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = getConnection();
      updateStmt = connection.prepareStatement(updateLobbyingbill);
      updateStmt.setString(1, lobbybill.getB_ID());
      updateStmt.setInt(2, lobbybill.getSi_ID());
      updateStmt.setString(3, lobbybill.getCongNo());
      updateStmt.setString(4, lobbybill.getBillName());
      updateStmt.setString(5, lobbybill.getB_ID());
      updateStmt.setInt(6, lobbybill.getSi_ID());
      updateStmt.setString(7, lobbybill.getCongNo());

      updateStmt.executeUpdate();
      updateStmt.close();
      return lobbybill;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  @Override
  public LobbyingBills delete(LobbyingBills lobbybill) {
    String deleteLobbyist = "DELETE FROM lob_bills WHERE B_ID=? AND si_id=? AND CongNo=?";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = getConnection();
      deleteStmt = connection.prepareStatement(deleteLobbyist);
      deleteStmt.setString(1, lobbybill.getB_ID());
      deleteStmt.setInt(2, lobbybill.getSi_ID());
      deleteStmt.setString(3, lobbybill.getCongNo());

      deleteStmt.executeUpdate();
      deleteStmt.close();
      return lobbybill;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
  }

  @Override
  public LobbyingBills getLobbyingBill(String B_ID) {
    String sql = "SELECT * FROM lob_bills WHERE B_ID = ?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet rs = null;
    try {
      connection = getConnection();
      selectStmt = connection.prepareStatement(sql);
      selectStmt.setString(1, B_ID);
      rs = selectStmt.executeQuery();
      if (rs.next()) {
        LobbyingBills lobbyingbill = new LobbyingBills(rs.getString("B_ID"), rs.getInt("si_id"),
            rs.getString("CongNo"), rs.getString("Bill_Name"));
        return lobbyingbill;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
        }
      }
    }
    return null;
  }

  @Override
  public List<LobbyingBills> getLobbyingBills(Integer siId) {
    // TODO Auto-generated method stub
    return null;
  }

}
