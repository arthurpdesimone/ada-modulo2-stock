package ada.tech;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Projeto - Módulo 2 Ada");
        System.out.println("Aluno: Arthur Pendragon de Simone");
        System.out.println("==============================================================");
        boolean continueScan = true;
        Scanner scanner = new Scanner(System.in);
        while(continueScan){
            switch (scanner.nextInt()){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    continueScan = false;
                    break;
            }
        }
        System.out.println("==============================================================");
    }
}
