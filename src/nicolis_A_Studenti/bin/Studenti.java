package nicolis_A_Studenti.bin;

import java.util.Scanner;

public class studenti {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String[] nomi;
        String[] cognomi;
        float[] voti;
        System.out.println("Inserisci il numero di studenti");
        int n = scr.nextInt();
        scr.nextLine();
        nomi = new String[n];
        cognomi = new String[n];
        voti = new float[n];


        for (int i = 0; i < n; i++) {
            System.out.println("Inserisci nome");
            nomi[i] = scr.nextLine();

            System.out.println("Inserisci cognome");
            cognomi[i] = scr.nextLine();
            System.out.println("Inserisci voti");
            voti[i] = scr.nextFloat();
        }

        float max = 0;
        int salva = 0;
        for (int i = 0; i < n; i++) {
            if (voti[i] > max) {
                max = voti[i];
                salva = i;
            }
        }
        System.out.println("Lo studente con il maggior voto è: " + nomi[salva] + " " + cognomi[salva] + " " + voti[salva]);

    }
}