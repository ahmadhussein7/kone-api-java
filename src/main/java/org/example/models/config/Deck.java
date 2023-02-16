package org.example.models.config;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Deck {

    private int deck;
    private int area_id;
    private List<Integer> doors;
    private List<Object> terminals;

    public int getDeck() {
        return deck;
    }

    public void setDeck(int deck) {
        this.deck = deck;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public List<Integer> getDoors() {
        return doors;
    }

    public void setDoors(List<Integer> doors) {
        this.doors = doors;
    }

    public List<Object> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Object> terminals) {
        this.terminals = terminals;
    }
}
