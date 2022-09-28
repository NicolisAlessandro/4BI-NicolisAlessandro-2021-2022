package nicolis_A_Totesstringhe.bin;

import java.util.Scanner;

public class es6Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int conta = 0;

        System.out.println("dettami una frase da controllare");
        String a = sc.nextLine();
        System.out.println("dammi un carattere da cercare");
        String search = sc.nextLine();
        char cerca = search.charAt(0);
        char[] array = a.toCharArray();
        for (int i = 0; i < a.length(); i++) {
            if (array[i] == cerca) {
                conta = conta + 1;
            }
        }
        if (conta == 0) {
            System.out.println("non l'ho trovata");
        } else {
            System.out.println("i caratteri  sono " + conta);
        }
    }
}
