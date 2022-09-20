package nicolis_A_Macchinetta.bin;

import java.util.Scanner;

public class Macchinetta {
    public static void main (String[] args){
    System.out.println("scegli 1 caffe, 2 cioccolata , 3 the");
     sc = new Scanner(System.in);
    double moneta, resto = 0, costo = 0, totale = 0;
    int scelta = sc.nextInt();
    if(scelta == 1){
    System.out.println("caffè 0,50$");
    costo = 0.50 ;
    } 
    if(scelta == 2){
    System.out.println("cioccolata 0,75$");
    costo = 0.75 ;
    }
    if(scelta == 3){
    System.out.println("the 0,60$");
    costo = 0.60 ;    
    }
    System.out.println("Inserire i soldi ");
    while(totale < costo){
        moneta = sc.nextDouble();
        totale= totale + moneta;
        System.out.println("inserisci più soldi");
    }
    System.out.println(totale);

    resto = totale - costo;
    System.out.print("il resto è "+ resto);
    

  }  
}
