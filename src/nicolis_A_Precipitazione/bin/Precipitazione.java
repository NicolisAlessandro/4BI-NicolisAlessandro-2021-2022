package nicolis_A_Precipitazione.bin;

// nelle 24 ore della giornata si vogliano misurare le precipitazioni. Visualizzare l' ora in cui si sono verificate le pioggie più abbbondanti e il numero di ml di pioggia
/* es input / output 
commento

*/

import java.util.Scanner;

public class Precipitazione {
    public static void CaricaArray(int[] prep) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 24; i++) {
            prep[i] = sc.nextInt();
        }
    }

    public static void LeggiArray(int[] prep) {
        for (int i = 0; i < 24; i++) {
            System.out.println("le precipitizzazioni sono" + prep[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ml;
        int[] precipitazioni = new int[24];
        CaricaArray(precipitazioni);

    }

}