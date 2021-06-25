import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class HelloWorldComponentTest {

    @Test
    public void shouldReturnHelloWorld() {
        // Arrange

        // Act
        String response = makeGetRequest("http://localhost:8080/api/v1/health");
        String expectedResponse = "healthy";

        // Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    private String makeGetRequest(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();

        try {
            return client
                    .send(request, HttpResponse.BodyHandlers.ofString())
                    .body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}