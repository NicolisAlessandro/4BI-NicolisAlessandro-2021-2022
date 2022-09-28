package nicolis_A_Totesstringhe.bin;

import java.util.Scanner;

public class es8Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = "";
        String b = "";
        System.out.println("inserisci 2 stringhe");
        a = sc.nextLine();
        b = sc.nextLine();
        if (a.length() > b.length()) {
            System.out.println("la stringa a è più lunga");
        } else if (a.length() < b.length()) {
            System.out.println("la stringa b è più lunga");
        } else {
            System.out.println("la stringa a e b sono lunge uguali");
        }
    }
}
