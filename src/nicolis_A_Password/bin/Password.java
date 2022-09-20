package nicolis_A_Password.bin;

import java.util.Scanner;

public class password {

    public static boolean validity(String pww) {
        int len = pww.length();
        String specialCharacter = "#\\,.;:-_!|\"$%&/()='?:";
        boolean carMaiuscolo = false, carMinuscolo = false, carSpeciale = false, carNumero = false;
        if (len > 7) {
            for (int i = 0; i < len; i++) {
                if (!carMinuscolo)
                    carMinuscolo = Character.isLowerCase(pww.charAt(i));
                if (!carMaiuscolo)
                    carMaiuscolo = Character.isUpperCase(pww.charAt(i));
                if (!carNumero)
                    carNumero = Character.isDigit(pww.charAt(i));
                if (!carSpeciale)
                    if (specialCharacter.indexOf(pww.charAt(i)) > -1) {
                        carSpeciale = true;
                    }
            }
            if (carMaiuscolo && carMinuscolo && carSpeciale && carNumero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
        Scanner riga = new Scanner(System.in);
        String pass;
        do {
            System.out.println("inserire la Password");
            pass = riga.nextLine();
        } while (validity(pass) == false);
        System.out.println("Password coprretta");
    }
}