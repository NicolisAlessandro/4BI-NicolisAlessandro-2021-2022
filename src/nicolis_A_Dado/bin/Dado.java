package nicolis_A_Dado.bin;

public class Dado {
    private int facce;
    private int num;

    public Dado(){
        this.facce=0;
        this.num=0;
    }

    public Dado(int facce){
        this.facce=facce;
        this.num=0;
    }

    public int getFacce() {
        return facce;
    }

    public void setFacce(int facce) {
        this.facce = facce;
    }

    public int LanciaDado(){
        int num=0;
        num=(int)(Math.random()*2);
        System.out.println(num);
        if(num==1){
            num=3;
        }else{
            num=(int)(Math.random() * this.facce)+1;
        }
        this.num=num;
        return this.num;
    }

    public String ToString(){
        String out="è uscito il numero "+this.num;
        return out;
    }
}
class DadoTest{
    public static void main(String[]args){
        Dado test1=new Dado(6);
        int d=0;
        d=test1.LanciaDado();
        System.out.println("il valore uscito dal lancio è "+ d);
    }
}


