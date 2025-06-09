public class ExchangerateApiService {

    public String aplicarConversao(String apiKey, String moedaEntrada, String moedaSaida){

        return "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + moedaEntrada + "/" + moedaSaida;
    }
}
