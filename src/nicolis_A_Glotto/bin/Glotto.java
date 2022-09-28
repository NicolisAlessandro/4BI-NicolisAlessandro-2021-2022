package nicolis_A_Glotto.bin;


import java.util.Random;
import java.util.Scanner;

public class GLotto {
    /*
    1> chiedere al giocatore la scommessa
        qn   ns[]    qn=3  ns=[23 45 67]   
    2> estrarre i numeri
        10 ruote 
        ogni ruota conterrà 5 numeri 1 a 90
        int vec[10][5]  matrice 10 righe 5 colonne
    
    3> visualizzare l'estrazione
    4> cercare l'eventuale vincita
*/

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        Random ra = new Random();
//------------- gestione scommessa   qn  e ns[]
        int[] ns = new int[5];
        int qn; // quanti numeri si vogliono scommettere?

        System.out.print("Quanti numeri si vogliono 'giocare'");
        qn = inp.nextInt();
        for (int i = 0; i < qn; i++) {
            System.out.print("Inserire numero da 'giocare'  ");
            ns[i] = inp.nextInt();  //1..90
            // non viene fatto alcun controllo
        }

        int[][] vec = new int[10][5];
        // ----------------- estrazioni
        for (int i = 0; i < 10; i++) {  // per ogni ruota
            for (int j = 0; j < 5; j++) {
                // ripeti estrazione se già presente nella ruota corrente
                int nume;
                boolean tr;
                do {
                    tr = false;
                    nume = ra.nextInt(90) + 1;
                    for (int k = 0; k < j; k++) {
                        if (vec[i][k] == nume) {
                            tr = true;
                            break;
                        }
                    }
                } while (tr);
                vec[i][j] = nume;

            }
        }

        // visualizzazione estrazioni
        for (int i = 0; i < 10; i++) {
            System.out.printf("ruota %2d-->", (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.printf("%3d", vec[i][j]);
            }
            System.out.println();
        }

        boolean nv = true;
        // gestione vincite 
        for (int i = 0; i < 10; i++) {
            // per ogni ruota conta quanti numeri fra quelli scommessi sono usciti?
            int nest = 0;
            for (int k = 0; k < qn; k++) {// per ogni numero scommesso
                for (int j = 0; j < 5; j++) {// per ogni numero estratto
                    if (vec[i][j] == ns[k]) {
                        nest++;
                    }
                }
            }

            if (nest > 0) {
                nv = false;
                System.out.printf("Sulla ruota %2d hai vinto %d \n", i + 1, nest);
            }

        }


        if (nv) {
            System.out.println("non hai vinto nulla");
        }
    }

}
