package nicolis_A_Scomposizione.bin;

//Dato un numero intero minore di 1000, dire da quante centinaia, decine e unità composto

/*input:
n = 120;
output:
h = 1;
da = 2;
u = 0;*/

import java.util.Scanner;

public class Scomposizione {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, u, da, h;
        System.out.println("dimmi un numero");
        num = sc.nextInt();
        while (num > 1000) {
            System.out.println("dimmi un altro numero");
            num = sc.nextInt();
        }
        System.out.println("il  numero è " + num);
        h = num / 100;
        da = (num - h * 100) / 10;
        u = num - h * 100 - da * 10;
        System.out.println("le unità sono " + u);
        System.out.println("le decine sono " + da);
        System.out.println("le centinaia sono " + h);
    }
}