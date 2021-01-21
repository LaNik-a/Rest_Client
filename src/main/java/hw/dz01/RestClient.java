package hw.dz01;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.json.JSONObject;

import java.io.IOException;

public class RestClient implements ResponseHandler<ClientDetailsDto> {


    @Override
    public ClientDetailsDto handleResponse(HttpResponse httpResponse) throws IOException {
        // Сущность, которая может быть получена с помощью HTTP-сообщения.
        HttpEntity entity = httpResponse.getEntity();
        // Сущность, с помощью которой сообщения HttpResponse могут преобразовываться в экземпляры контента.
        ContentResponseHandler contentHandler = new ContentResponseHandler();
        return getInfoClient(httpResponse.getStatusLine().getStatusCode(),
                contentHandler.handleEntity(entity).asString());
    }


    /**
     * Получение информации о клиенте с сайта
     *
     * @return информация в заданном формате
     */
    public ClientDetailsDto getInfoClient(int httpStatus, String jsonBody) throws IOException {

        if (checkConnectionStatus(httpStatus)) {
            JSONObject obj = new JSONObject(jsonBody);
            return new ClientDetailsDto(obj.getString("country_name"), obj.getString("region_name"),
                    obj.getString("city"), obj.getDouble("latitude"), obj.getDouble("longitude"));
        }
        throw new IOException("Страница не найдена!");
    }

    /**
     * Проверка соединения с сайтом
     *
     * @param httpStatus статус соединения
     * @return true - сайт существует и был успешно открыт, иначе false
     */
    public Boolean checkConnectionStatus(int httpStatus) {
        return httpStatus == 200;
    }
}
