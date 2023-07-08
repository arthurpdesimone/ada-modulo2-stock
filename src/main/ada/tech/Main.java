package ada.tech;

import ada.tech.model.Stock;
import ada.tech.service.StockService;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Projeto - Módulo 2 Ada");
        System.out.println("Aluno: Arthur Pendragon de Simone");
        System.out.println("=========================INICIO===============================");
        printConsole();
        System.out.println("==========================FIM=================================");
    }
    public static void printConsole() {
        StockService service = new StockService();
        boolean continueScan = true;
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedList<Stock>> stocksMap = new HashMap<>();
        while(continueScan){
            try{
            System.out.println("==============================================================");
            System.out.println("1 - Baixar nova ação");
            System.out.println("2 - Listar preços de uma ação");
            System.out.println("3 - Ordenar ação por data");
            System.out.println("4 - Remover duplicatas de uma ação");
            System.out.println("QUALQUER OUTRA ENTRADA - Encerra a aplicação");
            String input = scanner.next();
            switch (input){
                case "1":
                    String stock = promptTicker(scanner);
                    LinkedList<Stock> stocks = (LinkedList<Stock>) service.downloadStock(stock);
                    //Inserindo duplicatas propositalmente
                    stocks.addAll(stocks);
                    System.out.println("Tamanho atual da lista de ações da "+stock+" "+stocks.size());
                    stocksMap.put(stock,stocks);
                    break;
                case "2":
                    String stockToShowPrice = promptTicker(scanner);
                    LinkedList<Stock> stockPrice = stocksMap.get(stockToShowPrice);
                    service.listStocks(stockPrice);
                    break;
                case "3":
                    String stockToOrder = promptTicker(scanner);
                    service.orderStocks(stocksMap.get(stockToOrder));
                    service.listStocks(stocksMap.get(stockToOrder));
                    break;
                case "4":
                    String stockToRemoveDuplicates = promptTicker(scanner);
                    service.removeDuplicateStocks(stocksMap.get(stockToRemoveDuplicates));
                    break;
                default:
                    continueScan = false;
                    scanner.close();
                    break;
            }} catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static String promptTicker(Scanner scanner){
        System.out.println("Digite o nome (ticker) da ação: Exemplo PETR3.SA");
        return scanner.next();
    }
}
