package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Group {

    private int group_id;
    private List<Integer> terminals;

    private List<Lift> lifts;

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public List<Integer> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Integer> terminals) {
        this.terminals = terminals;
    }

    public List<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(List<Lift> lifts) {
        this.lifts = lifts;
    }
}
