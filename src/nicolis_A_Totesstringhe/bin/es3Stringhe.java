package nicolis_A_Totesstringhe.bin;

import java.util.Scanner;

public class es3Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        s = sc.nextLine();
        System.out.println("il risultato: " + s.replaceAll("[,.?!]", " "));
    }
}
