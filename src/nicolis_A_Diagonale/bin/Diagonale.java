package nicolis_A_Diagonale.bin;

import java.util.Scanner;

public class Diagonale {

    public static int[][] createMatInt(int len) {

        int[][] a = new int[len][len];
        return a;
    }

    public static int[][] triangoloMat(int[][] matr) {

        for (int riga = 0; riga < matr.length; riga++) {
            for (int colonna = 0; colonna < matr[riga].length; colonna++) {
                if (colonna <= riga) {
                    matr[riga][colonna] = 7;
                }
            }
        }
        return matr;
    }

    public static int[][] triangoloRovesciatoMat(int[][] matr) {

        for (int riga = 0; riga < matr.length; riga++) {
            for (int colonna = 0; colonna < matr[riga].length; colonna++) {
                if (colonna < matr[riga].length - riga) {
                    matr[riga][colonna] = 7;
                }
            }
        }
        return matr;
    }

    public static void printMat(int[][] a) {

        for (int riga = 0; riga < a.length; riga++) {
            for (int colonna = 0; colonna < a[riga].length; colonna++) {
                System.out.print(a[riga][colonna] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci grandezza matrice: ");
        int len = sc.nextInt();

        int[][] matr = triangoloMat(createMatInt(len));
        int[][] matr2 = triangoloRovesciatoMat(createMatInt(len));

        printMat(matr);
        printMat(matr2);

        sc.close();
    }
}
