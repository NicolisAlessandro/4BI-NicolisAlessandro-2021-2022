package nicolis_A_Totesstringhe.bin;

//Leggi una stringa e trasformane le lettere minuscole in maiuscole.

import java.util.Scanner;

public class es1Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        s = sc.nextLine();
        System.out.println(" il risultato : " + s.toUpperCase());
    }
}

import java.util.Scanner;
public class es3Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        s = sc.nextLine();
        System.out.println("il risultato: " + s.replaceAll("[,.?!]", " "));
    }
}

//Data una stringa stampare il suo inverso

import java.util.Scanner;

public class es4Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        s = sc.nextLine();

        char[] array = s.toCharArray();
        int sinistra, destra = 0;
        destra = array.length - 1;
 
        for (sinistra = 0; sinistra < destra; sinistra++, destra--) {
            char temp = array[sinistra];
            array[sinistra] = array[destra];
            array[destra] = temp;
        }
 
        for (char c : array)
            System.out.print(c);
        System.out.println();
    }
}

//Leggi una stringa e determina quanto è lunga

import java.util.Scanner;

public class es5Stringhe{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        s = sc.nextLine();
        System.out.println("la lunghezza è " + s.length());
    }
}

//Leggi una stringa e un carattere e conta quante volte quel carattere è contenuto nella stringa

import java.util.Scanner;

public class es6Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int conta = 0;

        System.out.println("dettami una frase da controllare");
        String a = sc.nextLine(); 
        System.out.println("dammi un carattere da cercare");
        String search = sc.nextLine();
        char cerca = search.charAt(0);
        char []array = a.toCharArray();
        for (int i = 0; i < a.length(); i++){
            if (array[i] == cerca) { 
                conta = conta + 1; 
            }   
        } 
        if(conta == 0) { 
            System.out.println("non l'ho trovata"); 
        }else{ 
            System.out.println("i caratteri  sono " + conta);
        }
    }
}

//Leggi una stringa e determina quante vocali contiene.

import java.util.Scanner;

public class es7Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, e = 0, i = 0, o = 0, u = 0;

        System.out.println("dettami una frase da controllare");
        String a = sc.nextLine(); 
        System.out.println("dammi un carattere da cercare");
        String search = new String("aeiou");
        char []cerca = search.toCharArray();
        char []array = a.toCharArray();
        for (int i = 0; i < a.length(); i++){
            if (array[i] == cerca[]) { 
                conta = conta + 1; 
            }   
        } 
        if(conta == 0) { 
            System.out.println("non l'ho trovata"); 
        }else{ 
            System.out.println("i caratteri  sono " + conta);
        }
    }
}

//Leggi due stringhe e verifica quale è più lunga.

import java.util.Scanner;

public class es8Stringhe{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = new String();
        String b = new String();
        System.out.println("inserisci 2 stringhe");
        a = sc.nextLine();
        b = sc.nextLine();
        if (a.length() > b.length()){
            System.out.println("la stringa a è più lunga");
        } else if (a.length()< b.length()) {
            System.out.println("la stringa b è più lunga");
        } else {
            System.out.println("la stringa a e b sono lunge uguali");
        }
    }
}

//Leggi una stringa e verifica se è palindroma.

import java.util.Scanner;

public class es9Stringhe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String();
        s = sc.nextLine();
        char[] array = s.toCharArray();
        char[] pali = s.toCharArray();
        int sinistra, destra = 0;
        destra = array.length - 1;
 
        for (sinistra = 0; sinistra < destra; sinistra++, destra--) {
            char temp = array[sinistra];
            array[sinistra] = array[destra];
            array[destra] = temp;
        }
        for(int i = 0; i < array.length; i++){
            if (array[i] == pali[array.length - i]){
            System.out.println("la stringa è palindroma");
        } 
    }
        for (char c : array)
            System.out.print(c);
        System.out.println();
    }
}
