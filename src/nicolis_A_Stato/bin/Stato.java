package nicolis_A_Stato.bin;

public class Stato {
    private String nomeStato;
    private double superficie;
    private double popolazione;

    public Stato(){
        this.nomeStato = "";
        this.superficie = 0;
        this.popolazione = 0;
    }

    public Stato(String nS, double s , double p ){
        this.nomeStato = nS;
        this.superficie = s;
        this.popolazione = p;
    }

    public void setnomeStato(string nS){
        this.nomeStato = nS;
    }

    public void setsuperficie(double s){
        this.superficie = s;
    }

    public void setpopolazione(double p){
        this.popolazione = p;
    }

    public String getnomeStato(){
        return this.nomeStato;
    }

    public double getsuperficie(){
        return this.superficie;
    }

    public double getpopolazione(){
        return this.popolazione;
    }

    public String toString(){
        String out = "";
        out += "il nome dello Stato è " + this.nomeStato;
        out += " e la superficie è " + this.superficie;
        out += " e la popolazione è " + this.popolazione;
        return out;
    }

    public double densità(){
        double d = 0;
        d = this.popolazione / this.superficie;
        return d;
    }

    public double confrontaStato(double d1, double d2){
        double n = 0;
        n = d1 - d2;
        System.out.println("il numero è "+ n);
        return n;
    }
    public boolean confrontaDen(double n1, double n2, double d){
        boolean v = false;
        if (n1 < d && d < n2){
            v = true;
        } 
        System.out.println("il confronto è " + v);
        return v;
    }
}

class StatoTest{
        public static void main(String[] args) {
            String nS1 = "Italia";
            double s1 = 302073;
            double p1 = 60360000;
            String nS2 = "Francia";
            double s2 = 675417;
            double p2 = 68300000;
            Stato S1 = new Stato(nS1, s1, p1);
            Stato S2 = new Stato(nS2, s2, p2);
            System.out.println(S1.toString());
            System.out.println(S2.toString());
            System.out.println("la densità1 è " + S1.densità());
            System.out.println("la densità2 è " + S2.densità());
            double n1 = 0;
            double n2 = 100;
            double d1 = S1.densità();
            double d2 = S2.densità();
            S1.confrontaStato(d1, d2);
            S2.confrontaDen(n1, n2, d2);
        }
}