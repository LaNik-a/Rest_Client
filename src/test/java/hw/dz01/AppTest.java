package hw.dz01;

import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка парсинга json")
    void getInfoClient() throws IOException {
        Client client1 = new Client("");
        App appResponse1 = Request.Get(client1.getService()).execute().handleResponse(new AppResponseHandler());
        String expectedStr1 = "Страна: Russia\n" + "Область: Moscow\n" + "Город: Moscow\n" +
                "Широта: 37.6172\n" + "Долгота: 55.7527\n";
        assertEquals(expectedStr1, appResponse1.getInfoClient());
        Client client2 = new Client("test123456789");
        App appResponse2 = Request.Get(client2.getService()).execute().handleResponse(new AppResponseHandler());
        String expectedStr2 = "При запросе произошла ошибка {status: 404}";
        assertEquals(expectedStr2, appResponse2.getInfoClient());
    }
}