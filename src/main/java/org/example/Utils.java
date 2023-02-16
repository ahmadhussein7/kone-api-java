package org.example;

import com.google.gson.Gson;
import com.neovisionaries.ws.client.WebSocket;

import org.example.models.actions.Actions;
import org.example.models.config.*;
import org.example.models.liftcall.LeftCall;
import org.example.models.monitor.call.CallStatus;
import org.example.models.monitor.status.LiftStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    static Gson gson = new Gson();
    private static int requestId = 11111111;
    
    public static int getRequestId() {
        return requestId++;
    }

    public static String getTime() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    public static String getUUIDv4() {
        return UUID.randomUUID().toString();
    }

    public static int getLeftId(List<Integer> allocated_lift_deck){
        for (Group group:
                Main.groups) {
            for (Lift lift :
                    group.getLifts()) {
                for (Deck deck :
                        lift.getDecks()) {
                    for (int area:
                            allocated_lift_deck) {
                        if (deck.getArea_id() == area){

                            return lift.getLift_id();
                        }
                    }

                }
            }
        }
        return -1;
    }
    

    public static void handleSocketResponse(String message, WebSocket ws){

        System.out.print(message);

        if(message.contains("callType")){

            if(message.contains("\"callType\":\"config\"")){

                Config config = gson.fromJson(message, Config.class);
                Main.destinations = config.getData().getDestinations();
                Main.groups = config.getData().getGroups();    
                
                Network.fetchActions(Main.targetBuildingId, ws);               

            }
            else if (message.contains("\"callType\":\"actions\"")) {
                Actions actions = gson.fromJson(message, Actions.class);
                Main.callTypes = actions.getActionsData().getCall_types();

                Network.callLeft(Main.targetBuildingId, ws);

            }
            else if (message.contains("\"callType\":\"action\"")) {
                Main.leftCall = gson.fromJson(message, LeftCall.class);
                Network.callState(Main.targetBuildingId, ws);
            }
            else if(message.contains("\"callType\":\"monitor\"")){

                if(message.contains("/fixed")){
                    CallStatus status = gson.fromJson(message, CallStatus.class);

                    Main.leftId = getLeftId(status.getData().getAllocated_lift_deck());
                    Main.deck_lift = status.getData().getAllocated_lift_deck().get(0);
                    Main.eta = status.getData().getEta();
                    Network.callSubtopics(Main.targetBuildingId, ws);
                    
                }

                else if(message.contains("/status")){
                    LiftStatus status = new LiftStatus();
                    System.out.println("---------------------------------");
                    System.out.println(message);
                    System.out.println("---------------------------------");
                    try {
                        status = gson.fromJson(message, LiftStatus.class);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }


                }

            }

        }

    }

}
