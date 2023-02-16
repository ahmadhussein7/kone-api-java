package org.example;

import com.google.gson.JsonObject;
import com.neovisionaries.ws.client.WebSocket;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.neovisionaries.ws.client.*;
import org.example.models.actions.CallType;
import org.example.models.config.Group;
import org.example.models.liftcall.LeftCall;
import org.example.models.config.Destination;
import org.example.models.resources.Building;

public class Main {

    public static List<Destination> destinations = new ArrayList<>();
    public static List<CallType> callTypes = new ArrayList<>();
    public static List<Group> groups = new ArrayList<>();
    public static LeftCall leftCall = new LeftCall();
    public static int leftId = 0;
    public static int deck_lift =0;
    public static String eta = "";
    public static String targetBuildingId = "joykVHPoOW7";//buildings.get(0).getId();

    
    public static void main(String[] args) throws IOException, URISyntaxException, WebSocketException {
        String token = Network.getTocken("application/inventory robotcall/group:joykVHPoOW7:1");
        System.out.println("AccessToken successfully fetched");

        List<Building> buildings = Network.fetchResources(token).getBuildings();

        WebSocket ws = Network.openWebSocketConnection(token);

        Network.fetchConfigs(targetBuildingId, ws);


    }
}