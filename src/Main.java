import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        /*Gson gson = new Gson();
        String json = gson.toJson(new String[] {"Java", "Gson", "Modules"});
        System.out.println(json);*/

        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String apiKey = props.getProperty("api.key");

        // Setting URL
        final String API_KEY = "180c181f3fddda1bcbfac0db";
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        /*
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        String req_result = jsonobj.get("documentation").getAsString();
        System.out.println(req_result);
        */

        //Uma nova requisição

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String json = response.body();

                // Converter JSON para objeto Java
                Gson gson = new Gson();
                ExchangerateApi exchangerate_api = gson.fromJson(json, ExchangerateApi.class);

                System.out.println("Objeto convertido:");
                System.out.println(exchangerate_api);
            } else {
                System.out.println("Erro: " + response.statusCode());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}