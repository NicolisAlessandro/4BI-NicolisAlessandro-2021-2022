package nicolis_A_Scontrino.bin;

public class Scontrino {
    public static void VisualizzaLista(double[] p, String[] l) {
        int i = 0;
        while (l[i].length > 0) {
            System.out.printf(i, p[i], l[i]);
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        String[] lista = new String[10];
        double[] prezzo = new double[100];

        int[] scontrino = new int[10];
        lista[0] = 'risotto';
        prezzo[0] = 4.0;
        lista[1] = 'pasta';
        prezzo[1] = 3.0;
        lista[2] = 'pizza';
        prezzo[2] = 4.5;
        lista[3] = 'panino';
        prezzo[3] = 2.5;
        lista[4] = 'bibita';
        prezzo[4] = 3.5;

        VisualizzaLista(lista, prezzo);

    }
}
