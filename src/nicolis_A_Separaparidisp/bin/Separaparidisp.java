package nicolis_A_Separaparidisp.bin;


import java.util.Scanner;

public class separaPariDisp {
    public static void Carica(int[] num) {
        for (int i = 0; i < 100; i++) {
            Scanner sc = new Scanner(System.in);
            num[i] = sc.nextInt();
        }
    }

    public static void SeparaParidisp(int[] input, int[] pari, int[] disp) {
        for (int i = 0; i < pari.length; i++) {
            pari[i] = 0;
        }
        for (int i = 0; i < disp.length; i++) {
            disp[i] = 0;
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                pari[i] = input[i];
            } else {
                disp[i] = input[i];
            }
        }
    }

    public static void LeggiArray(int[] num) {
        for (int i = 0; i < 100; i++) {
            System.out.println("i numeri sono " + num[i]);
        }
    }

    public static void main(String[] args) {
        int[] a, b, c;
        a = new int[100];
        b = new int[100];
        c = new int[100];
        Carica(a);
        SeparaParidisp(a, b, c);
        LeggiArray(b);
        LeggiArray(c);
    }

}
