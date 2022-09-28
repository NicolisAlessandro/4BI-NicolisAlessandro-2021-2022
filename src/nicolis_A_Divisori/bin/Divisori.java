package nicolis_A_Divisori.bin;

//Stabilire se due numeri sono divisibili tra di loro

/*input:
n = 1;
n = 20;
output:
n / n = sono divisibili;*/

import java.util.Scanner;

public class Divisori {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, div = 0;
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        if (num1 > num2) {
            if (num1 % num2 == 0) {
                div = num1 / num2;
                System.out.println("sono divisibili");
                System.out.println(div);
            } else {
                System.out.println("non sono divisibili");
            }
        } else {
            if (num2 % num1 == 0) {
                div = num2 / num1;
                System.out.println("sono divisibili");
                System.out.println(div);
            } else {
                System.out.println("non sono divisibili");
            }
        }
    }
}
