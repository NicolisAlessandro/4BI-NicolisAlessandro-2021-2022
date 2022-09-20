package nicolis_A_Dadi.bin;

import java.util.Random;

public class Dadi {
    private int dado;

    public Dadi(){
        this.dado= 0;
    }

    public int lancioDado(){
        int num = 0;
        num =(int) (Math.random() * 2);
        System.out.println(num);
        if (num != 0){
            num = 0;
            num = (int) (Math.random() * 6) + 1;
        }else{
            num = 3;
        }
        this.dado = num;
        return this.dado;
    }
    public String toString(){
        String out ="";
        out = "il dado restituisce è " + this.dado;
        return out;
    }
} 
class DadiTest{   
    public static void main(String[] args) {
        Dadi test1 = new Dadi();
        int d = 0;
        
        for (int i = 0; i < 10; i++){
        d = test1.lancioDado();
        System.out.println("test1 " + d);
        }
    }
}
