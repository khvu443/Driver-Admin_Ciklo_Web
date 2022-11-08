/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Connect.DBUtils;
import java.util.*;
import java.sql.*;
import Model.*;

public class CustomerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Customer getCustomerBy(String acc, String pass) {
        String query = "select * from customer where cusMail = ? or cusUserName = ? and cusPass = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, acc);
            ps.setString(3, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> cl = new ArrayList<>();
        String query = "select * from customer";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.add(new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception ex) {

        }
        return cl;
    }

    public void addCustomer(String id, String name, String mail, String user, String pass, String phone) {
        String query = "insert into customer values (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, mail);
            ps.setString(4, user);
            ps.setString(5, pass);
            ps.setString(6, phone);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error add" + e.getMessage());
        }
    }

    public Customer getInforBy(String id) {
        String query = "select * from Customer where cusID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Customer updateAccount(String id, Customer cus) {
        String query = "update Customer set cusName = ?, cusMail = ?, cusUserName=?, cusPass=?, cusPhone=? where cusID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, cus.getCusName());
            ps.setString(2, cus.getCusMail());
            ps.setString(3, cus.getCusUserName());
            ps.setString(4, cus.getCusPass());
            ps.setString(5, cus.getCusPhone());
            ps.setString(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
