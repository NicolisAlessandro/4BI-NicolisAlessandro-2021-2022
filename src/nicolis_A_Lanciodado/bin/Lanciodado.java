package nicolis_A_Lanciodado.bin;

import java.util.Scanner;

public class LancioDado {
    public static void LeggiVoti(int[] pippo) {
        for (int i = 0; i < 7; i++) {
            System.out.println("i numeri sono " + pippo[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int[] conta = new int[7];
        for (int i = 0; i < 7; i++) {
            conta[i] = 0;
        }

        for (int i = 0; i < 10; i++) {
            num = (int) (Math.random() * 2);
            System.out.println(num);
            conta[num]++;
        }
        LeggiVoti(conta);
    }
}
