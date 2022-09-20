package nicolis_A_Slotmachine.bin;

import java.util.Scanner;
public class Slotmachine{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a , b , c , rit;
        String posto1, posto2, posto3;
    do{
        a = (int) (Math.random() * 3) + 1;
        System.out.print(a);
        b = (int) (Math.random() * 3) + 1;
        System.out.print(b);
        c = (int) (Math.random() * 3) + 1;
        System.out.println(c);
        
        if (a == 1){
            posto1 = "$ ";
            System.out.println(posto1);
        }
        if (a == 2){
            posto1 = "@ ";
            System.out.println(posto1);
        }
        if (a == 3){
            posto1 = "% ";
            System.out.println(posto1);
        }
        if (b == 1){
            posto2 = "$ ";
            System.out.println(posto2);
        }
        if (b == 2){
            posto2 = "@ ";
            System.out.println(posto2);
        }
        if (b == 3){
            posto2 = "% ";
            System.out.println(posto2);
        }
        if (c == 1){
            posto3 = "$ ";
            System.out.println(posto3);
        }
        if (c == 2){
            posto3 = "@ ";
            System.out.println(posto3);
        }
        if (c == 3){
            posto3 = "% ";
            System.out.println(posto3);
        }
        

        if( a == b && a == c){
            System.out.println("Hai vinto");
        }else{
            System.out.println("Hai perso");
        }
        System.out.println("vuoi tentare ancora? Premere 1");
        rit= sc.nextInt();
    }while(rit == 1);
    }
}