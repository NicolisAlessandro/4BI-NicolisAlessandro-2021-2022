package nicolis_A_Numeroinventato.bin;

import java.util.Scanner;

public class Numeroinventato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, numvin, rit;

        for (int i = 0; i < 10; i++) {
            num = (int) (Math.random() * 6) + 1;
            System.out.println(num);
        }
        do {
            System.out.print("inserisci un numero");
            numvin = sc.nextInt();
            num = (int) (Math.random() * 6) + 1;
            System.out.println(num);
            if (num == numvin) {
                System.out.println("hai vinto");
            } else {
                System.out.println("hai perso");
            }
            System.out.println("vuoi tentare ancora?");
            rit = sc.nextInt();
        } while (rit == 1);
    }

}
