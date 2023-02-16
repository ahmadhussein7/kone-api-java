package org.example.models.monitor.door;

import java.util.List;

public class Data {

    private String time;
    private int area;
    private int lift_side;
    private String state;
    private int landing;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLift_side() {
        return lift_side;
    }

    public void setLift_side(int lift_side) {
        this.lift_side = lift_side;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLanding() {
        return landing;
    }

    public void setLanding(int landing) {
        this.landing = landing;
    }
}
