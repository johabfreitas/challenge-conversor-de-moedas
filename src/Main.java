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
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int sair = 1;
        double amount = 0;



        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String apiKey = props.getProperty("api.key");

        var exchangerateApiService = new ExchangerateApiService();
        exchangerateApiService.aplicarConversao(apiKey, ARS, BRL);

        System.out.println("************************************************\n" +
                "Seja bem-vindo(a) ao Conversor de Moedas\n");

        while(sair == 1){

            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");

            System.out.println("Escolha uma opção válida:\n" +
                    "************************************************");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor que deseja converter:");


                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    sair = 0;
            }
        }

        // Setting URL
        final String URL_INICIAL = "https://v6.exchangerate-api.com/v6/";
        String url_str = URL_INICIAL + apiKey + "/pair/USD/BRL/" + amount;

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
            } else {
                System.out.println("Erro: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        sc.close();

    }
}