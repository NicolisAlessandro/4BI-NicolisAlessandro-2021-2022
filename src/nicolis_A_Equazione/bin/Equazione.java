package nicolis_A_Equazione.bin;

//Calcolo di un polinomio dato per un valore X (es. Y=3X 2 +5X-6)

/*input:
scelta = 1;
x = 5;
a = 3;
b = 2;
output:
y = 17;*/

import java.util.Scanner;

public class Equazione {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, x , y;
        String scelta;
        do{
            a = Integer.parseInt (sc.nextLine());
            b = Integer.parseInt (sc.nextLine());
            x = Integer.parseInt (sc.nextLine());
            System.out.println("il valore di a è " + a);
            System.out.println("il valore di b è " + b);
            System.out.println("il valore di x è " + x);
            y = a * x + b;
            System.out.println("il valore di y è " + y);
            System.out.println("y = " + a + "x " + b);
            System.out.println("vuoi prosequire? Premere 1");
            scelta = sc.nextLine();
            System.out.println( scelta);
        }while(scelta.equals("Si"));
    }
}
