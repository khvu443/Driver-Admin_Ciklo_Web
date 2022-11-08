/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Driver {

    private String driverID;
    private String driverName;
    private String driverUserName;
    private String driverPass;
    private String driverMail;
    private String driverPhone;
    private String driverAvatar;
    private String driverCCCD;
    private boolean driverGender;
    private boolean driverStatus;
    private String curStation;
    private boolean isActive;

    public Driver() {
    }

    public Driver(String driverID, String driverName, String driverUserName, String driverPass, String driverMail, String driverPhone, String driverAvatar, String driverCCCD, boolean driverGender, boolean driverStatus, String curStation, boolean isActive) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.driverUserName = driverUserName;
        this.driverPass = driverPass;
        this.driverMail = driverMail;
        this.driverPhone = driverPhone;
        this.driverAvatar = driverAvatar;
        this.driverCCCD = driverCCCD;
        this.driverGender = driverGender;
        this.driverStatus = driverStatus;
        this.curStation = curStation;
        this.isActive = isActive;
    }


    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPass() {
        return driverPass;
    }

    public String getDriverUserName() {
        return driverUserName;
    }

    public void setDriverUserName(String driverUserName) {
        this.driverUserName = driverUserName;
    }

    public void setDriverPass(String driverPass) {
        this.driverPass = driverPass;
    }

    public String getDriverMail() {
        return driverMail;
    }

    public void setDriverMail(String driverMail) {
        this.driverMail = driverMail;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverAvatar() {
        return driverAvatar;
    }

    public void setDriverAvatar(String driverAvatar) {
        this.driverAvatar = driverAvatar;
    }

    public String getDriverCCCD() {
        return driverCCCD;
    }

    public void setDriverCCCD(String driverCCCD) {
        this.driverCCCD = driverCCCD;
    }

    public boolean isDriverGender() {
        return driverGender;
    }

    public void setDriverGender(boolean driverGender) {
        this.driverGender = driverGender;
    }

    public boolean isDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getCurStation() {
        return curStation;
    }

    public void setCurStation(String curStation) {
        this.curStation = curStation;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Driver{" + "driverID=" + driverID + ", driverName=" + driverName + ", driverUserName=" + driverUserName + ", driverPass=" + driverPass + ", driverMail=" + driverMail + ", driverPhone=" + driverPhone + ", driverAvatar=" + driverAvatar + ", driverCCCD=" + driverCCCD + ", driverGender=" + driverGender + ", driverStatus=" + driverStatus + ", curStation=" + curStation + ", isActive=" + isActive + '}';
    }

}
