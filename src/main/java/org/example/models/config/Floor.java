package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Floor {

    private int lift_floor_id;

    private int group_floor_id;
    private int height;
    private List<Side> sides;

    public int getLift_floor_id() {
        return lift_floor_id;
    }

    public void setLift_floor_id(int lift_floor_id) {
        this.lift_floor_id = lift_floor_id;
    }

    public int getGroup_floor_id() {
        return group_floor_id;
    }

    public void setGroup_floor_id(int group_floor_id) {
        this.group_floor_id = group_floor_id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Side> getSides() {

        return sides;
    }

    public void setSides(List<Side> sides) {
        this.sides = sides;
    }
}
