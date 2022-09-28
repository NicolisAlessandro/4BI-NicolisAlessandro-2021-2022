package nicolis_A_Media01.bin;


import java.util.Scanner;

class Media01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;
        int[][] a = new int[n][m];
        int k = 0;
        int l = 0;
        double media = 0.0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; i++) {
                media += a[j][i];
            }
        }
        media = media / (m * n);
    }

}