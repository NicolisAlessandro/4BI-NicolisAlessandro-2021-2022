package nicolis_A_Giocovita.bin;


import java.util.Scanner;

public class GiocoVita {

    public static void init(int m[][]) {
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (Math.random() > 0.75) {
                    m[r][c] = 1;
                } else {
                    m[r][c] = 0;
                }
            }
        }
    }
    public static void visualizza(int m[][]) {
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (m[r][c] == 1) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }
    public static int attorno(int m[][],int r,int c){ 
        return 3;               
    }
    public static void evoluz(int m[][]) {
        int nm[][];
        int nr, nc;
        nr = m.length;
        nc = m[0].length;
        nm = new int[nr][nc];   

        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                int cva = attorno(m,r,c);

                if (m[r][c] == 1) {
                    if (cva == 2 || cva == 3) {
                        nm[r][c] = 1;
                    } else {
                        nm[r][c] = 0;
                    }
                } else { 
                    if (cva == 3) {
                        nm[r][c] = 1;
                    } else {
                        nm[r][c] = 0;
                    }
                }
            }
        }
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                m[r][c] = nm[r][c];
            }
        }
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int[][] mat; 
        mat = new int[10][12];
        init(mat);
        visual(mat);
        for (int g = 1; g <= 10; g++) {
            System.out.println("generazione " + g);
            evoluz(mat);
            visual(mat);
            System.out.println("premi invio per continuare....");
            String s = inp.nextLine();

        }

    }

}
