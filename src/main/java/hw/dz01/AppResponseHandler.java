package hw.dz01;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.ContentResponseHandler;

import java.io.IOException;

class AppResponseHandler implements ResponseHandler<App> {
    @Override
    /*
      Обрабатывает HttpResponse и возвращает некоторое значение, соответствующее этому ответу.
     */
    public App handleResponse(HttpResponse httpResponse) throws IOException {
        // Сущность, которая может быть получена с помощью HTTP-сообщения.
        HttpEntity entity = httpResponse.getEntity();
        // Сущность, с помощью которой сообщения HttpResponse могут преобразовываться в экземпляры контента.
        ContentResponseHandler contentHandler = new ContentResponseHandler();
        return new App(
                httpResponse.getStatusLine().getStatusCode(),
                contentHandler.handleEntity(entity).asString());
    }
}