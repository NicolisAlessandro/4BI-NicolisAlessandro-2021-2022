package nicolis_A_Totesstringhe.bin;

import java.util.Scanner;

public class es9Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        s = sc.nextLine();
        char[] array = s.toCharArray();
        char[] pali = s.toCharArray();
        int sinistra, destra = 0;
        destra = array.length - 1;

        for (sinistra = 0; sinistra < destra; sinistra++, destra--) {
            char temp = array[sinistra];
            array[sinistra] = array[destra];
            array[destra] = temp;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == pali[array.length - i]) {
                System.out.println("la stringa è palindroma");
            }
        }
        for (char c : array)
            System.out.print(c);
        System.out.println();
    }
}
