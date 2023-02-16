package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.*;
import org.example.models.resources.Resources;
import org.example.models.TokenModel;
import java.io.IOException;
import com.neovisionaries.ws.client.WebSocket;

import com.neovisionaries.ws.client.*;

public class Network {

        /**
         * Fetch the token using the client-credentials flow. In this case, we assume
         * that the user wants to fetch a token
         * that will be used to receive the accessible buildings. Once the user knows
         * the building of interest,
         * a new token has to be generated with the correct callgiving/BUILDING_ID in
         * scope.
         */
        public static String getTocken(String scope) throws IOException {
                OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody body = RequestBody.create(
                                "grant_type=client_credentials&scope=" + scope,
                                mediaType);
                Request request = new Request.Builder()
                                .url("https://dev.kone.com/api/v2/oauth2/token")
                                .method("POST", body)
                                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                                .addHeader("Accept", "application/json")
                                .addHeader("Authorization",
                                                "Basic MjUxOGRlYmYtZmI2Ny00OTFmLWE3NTMtOWQ0MzdhMTAzOTg1OjQ0Zjc3YjJjZGYzOTNmOGIwYTliNTcxMDE5OGQxNjYwMzFlYTJhY2MyMDNlNmZlMDZkZDhiNzEyMWU3MDRmNzI=")
                                .build();

                Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                TokenModel obj = gson.fromJson(response.body().string(), TokenModel.class);

                return obj.getAccess_token();
        }

        /**
         * returns and array of resource identifiers to which the user has access to
         * In order to successfully make this call, it is needed a token which in scope
         * has
         * application/inventory
         */
        public static Resources fetchResources(String accessToken) throws IOException {
                OkHttpClient client = new OkHttpClient().newBuilder()
                                .build();
                Request request = new Request.Builder()
                                .url("https://dev.kone.com/api/v2/application/self/resources")
                                .method("GET", null)
                                .addHeader("Accept", "application/json")
                                .addHeader("Authorization", "Bearer " + accessToken)
                                .build();
                Response response = client.newCall(request).execute();
                Gson gson = new Gson();
                Resources resources = gson.fromJson(response.body().string(), Resources.class);
                return resources;
        }

        public static void fetchConfigs(String targetBuildingId, WebSocket ws) {
                JsonObject config = new JsonObject();
                config.addProperty("type", "common-api");
                config.addProperty("requestId", Utils.getUUIDv4());
                config.addProperty("buildingId", "building:" + targetBuildingId);
                config.addProperty("callType", "config");
                config.addProperty("groupId", "1");

                ws.sendText(config.toString());
        }

        public static void fetchActions(String targetBuildingId, WebSocket ws) {
                JsonObject actions = new JsonObject();
                actions.addProperty("type", "common-api");
                actions.addProperty("requestId", Utils.getUUIDv4());
                actions.addProperty("buildingId", "building:" + targetBuildingId);
                actions.addProperty("callType", "actions");
                actions.addProperty("groupId", "1");

                ws.sendText(actions.toString());
        }

        public static void callLeft(String targetBuildingId, WebSocket ws) {
                JsonObject liftCallPayload = new JsonObject();
                liftCallPayload.addProperty("type", "lift-call-api-v2");
                liftCallPayload.addProperty("buildingId", "building:" + targetBuildingId);
                liftCallPayload.addProperty("callType", "action");
                liftCallPayload.addProperty("groupId", "1");

                JsonObject payload = new JsonObject();
                payload.addProperty("request_id", Utils.getRequestId());
                // payload.addProperty("media_type", "RFID");
                // payload.addProperty("media_id","0009");
                // payload.addProperty("media_cc","1b");
                Number area01 = Main.destinations.get(9).getArea_id();
                payload.addProperty("area", area01);
                payload.addProperty("time", Utils.getTime());
                payload.addProperty("terminal", Main.destinations.get(9).getTerminals().get(0));

                JsonObject call = new JsonObject();
                call.addProperty("action", 2);
                // JsonArray arr = new JsonArray();
                // arr.add("1001010");
                // // arr.add("");
                // call.add("allowed_lifts", arr);
                //
                Number des = Main.destinations.get(11).getArea_id();
                call.addProperty("destination", des);
                // call.addProperty("delay",40);
                payload.add("call", call);
                liftCallPayload.add("payload", payload);

                System.out.println(liftCallPayload);
                String ss = liftCallPayload.toString();
                System.out.println("Lift Call:");

                ws.sendText(ss);
        }

        public static void callState(String targetBuildingId, WebSocket ws) {
                JsonObject monitoring = new JsonObject();
                monitoring.addProperty("type", "site-monitoring");
                monitoring.addProperty("requestId", Utils.getUUIDv4());
                monitoring.addProperty("callType", "monitor");
                monitoring.addProperty("buildingId", "building:" + targetBuildingId);
                monitoring.addProperty("groupId", "1");

                JsonObject payload = new JsonObject();
                payload.addProperty("sub", "f01cc3d6-50bf-4d7f-b253-767a09dd095c");
                payload.addProperty("duration", 300);
                JsonArray arr = new JsonArray();
                String ss = "call_state/" + Main.leftCall.getData().getSession_id() + "/fixed";
                arr.add(ss);
                payload.add("subtopics", arr);

                monitoring.add("payload", payload);

                ws.sendText(monitoring.toString());
        }

        public static void callSubtopics(String targetBuildingId, WebSocket ws) {
                JsonObject monitoring_left_status = new JsonObject();
                monitoring_left_status.addProperty("type", "site-monitoring");
                monitoring_left_status.addProperty("requestId", Utils.getUUIDv4());
                monitoring_left_status.addProperty("callType", "monitor");
                monitoring_left_status.addProperty("buildingId", "building:" + targetBuildingId);
                monitoring_left_status.addProperty("groupId", "1");

                JsonObject payload = new JsonObject();
                payload.addProperty("sub", "f01cc3d6-50bf-4d7f-b253-767a09dd095c");
                payload.addProperty("duration", 300);
                JsonArray arr = new JsonArray();
                String lift_status = "lift_" + Main.leftId + "/status";
                arr.add(lift_status);
                // String lift_stopping = "lift_"+leftId+"/stopping";
                // arr.add(lift_stopping);
                // String lift_doors = "lift_"+leftId+"/doors";
                // arr.add(lift_doors);
                // String lift_next_stop_eta = "lift_"+leftId+"/next_stop_eta";
                // arr.add(lift_next_stop_eta);
                payload.add("subtopics", arr);

                monitoring_left_status.add("payload", payload);
                System.out.println("Left Status:");
                ws.sendText(monitoring_left_status.toString());
        }

        /**
         * Establish WebSocket connection and create a session. Automatically reconnects
         * and resumes the session. Resolves after session has been created and rejects
         * if initial connection or session creation fails.
         */
        public static WebSocket openWebSocketConnection(String accessToken) throws IOException, WebSocketException {
                WebSocket ws = new WebSocketFactory()
                                .createSocket("wss://dev.kone.com/stream-v2?accessToken=" + accessToken);
                ws.addProtocol("koneapi");
                ws.connect();
                ws.addListener(new WebSocketAdapter() {
                        @Override
                        public void onTextMessage(WebSocket websocket, String message) throws Exception {
                                Utils.handleSocketResponse(message, ws);
                        }

                });
                return ws;
        }

}
