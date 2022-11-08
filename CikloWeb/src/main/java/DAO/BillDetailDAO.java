package DAO;

import Connect.DBUtils;
import java.util.*;
import java.sql.*;
import Model.*;

public class BillDetailDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<BillDetail> getDetailOf(String id) {
        String query = "  select * from billdetail where billID = ? order by OrderOfRoute asc";
        ArrayList<BillDetail> list = new ArrayList<>();
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add( new BillDetail(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3)
                ));
            }
        } catch (Exception e) {
             System.out.println("bill detail dao: " + e.getMessage());
        }
        return list;
    }
}
