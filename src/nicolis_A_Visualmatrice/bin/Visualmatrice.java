package nicolis_A_Visualmatrice.bin;

import java.util.Random;
import java.util.Scanner;

class VisualMatrice {
    public static int[][] createMatChar(int r, int c) {

        int[][] a = new int[r][c];
        return a;
    }

    public static void visualeMatrice(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = Math.Random(100);
                System.out.print(a[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Inserisci grandezza matrice riga: ");
        int r = sc.nextInt();
        System.out.print("Inserisci grandezza matrice colonna: ");
        double c = Math.Random(100);
        sc.close();
    }

    public static void visualMeta(int[][] a) {
        for (int i = 0; i < a.length; ) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = Math.Random(100);
                System.out.print(a[i][j]);
            }
            i++;
        }
    }

    public static void visualsommamatrice(int[][] a) {
        for (int i = 0; i < a.length; ) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = Math.Random(100);
                System.out.print(a[i][j]);
            }
            i++;
        }
    }
}