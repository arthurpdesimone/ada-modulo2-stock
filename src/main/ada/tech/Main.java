package ada.tech;

import ada.tech.service.StockService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Projeto - Módulo 2 Ada");
        System.out.println("Aluno: Arthur Pendragon de Simone");
        System.out.println("=========================INICIO===============================");
        try {
            printConsole();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==========================FIM=================================");
    }
    public static void printConsole() throws IOException, ParseException {
        StockService service = new StockService();
        boolean continueScan = true;
        Scanner scanner = new Scanner(System.in);
        while(continueScan){
            System.out.println("1 - Baixar nova ação");
            System.out.println("QUALQUER ENTRADA - Encerra a aplicação");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Digite o nome (ticker) da ação: Exemplo PETR3.SA");
                    String stock = scanner.next();
                    service.downloadStock(stock);
                    break;
                case 2:

                    break;
                default:
                    continueScan = false;
                    scanner.close();
                    break;
            }
        }
    }
}
