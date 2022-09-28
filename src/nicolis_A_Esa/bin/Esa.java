package nicolis_A_Esa.bin;

import java.util.Scanner;

public class esa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pippo = sc.nextLine();
        System.out.println(pippo.charAt(3));
        for (int i = 0; i < pippo.length(); i++) {
            System.out.print(pippo.charAt(pippo.length() - 1 - i));
        }
        for (int i = pippo.length() - 1; i >= 0; i--) {
            System.out.println(pippo.charAt(i));
        }
        char[] cane = pippo.toCharArray();
        for (int i = 0; i < pippo.length(); i++) {
            System.out.println(cane[pippo.length() - 1 - i]);
        }

    }
}
