package nicolis_A_Contadispararray.bin;

import java.util.Scanner;

public class contadispararray {

    public static void CaricaArray(int num[]){
        for(int i = 0; i < 5; i++){
            Scanner sc = new Scanner(System.in);
            num[i] = sc.nextInt();
        }
    }

    public static void LeggiArray(int num[]){
        for(int i = 0; i < 5; i++){
            System.out.println("i numeri sono " + num[i]);
        }

    }

    public static int ContaPari(int num[]){
        int contpar = 0;
        for(int i = 0 ; i < 5; i++){
            if (num[i] % 2 ==0){
            contpar = contpar + 1;
            }
        }
        return contpar;
    }
    public static int ContaDispari(int num[]){
        int contdis = 0;
        for(int i = 0 ; i < 5; i++){
            if( num[i] % 2 != 0){
            contdis = contdis + 1;
            }
        }
        return contdis;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeri[]= new  int [5];
        CaricaArray(numeri);
        LeggiArray(numeri);
        int contpar;
        contpar = ContaPari(numeri);
        System.out.println("i numeri pari sono " + contpar);
        int contdis;
        contdis = ContaDispari(numeri);
        System.out.println("i numeri dispari sono " + contdis);
    }
    
}
