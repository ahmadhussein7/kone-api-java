package org.example.models.monitor.nextStopEta;

import java.util.List;

public class Data {
    String time;
    String eta;
    List<DeckEta> decks;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public List<DeckEta> getDecks() {
        return decks;
    }

    public void setDecks(List<DeckEta> decks) {
        this.decks = decks;
    }
}
