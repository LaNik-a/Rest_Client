package hw.dz01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RestClientTest {

    @Test
    @DisplayName("Проверка парсинга json")
    void getInfoClient() throws IOException {
        String json = "{\"ip\":\"95.26.149.108\",\"country_code\":\"RU\",\"country_name\":\"Russia\"," +
                "\"region_code\":\"MOW\",\"region_name\":\"Moscow\",\"city\":\"Moscow\"," +
                "\"zip_code\":\"125009\",\"time_zone\":\"Europe/Moscow\",\"latitude\":55.7527," +
                "\"longitude\":37.6172,\"metro_code\":0}";
        RestClient client = new RestClient();
        ClientDetailsDto detailsDto = client.getInfoClient(200, json);
        assertEquals("Russia", detailsDto.getCountry_name());
        assertEquals("Moscow", detailsDto.getRegion_name());
        assertEquals("Moscow", detailsDto.getCity());
        assertEquals(37.6172, detailsDto.getLongitude());
        assertEquals(55.7527, detailsDto.getLatitude());
    }
}