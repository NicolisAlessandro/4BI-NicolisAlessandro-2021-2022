package nicolis_A_Cerca.bin;

import java.util.Scanner;

public class cerca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase = sc.nextLine();
        String lettera = sc.nextLine();
        int conta = 0;
        char lett = lettera.charAt(0);
        //char fra[] = frase.toCharArray();
        for (int i = 0; i < frase.length(); i++) {
            if (lett == frase.charAt(i)) {
                conta = conta + 1;
            }
        }
        System.out.println(conta);
        int contaa = 0;
        for (int i = 0; i < frase.length(); i++) {
            if ('a' == frase.charAt(i)) {
                contaa++;
            }
            if ('e' == frase.charAt(i)) {
                contaa++;
            }
            if ('i' == frase.charAt(i)) {
                contaa++;
            }
            if ('o' == frase.charAt(i)) {
                contaa++;
            }
            if ('u' == frase.charAt(i)) {
                contaa++;
            }
        }
        System.out.println(contaa);
    }
}
