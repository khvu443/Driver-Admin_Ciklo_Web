/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class BillDetail {
    private String detailID;
    private String routeID;
    private int OrderOfroute;

    public BillDetail() {
    }

    
    
    public BillDetail(String detailID, String routeID, int OrderOfroute) {
        this.detailID = detailID;
        this.routeID = routeID;
        this.OrderOfroute = OrderOfroute;
    }
    
    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public double getOrderOfroute() {
        return OrderOfroute;
    }

    public void setOrderOfroute(int OrderOfroute) {
        this.OrderOfroute = OrderOfroute;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "detailID=" + detailID + ", routeID=" + routeID +  ", waitingTime=" + OrderOfroute + '}';
    }
    
    
}
