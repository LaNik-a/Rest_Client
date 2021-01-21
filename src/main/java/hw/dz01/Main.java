package hw.dz01;

import org.apache.http.client.fluent.Request;

public class Main {
    private final static String MY_IP = "95.26.149.108";

    public static void main(String[] args) throws Exception {
        Client client = new Client(MY_IP);
        App appResponse = Request.Get(client.getService()).execute().handleResponse(new AppResponseHandler());
        System.out.println(appResponse.getInfoClient());
    }
}