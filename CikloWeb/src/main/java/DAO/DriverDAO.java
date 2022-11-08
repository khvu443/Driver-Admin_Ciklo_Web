package DAO;

import Connect.DBUtils;
import java.util.*;
import java.sql.*;
import Model.Driver;

public class DriverDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Driver> getAllDriver() {
        ArrayList<Driver> dl = new ArrayList<>();
        String query = "select * from driver";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                dl.add(new Driver(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getBoolean(12)
                ));
            }
        } catch (Exception ex) {

        }
        return dl;
    }

    public Driver getDriverBy(String acc, String pass) {
        String query = "select * from driver where driverUserName = ? and driverPass = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, acc);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Driver(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getBoolean(12)
                );
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public Driver getDriverInfo(String id) {
        String query = "select * from driver where driverID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Driver(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getBoolean(9),
                        rs.getBoolean(10),
                        rs.getString(11),
                        rs.getBoolean(12)
                );
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public void updateDriver(String id, String name, String username, String password, String email, String phone, String avatar, boolean gender) {
        String query = "update Driver set driverName = ?, driverUserName = ?, driverPass = ?, driverMail = ?, driverPhone = ?, driverAvatar = ?,  driverGender= ? where driverID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setString(6, avatar);
            ps.setBoolean(7, gender);
            ps.setString(8, id);

            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public void updateDriver(String id, String name, String email, String phone, boolean gender, String CCCD) {
        String query = "update Driver set driverName = ?, driverMail = ?, driverPhone = ?, driverCCCD = ?,  driverGender= ? where driverID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, CCCD);
            ps.setBoolean(5, gender);
            ps.setString(6, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("update error");
        }
    }

    public void updateDriverStation(String id, String stationID) {
        String query = "update Driver set CurrentStation = ? where driverID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, stationID);
            ps.setString(2, id);

            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public void deleteDriver(String id, boolean status) {
        String query = "update Driver set isActive = ? where driverID = ?";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setBoolean(1, status);
            ps.setString(2, id);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public void addDriver(Driver driver) {
        String query = "insert into driver values(?,?,?,?,?,?,?,?,?,1,'ST1',1)";
        try {
            conn = new DBUtils().makeConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, driver.getDriverID());
            ps.setString(2, driver.getDriverName());
            ps.setString(3, driver.getDriverUserName());
            ps.setString(4, driver.getDriverPass());
            ps.setString(5, driver.getDriverMail());
            ps.setString(6, driver.getDriverPhone());
            ps.setString(7, driver.getDriverAvatar());
            ps.setString(8, driver.getDriverCCCD());
            ps.setBoolean(9, driver.isDriverGender());
            
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Driver Add Error");
        }
    }

}
