package nicolis_A_Confronto.bin;


/*input:
scelta = 1;
x = 5;
a = 3;
b = 2;
output:
y = 17;*/

import java.util.Random;
import java.util.Scanner;

public class Confronto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rip , vo = 0, conf;
        rip = sc.nextInt();
        System.out.println("inserire un numero da confrontare");
        conf = sc.nextInt();
        System.out.println("ripetere " + rip);
        double num;
        while(rip > vo){
            num = (int) (Math.random() * 100);
            System.out.println(num);
            if (num < conf){
                System.out.println("il numero è maggiore " + conf + " > " + num);
            }  
            if (num > conf){
                System.out.println("il numero è minore " + conf + " < " + num);  
            }
            if (num == conf){
                System.out.println("il numero è uguale " + conf + " == " + num);  
            }
            vo = vo + 1;
        } 
    }
}