package nicolis_A_Alunno.bin;

public class alunno {
    private String nome;
    private String cognome;
    private int eta;
    public alunno(){
        eta = 15;
    }
    public alunno(int neweta){
        eta = neweta;
    }
    public alunno(String newn, String newc){
        nome = newn;
        cognome = newc;
        eta = 15;
    }
    public void setnome(String cesare){
        this.nome = cesare;
    }
    public void setcognome(String cesare){
        this.cognome = cesare;
    }
    public void seteta(int neweta){
        this.eta = neweta;
    }

    public String toString (){
        String out ="";
        out = " il nome è " + nome + "\n il cognome è " + cognome + "\n" + "l'età è " + eta;
        return out;
    }
    public String getNome(){
        return nome;
    }
    public void piuVecchio(alunno a){
        System.out.println("il più vecchio è ");
            if (this.eta > a.eta){
            System.out.println(this.toString());
        }
        if(this.eta == a.eta){
            System.out.println("hanno la stessa età");
        }if(this.eta < a.eta){
            System.out.println(a.toString());
        }
    }

    public int maggiorenne() {
        if (eta<18) {return 0;}
        else{return 1;}
    }
    public int maggioredi(int numero) {
        if (eta<numero) {return 0;}
        else{return 1;}
    }
    public alunno piuVecchio2(alunno a){
       
            if (this.eta > a.eta){
           return this;
        }

        if(this.eta == a.eta){
           return a;
        }if(this.eta < a.eta){
            return a;
        }
        return a;
    }
    public static void main(String[] args) {
        alunno a1 = new alunno();
        alunno a2 = new alunno();
        a1.setnome("Cesare");
        a2.setnome("Alessio");
        alunno a3 = new alunno(12);
        alunno a4 = new alunno("Mario", "Rossi");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        System.out.println(a4.toString());
        if (a4.maggioredi(21)== 0) {
            System.out.println(a4.toString()+ " minore21");
        }
        a2.seteta(16);
        System.out.println(a2.toString());
        System.out.println(a4.getNome());
        a3.piuVecchio(a2);
        System.out.println( a3.piuVecchio2(a2).toString());
    }
}
