package nicolis_A_Arraynumeriprimo.bin;

//dato una sequenza di numeri in un array, caricare in un secondo array i numeri sono primo e stamparli a video

import java.util.Scanner;
public class ArrayNumeriPrimo {
    
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

    public static int[] CercaPrimi(int num[]){
        int array[] = new int [5];
        int copia[] = new int [5];
        int conta = 0, dif; 
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < array[i]; j++){
                if (array[i] % j == 0){
                    conta = conta + 1;
                } 
            }
            if (conta == 2){
                copia[i] = array[i];
            }
        return array[i];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeri[]= new  int [5];
        int primo[] = new int [5];
        CaricaArray(numeri);
        LeggiArray(numeri);
        CercaPrimi(numeri);
        LeggiArray(primo);
    }
}
