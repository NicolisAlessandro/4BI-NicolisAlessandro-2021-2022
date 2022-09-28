package nicolis_A_Posinega.bin;

//Ripetere più volte: inserito un numero, dire se è positivo o negativo

/*input:
scelta = 1;
n = 20;
output:
20 posi;*/

import java.util.Scanner;

public class PosiNega {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, nposi, nnega;
        int scelta = 1;
        do {
            n = sc.nextInt();
            System.out.println(n);
            if (n > 0) {
                nposi = n;
                System.out.println("numero è positivo " + nposi);
            } else {
                nnega = n;
                System.out.println("numero è negativo " + nnega);
            }
            System.out.println("vuoi prosequire? Premere 1");
            scelta = sc.nextInt();
        } while (scelta == 1);
    }
}
