package nicolis_A_Statisticaassenze.bin;

public class StatisticaAssenze{

     public static void caricaArray(int[][] a){ 
        int[][] a = new int[len][len];
        for (int righe = 0; righe < len; righe++) {
            for (int colonne = 0; colonne < len; colonne++) {
                int x = (int) (Math.random() * 100);
                a[righe][colonne] = x;
     }

     public static void stampaArray(int[][] a){ }

     public static void calcolaMediaAssGiornaliere(int[][] a, double[] mediaGiorno){ }

     public static void calcolaMediaAssClasse(int[][] a, double[] mediaClasse){ }

     public static int calcolaTotaleAssGiorn(int [][] a, int[] totPerGiorno){ }

     public static void main{ }

}