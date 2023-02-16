package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Side {

    private int lift_side;

    private int group_side;

    private List<Integer> decks;

    public int getLift_side() {
        return lift_side;
    }

    public void setLift_side(int lift_side) {
        this.lift_side = lift_side;
    }

    public int getGroup_side() {
        return group_side;
    }

    public void setGroup_side(int group_side) {
        this.group_side = group_side;
    }

    public List<Integer> getDecks() {
        return decks;
    }

    public void setDecks(List<Integer> decks) {
        this.decks = decks;
    }
}
