package nicolis_A_Quadrato.bin;

import java.util.Scanner;

//Ripetere più volte: dato il lato di un quadrato, calcolare il perimetro e l’area

/*input:
scelta = 1;
l = 20;
output:
p = 80;
A = 400;*/

public class Quadrato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, p, area;
        int scelta = 1;
        do{
            n = sc.nextInt();
            System.out.println(n);
            p = 4 * n;
            System.out.println("il perimetro è " + p);
            area = n * n; 
            System.out.println("l'area è " + area);
            System.out.println("vuoi prosequire? Premere 1");
            scelta = sc.nextInt();
        }while(scelta == 1);
    }
}