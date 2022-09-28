package nicolis_A_Contaparridis.bin;

//data una sequenza in ingresso contare quanti numeri sono pari e quanti sono dispari usando la funzione calcolaPD(int num)

import java.util.Scanner;


public class contaparridis {

    public static boolean calcolaPD(int num) {
        return (num % 2 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1, contap = 0, contad = 0;
        while (n != -1) {
            if (calcolaPD(n)) {
                System.out.println("è pari");
                contap = contap + 1;
            } else {
                System.out.println("è dispari");
                contad = contad + 1;
            }
            System.out.println("dammi un altro numero, premere -1 per uscire");
            n = sc.nextInt();
        }
        System.out.println("i numeri dispari sono " + contad);
        System.out.println("i numeri pari sono " + contap);
    }
}
