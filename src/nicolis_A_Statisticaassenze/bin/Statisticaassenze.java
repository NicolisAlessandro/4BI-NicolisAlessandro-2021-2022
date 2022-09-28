package nicolis_A_Statisticaassenze.bin;

public class StatisticaAssenze {

    public static void caricaArray(int[][] a) {
        int len = a.length;
        int[][] ints = new int[len][len];
        for (int righe = 0; righe < len; righe++) {
            for (int colonne = 0; colonne < len; colonne++) {
                int x = (int) (Math.random() * 100);
                ints[righe][colonne] = x;
            }
        }
    }

    public static void stampaArray(int[][] a) {
    }

    public static void calcolaMediaAssGiornaliere(int[][] a, double[] mediaGiorno) {
    }

    public static void calcolaMediaAssClasse(int[][] a, double[] mediaClasse) {
    }

    public static int calcolaTotaleAssGiorn(int[][] a, int[] totPerGiorno) {
        return 0;
    }

    public static void main(String[] args) {

    }

}