/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Bill {

    private String billID;
    private String cusID;
    private String driverID;
    private double Total;
    private String Date;

    public Bill() {
    }

    public Bill(String billID, String cusID, String driverID, double total, String Date) {
        this.billID = billID;
        this.cusID = cusID;
        this.driverID = driverID;
        this.Total = total;
        this.Date = Date;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }


    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", cusID=" + cusID + ", driverID=" + driverID + ", Total=" + Total + ", Date=" + Date + '}';
    }

}
