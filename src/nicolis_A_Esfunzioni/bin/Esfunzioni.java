package nicolis_A_Esfunzioni.bin;

import java.util.Scanner;

public class esfunzioni {
    public static boolean calcolaPD(int num){
        return (num % 2 == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (n != -1){
            if (calcolaPD(n)){
                System.out.println("è pari");
            } else {
                System.out.println("è dispari");
            }
            System.out.println("dammi un altro numero, premere -1 per uscire");
            n = sc.nextInt();
        }
    }
}
