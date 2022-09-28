package nicolis_A_Esmedia.bin;

import java.util.Scanner;
//chiede 5 numeri e da la media

/*input:
n = 20, 5, 12, 23, 35;
output:
19 media;*/

public class EsMedia {
    public static void main(String[] args) {
        double n, s = 0, m;
        System.out.println("dare un numero");
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);

            n = sc.nextDouble();
            s = s + n;
        }
        m = s / 5;
        System.out.println("La media è " + m);
    }
}