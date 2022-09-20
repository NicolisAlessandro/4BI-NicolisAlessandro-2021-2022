package nicolis_A_Esrima.bin;

import java.util.Scanner;


public class esrima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parola = sc.nextLine();
        String parola2 = sc.nextLine();
        int posA = parola.length()-1;
        int posB = parola2.length()-1;
        int con = 0;
        while(parola.charAt(posA)== parola2.charAt(posB)){
            con ++;
            posA = posA -1;
            posB = posB -1;
        }System.out.println(con);
    }
}