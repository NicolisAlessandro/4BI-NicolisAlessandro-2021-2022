package nicolis_A_Esprofstringhe.bin;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class esprofStringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String frase1;
        frase1 = sc.nextLine();
        String frase2 = sc.nextLine();

        int risultato = frase1.compareTo(frase2);
        System.out.println(risultato);
        if (risultato == 0){
            System.out.println("le stringhe sono uguali");
        }else if (risultato > 0){
            System.out.println("la stringa1 è maggiore della stringa2");
        }else {
            System.out.println("la stringa1 è minore della stringa2");
        }

        String pippo = frase1.toUpperCase();
        System.out.println(pippo);

        String asso = sc.nextLine();
        System.out.println(asso.replaceAll( "[.,;:]" , " "));
        String osso = sc.nextLine();
        System.out.println(osso.replaceAll( " " , ""));

        
    }
}