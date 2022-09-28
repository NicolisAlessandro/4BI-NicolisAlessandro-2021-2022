package nicolis_A_Glotto.bin;


import java.util.Random;
import java.util.Scanner;

public class GLotto_cercaAmbo {

    //true se num presente in v
    public static boolean ricerca(int[] v, int num) {
        boolean ris = false;
        for (int i = 0; i < v.length; i++) {
            if (v[i] == num) {
                ris = true;
                break;
            }
        }
        return ris;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        Random ra = new Random();
//------------- gestione scommessa   qn  e ns[]
        int[] ns = new int[5];
        int qn; // quanti nuneri si vogliono scommettere?
        qn = 2;
        for (int i = 0; i < qn; i++) {
            int num;
            do {
                System.out.print("Inserire numero da 'giocare'  ");
                num = inp.nextInt();
            } while (ricerca(ns, num));
            ns[i] = num;

        }
        int num_estr;   // num estrazioni
        boolean nv;
        int[][] vec = new int[10][5];
        num_estr = 0;
        do {
            // ----------------- estrazioni
            num_estr++;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    // ripeti estrazione se già presente nellaruota corrente
                    int nume;
                    do {
                        nume = ra.nextInt(90) + 1;
                    } while (ricerca(vec[i], nume));
                    vec[i][j] = nume;
                }
            }
            System.out.println("Estrazione -->" + num_estr);
            // visualizzazione estrazioni
            for (int i = 0; i < 10; i++) {
                System.out.printf("ruota %2d-->", (i + 1));
                for (int j = 0; j < 5; j++) {
                    System.out.printf("%3d", vec[i][j]);
                }
                System.out.println();
            }
            nv = true;
            // gestione vincite 
            for (int i = 0; i < 10; i++) {
                // per ogni ruota conta quanti numeri fra quelli scommessi sono usciti?
                int nest = 0;
                for (int k = 0; k < qn; k++) {// per ogni numero scommesso
                    if (ricerca(vec[i], ns[k])) {// è stato estratto?
                        nest++;
                    }
                }
                if (nest == 2) {
                    nv = false;
                    System.out.printf("Sulla ruota %2d hai vinto %d \n", i + 1, nest);
                }
            }
            if (nv) {
                System.out.println("non hai vinto nulla");
            }

        } while (nv);
    }
}
