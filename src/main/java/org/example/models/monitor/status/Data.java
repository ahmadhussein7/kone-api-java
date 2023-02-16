package org.example.models.monitor.status;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private String time;
    private int lift_mode;
    private boolean in_bank;
    private int nominal_speed;
    private List<Deck> decks = new ArrayList<Deck>();

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLift_mode() {
        return lift_mode;
    }

    public void setLift_mode(int lift_mode) {
        this.lift_mode = lift_mode;
    }

    public boolean isIn_bank() {
        return in_bank;
    }

    public void setIn_bank(boolean in_bank) {
        this.in_bank = in_bank;
    }

    public int isNominal_speed() {
        return nominal_speed;
    }

    public void setNominal_speed(int nominal_speed) {
        this.nominal_speed = nominal_speed;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }
}
