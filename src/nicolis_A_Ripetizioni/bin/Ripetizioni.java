package nicolis_A_Ripetizioni.bin;

import java.util.Scanner;

//Ripetere più volte: inserito un numero, calcolarne il quadrato e il cubo
/*input:
scelta = 1;
n = 20;
output:
nq = 400;
nc = 8000;*/

public class Ripetizioni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, nq, nc;
        int scelta = 1;
        do{
            n = sc.nextInt();
            System.out.println(n);
            nq = n * n;
            System.out.println("numero al quadrato " + nq);
            nc = n * n * n; 
            System.out.println("numeo al cubo " + nc);
            System.out.println("vuoi prosequire? Premere 1");
            scelta = sc.nextInt();
        }while(scelta == 1);
    }
}
