package nicolis_A_Totesstringhe.bin;


import java.util.Scanner;

public final class es7Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("dettami una frase da controllare");
        String a = sc.nextLine();
        System.out.println("dammi un carattere da cercare");
        String search = "aeiou";
        char[] cerca = search.toCharArray();
        char[] array = a.toCharArray();
        int conta = 0;
        for (int i = 0; i < a.length(); i++) {
            if (array[i] == cerca[conta]){
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