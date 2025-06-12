import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ExchangerateApiService exchangerateApiService = new ExchangerateApiService();

        int sair = 1;
        double amount = 0;

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
                    amount = sc.nextDouble();

                    exchangerateApiService.aplicarConversao("USD", "ARS", amount);

                    break;
                case 2:
                    System.out.println("Digite o valor que deseja converter:");
                    amount = sc.nextDouble();

                    exchangerateApiService.aplicarConversao("ARS", "USD", amount);

                    break;
                case 3:
                    System.out.println("Digite o valor que deseja converter:");
                    amount = sc.nextDouble();

                    exchangerateApiService.aplicarConversao("USD", "BRL", amount);

                    break;
                case 4:
                    System.out.println("Digite o valor que deseja converter:");
                    amount = sc.nextDouble();

                    exchangerateApiService.aplicarConversao("BRL", "USD", amount);

                    break;
                case 5:
                    System.out.println("Digite o valor que deseja converter:");
                    amount = sc.nextDouble();

                    exchangerateApiService.aplicarConversao("USD", "COP", amount);

                    break;
                case 6:
                    System.out.println("Digite o valor que deseja converter:");
                    amount = sc.nextDouble();

                    exchangerateApiService.aplicarConversao("COP", "USD", amount);

                    break;
                case 7:
                    sair = 0;
            }
        }

        sc.close();

    }
}