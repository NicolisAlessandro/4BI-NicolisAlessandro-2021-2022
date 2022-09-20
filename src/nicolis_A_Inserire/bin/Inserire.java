package nicolis_A_Inserire.bin;

//chiedere 5 numeri 2 volte e dire quale maggiore



import java.util.Scanner;
public class Inserire{
    public static Double mediaVoti(){
        Scanner sc = new Scanner(System.in);
        double n, s = 0, m;
        for (int i=0 ; i < 3; i++){
            n = sc.nextDouble();
            s= s + n;
        }
        m = s / 3;
        return m;
    }
    public static void main (String arg[]){
        double mita, mmate, minfo, msto;
        System.out.println("dare un voto d'italiano");
        mita=mediaVoti();
        System.out.println("dare un voto di matematica");
        mmate=mediaVoti();
        System.out.println("dare un voto d'informatica");
        minfo=mediaVoti();
        System.out.println("dare un voto di storia");
        msto=mediaVoti();
        System.out.println("La media di matematica  è "+ mmate );
        System.out.println("La media d'italiano  è "+ mita );
        System.out.println("La media d'informatica  è "+ minfo );
        System.out.println("La media di storia  è "+ msto );

          if (6 > mmate){
            System.out.println("hai il debito  " );
          }
          if (6 > mita){
            System.out.println("hai il debito  " );
          }
          if (6 > minfo){
            System.out.println("hai il debito  " );
          }
          if (6 > msto){
            System.out.println("hai il debito  " );
          }
    }
}