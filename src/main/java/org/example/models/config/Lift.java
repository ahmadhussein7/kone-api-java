package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Lift {
    private int lift_id;
    private String lift_name;
    private List<Deck> decks;
    private List<Floor> floors;

    public int getLift_id() {
        return lift_id;
    }

    public void setLift_id(int lift_id) {
        this.lift_id = lift_id;
    }

    public String getLift_name() {
        return lift_name;
    }

    public void setLift_name(String lift_name) {
        this.lift_name = lift_name;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
