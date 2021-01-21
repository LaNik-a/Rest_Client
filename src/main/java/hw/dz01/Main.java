package hw.dz01;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class Main {
    private final static String site = "https://freegeoip.app/json/";

    public static void main(String[] args) {
        try {
            ClientDetailsDto client = Request.Get(site).execute().handleResponse(new RestClient());
            System.out.println(getStructureDetails(client));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }

    /**
     * Получить структурированную к выводу информацию о положении клиента
     * @param client клиент
     * @return информация о местоположении
     */
    public static String getStructureDetails(ClientDetailsDto client) {
        return "Страна: " + client.getCountry_name() + "\n" + "Область: " + client.getRegion_name() +
                "\n" + "Город: " + client.getCity() + "\n" + "Широта: " + client.getLatitude() +
                "\n" + "Долгота: " + client.getLongitude();
    }
}