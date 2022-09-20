package nicolis_A_Paridispari.bin;

//Ripetere più volte: inserito un numero intero, dire se è pari o dispari
/*input:
scelta = 1;
n = 20;
output:
20 pari;*/

import java.util.Scanner;

public class PariDispari {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, npa, ndis;
        int scelta = 1;
        do{
            n = sc.nextInt();
            System.out.println(n);
            if(n % 2 ==0){
            npa = n ;
            System.out.println("numero è pari " + npa);
        }else {
            ndis = n ; 
            System.out.println("numero è dispari " + ndis);}
            System.out.println("vuoi prosequire? Premere 1");
            scelta = sc.nextInt();
        }while(scelta == 1);
    }  
    
}
