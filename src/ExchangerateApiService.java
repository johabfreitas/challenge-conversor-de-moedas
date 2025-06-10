import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ExchangerateApiService {

    public Double aplicarConversao(String moedaEntrada, String moedaSaida, Double amount ) throws IOException {

        //Leitura de arquivo externo que contem a chave API para requisição
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String apiKey = props.getProperty("api.key");

        final String URL_INICIAL = "https://v6.exchangerate-api.com/v6/";
        String url_str = URL_INICIAL + apiKey + "/pair/" + moedaEntrada + "/" + moedaSaida + "/" + amount;

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
                System.out.println(exchangerate_api.conversion_result());
                System.out.println(String.format("Valor .2%f[%s] corresponde ao valor final de =>> .%2f[%s]",));
            } else {
                System.out.println("Erro: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
