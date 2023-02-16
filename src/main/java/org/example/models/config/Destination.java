package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Destination {
    private int area_id;

    private int group_floor_id;

    private int group_side;

    private String short_name;
    private boolean exit;

    private List<Integer> terminals;

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getGroup_floor_id() {
        return group_floor_id;
    }

    public void setGroup_floor_id(int group_floor_id) {
        this.group_floor_id = group_floor_id;
    }

    public int getGroup_side() {
        return group_side;
    }

    public void setGroup_side(int group_side) {
        this.group_side = group_side;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public List<Integer> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Integer> terminals) {
        this.terminals = terminals;
    }

    @Override
    public String toString() {
        return short_name + " - " + area_id;
    }
}
