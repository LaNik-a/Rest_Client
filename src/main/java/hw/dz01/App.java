package hw.dz01;

import org.json.JSONObject;

public class App {
    private final int httpStatus;
    private final String jsonBody;

    App(int httpStatus, String jsonBody) {
        this.httpStatus = httpStatus;
        this.jsonBody = jsonBody;
    }

    /**
     * Получение информации о клиенте с сайта
     *
     * @return информация в заданном формате
     */
    public String getInfoClient() {
        if (httpStatus == 200) {
            JSONObject obj = new JSONObject(jsonBody);
            String country_name = obj.getString("country_name");
            String region_name = obj.getString("region_name");
            String city = obj.getString("city");
            double latitude = obj.getDouble("latitude");
            double longitude = obj.getDouble("longitude");
            return "Страна: " + country_name + "\n" + "Область: " + region_name +
                    "\n" + "Город: " + city + "\n" + "Широта: " + longitude +
                    "\n" + "Долгота: " + latitude + "\n";
        } else return "При запросе произошла ошибка {status: " + httpStatus + "}";
    }

}
