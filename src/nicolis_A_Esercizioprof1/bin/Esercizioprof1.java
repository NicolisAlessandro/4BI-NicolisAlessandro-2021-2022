package nicolis_A_Esercizioprof1.bin;

import java.util.Scanner;

public class Esercizioprof1 {
    public static void CaricaMatrice(int[][] m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = (int) (Math.random() * 3 + 1);
            }
        }
    }

    public static void StampaMatrice(int[][] m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int ControllaDiagonale(int[][] m) {
        int primo = m[0][0];
        int giusto = 1;
        for (int i = 0; i < 3; i++) {
            if (m[i][i] != primo) {

                giusto = 0;
                break;
            }
        }
        return giusto;
    }

    public static int ControllaDiagonaleopp(int[][] m) {
        int primo = m[0][2];
        int giusto = 1;
        for (int i = 0; i < 3; i++) {
            if (m[i][3 - i - 1] != primo) {
                giusto = 0;
                break;
            }
        }
        return giusto;
    }

    public static int ControllaRiga(int[][] m) {
        int giusto = 0, riga1 = 0, riga2 = 0, riga3 = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                if (m[i][0] == m[i][1] & m[i][0] == m[i][2]) {
                    riga1 = 1;
                }
            }
            if (i == 1) {
                if (m[i][0] == m[i][1] & m[i][0] == m[i][2]) {
                    riga2 = 1;
                }
            }
            if (i == 2) {
                if (m[i][0] == m[i][1] & m[i][0] == m[i][2]) {
                    riga3 = 1;
                }
            }
        }
        giusto = riga1 + riga2 + riga3;
        return giusto;
    }

    public static int ControllaColonna(int[][] m) {
        int giusto = 0, col1 = 0, col2 = 0, col3 = 0;
        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                if (m[0][j] == m[1][j] & m[0][j] == m[2][j]) {
                    col1 = 1;
                }
            }
            if (j == 1) {
                if (m[0][j] == m[1][j] & m[0][j] == m[2][j]) {
                    col2 = 1;
                }
            }
            if (j == 2) {
                if (m[0][j] == m[1][j] & m[0][j] == m[2][j]) {
                    col3 = 1;
                }
            }
        }
        giusto = col1 + col2 + col3;
        return giusto;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrice = new int[3][3];

        CaricaMatrice(matrice);
        StampaMatrice(matrice);
        ControllaDiagonale(matrice);
        ControllaDiagonaleopp(matrice);
        ControllaRiga(matrice);
        ControllaColonna(matrice);
        int vinci = 0;
        vinci = vinci + ControllaDiagonale(matrice);
        vinci = vinci + ControllaDiagonaleopp(matrice);
        vinci = vinci + ControllaRiga(matrice);
        vinci = vinci + ControllaColonna(matrice);
        if (vinci > 0) {
            System.out.println("hai vinto");
        } else {
            System.out.println("hai perso");
        }


    }
}
