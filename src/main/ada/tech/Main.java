package ada.tech;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Projeto - Módulo 2 Ada");
        System.out.println("Aluno: Arthur Pendragon de Simone");
        System.out.println("=========================INICIO===============================");
        printConsole();
        System.out.println("==========================FIM=================================");
    }
    public static void printConsole(){
        boolean continueScan = true;
        Scanner scanner = new Scanner(System.in);
        while(continueScan){
            System.out.println("1 - Baixar nova ação");
            System.out.println("QUALQUER ENTRADA - Encerra a aplicação");
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Digite o nome (ticker) da ação: Exemplo PETR3.SA");
                    String stock = scanner.next();
                    System.out.println(stock);
                    break;
                case 2:
                    break;
                default:
                    continueScan = false;
                    break;
            }
        }
    }
}
