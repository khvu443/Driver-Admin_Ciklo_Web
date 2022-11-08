/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBUtils;
import java.util.*;
import java.sql.*;
import Model.*;

public class BillDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Bill> getAllBillOfDriver(String id) {
        ArrayList<Bill> bl = new ArrayList<>();
        String query = "select * from bill where driverID = ? order by bill.Date asc";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                bl.add(new Bill(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            System.out.println("bill dao: " + e.getMessage());
        }
        return bl;
    }

    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> bl = new ArrayList<>();
        String query = "select * from bill";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                bl.add(new Bill(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            System.out.println("bill dao: " + e.getMessage());
        }
        return bl;
    }

    public Bill getBillBy(String id) {
        String query = "select * from bill where billID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                return new Bill(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            System.out.println("bill dao: " + e.getMessage());
        }
        return null;
    }
}
