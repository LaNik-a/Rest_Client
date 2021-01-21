package hw.dz01;

public class Client {

    private final String service;

    Client(String ip) {
        service = "https://freegeoip.app/json/" + ip;
    }

    /**
     * Получение адреса сайта
     *
     * @return адрес сайта
     */
    public String getService() {
        return service;
    }

}
