package nicolis_A_Stringhenonripet.bin;

//presa una sequenza array di caratteri e dare in sequenza univoca cioé non ci sono caratteri ripetuti

import java.util.Scanner;

public class StringhenonRipet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = new char[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextLine().charAt(0);
            System.out.println("i caratteri sono " + a[i]);
        }
        char[] b = new char[10];
        int k = 0, n = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    k = k + 1;
                }
                System.out.println(k);
            }
            if (k == 0) {
                b[n] = a[i];
                n = n + 1;
            }
            k = 0;
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println("la array è " + b[n]);
        }
    }
}