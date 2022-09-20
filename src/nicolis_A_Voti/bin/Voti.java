package nicolis_A_Voti.bin;

//inserire 5 voti e dire quale massimo e minimo


import java.util.Scanner;

public class Voti {
    public static void VotiMaggiori(){
        Scanner sc = new Scanner(System.in);
        int voti , votmag ;
        for (int i = 0; i < 5; i++){
            voti = sc.nextInt();
            if (i==0) {
                votmin = voti;
            }
            if (votmag < voti){
                votmag = voti;
                System.out.println("il massimo è "+ votmag);
            }
        }
        System.out.println("il massimo finale è "+ votmag);
    }
    public static void VotiMinori(){
        Scanner sc = new Scanner(System.in);
        int voti , votmin = 0;
        for (int i = 0; i < 5; i++){
            
            voti = sc.nextInt();
            if (i==0) {
                votmin = voti;
            }
            if (votmin > voti){
                votmin = voti;
                System.out.println("il minimo è "+ votmin);
            }
        }
        System.out.println("il minimo finale è "+ votmin);
    }
    public static void CaricaVoti(int voti[]){
        for(int i = 0; i < 5; i++){
            Scanner sc = new Scanner(System.in);
            voti[i] = sc.nextInt();
        }
    }

    public static void LeggiVoti(int voti[]){
        for(int i = 0; i < 5; i++){
            System.out.println("i voti sono " + voti[i]);
        }

    }
    public static int VotiMaggiori(int voti[]){
        int votmag = 0;
        for (int i = 0; i < 5; i++){
            if (i==0) {
                votmag = voti[i];
            }
            if (votmag < voti[i]){
                votmag = voti[i];
            }
        }
        return votmag;
    }
    public static int VotiMinori(int voti[]){
        int votmin = 0;
        for (int i = 0; i < 5; i++){
            if (i==0) {
                votmin = voti[i];
            }
            if (votmin > voti[i]){
                votmin = voti[i];
            }
        }
        return votmin;
    }
    public static int SommaVoti(int voti[]){
        int somma = 0;
        for (int i = 0; i < 5; i++){
            somma = somma + voti[i];
        }
        return somma;
    }
    public static double MediaVoti(int voti[]){
        double media = 0;
        double somma = SommaVoti(voti);
        media = somma /5;
        return media;
    }
    public static int ContaPari(int voti[]){
        int contpar = 0;
        for(int i = 0 ; i < 5; i++){
            if(voti[i] % 2 ==0){
            contpar = contpar + 1;
            }
        }
        return contpar;
    }
    public static int ContaDispari(int voti[]){
        int contdis = 0;
        for(int i = 0 ; i < 5; i++){
            if( voti[i] % 2 != 0){
            contdis = contdis + 1;
            }
        }
        return contdis;
    }
    public static void ContrarioVoti(int voti[]){
        for(int i = 0; i < 5; i++){
            System.out.println("i voti sono " + voti[4-i]);
        }
    }
    public static void moltiplicaDispari(int voti[]){
        for(int i = 0 ; i < 5; i++){
            if( voti[i] % 2 != 0){
            voti[i] = voti[i] * 2;
            }
        System.out.println("i voti nuovi sono " + voti[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int votimate[]= new  int [5];
        int votita[]= new int [5];
        CaricaVoti(votimate);
        LeggiVoti(votimate);
        CaricaVoti(votita);
        LeggiVoti(votita);  
        int votmag;
        votmag = VotiMaggiori(votimate); 
        System.out.println("il voto maggiore è " + votmag);
        int votmin;
        votmin= VotiMinori(votimate); 
        System.out.println("il voto minimo è " + votmin);
        int somma;
        somma= SommaVoti(votimate);
        System.out.println("la somma è " + somma);
        double media;
        media = MediaVoti(votimate);
        System.out.println("La media è " + media);
        int contpar;
        contpar = ContaPari(votimate);
        System.out.println("i numeri pari sono " + contpar);
        int contdis;
        contdis = ContaDispari(votimate);
        System.out.println("i numeri dispari sono " + contdis);
        ContrarioVoti(votimate);
        moltiplicaDispari(votimate);
    }
}