/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Place {

    private String placeID;
    private String typeID;
    private String routeID;
    private String placeLocID;
    private String placeImage;

    public String getPlaceID() {
        return placeID;
    }

    public void setPlaceID(String placeID) {
        this.placeID = placeID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getPlaceLocID() {
        return placeLocID;
    }

    public void setPlaceLocID(String placeLocID) {
        this.placeLocID = placeLocID;
    }

    public String getPlaceImage() {
        return placeImage;
    }

    public void setPlaceImage(String placeImage) {
        this.placeImage = placeImage;
    }

    @Override
    public String toString() {
        return "Place{" + "placeID=" + placeID + ", typeID=" + typeID + ", routeID=" + routeID + ", placeLocID=" + placeLocID + ", placeImage=" + placeImage + '}';
    }

}
