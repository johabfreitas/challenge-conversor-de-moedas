# 💱 Conversor de Moedas com ExchangeRate API

Este projeto Java realiza a conversão de moedas utilizando a [ExchangeRate API](https://www.exchangerate-api.com/). Ele consome a API via requisição HTTP e exibe o valor convertido com base na moeda de origem, destino e o valor informado.

## 🚀 Tecnologias Utilizadas

- Java 11+ (uso do `HttpClient`)
- Gson (para desserialização do JSON)
- ExchangeRate API (versão v6)
- Arquivo de configuração `.properties`

## 📁 Estrutura do Projeto
src/
├── ExchangerateApiService.java # Serviço principal de conversão
├── ExchangerateApi.java # Classe modelo para mapeamento do JSON (POJO)
└── config.properties # Arquivo de configuração com a chave da API


## ⚙️ Pré-requisitos

- Java 11 ou superior
- Biblioteca [Gson](https://github.com/google/gson) adicionada ao classpath
- Conta gratuita na ExchangeRate API com uma chave de API

## 🛠️ Como Usar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/johabfreitas/challenge-conversor-de-moedas.git

2. Adicione o arquivo config.properties na raiz ou pasta src/ contendo sua chave da API:
   api.key=SUA_CHAVE_AQUI

3. Exemplo de uso do serviço:

   `public class Main {`
   	   `public static void main(String[] args) throws IOException {`
   	     `ExchangerateApiService service = new ExchangerateApiService();`
   	`	    service.aplicarConversao("USD", "BRL", 100);`
   	       `}`
   `}`

4. Resultado esperado:
   Valor 100.00[USD] corresponde ao valor final de =>> 532.80[BRL]



