package org.example.models.monitor.call;

import java.util.List;

public class Data {

    private List<Integer> allocated_lift_deck;

    private String cancel_reason;

    private String eta;

    private String user_id;

    private int subgroup_id;

    private int modified_destination;

    private String time;

    private boolean success;

    private String error;

    public List<Integer> getAllocated_lift_deck() {
        return allocated_lift_deck;
    }

    public void setAllocated_lift_deck(List<Integer> allocated_lift_deck) {
        this.allocated_lift_deck = allocated_lift_deck;
    }

    public String getCancel_reason() {
        return cancel_reason;
    }

    public void setCancel_reason(String cancel_reason) {
        this.cancel_reason = cancel_reason;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getSubgroup_id() {
        return subgroup_id;
    }

    public void setSubgroup_id(int subgroup_id) {
        this.subgroup_id = subgroup_id;
    }

    public int getModified_destination() {
        return modified_destination;
    }

    public void setModified_destination(int modified_destination) {
        this.modified_destination = modified_destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
