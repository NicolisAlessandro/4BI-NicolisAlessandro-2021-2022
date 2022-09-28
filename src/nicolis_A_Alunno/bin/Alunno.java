package nicolis_A_Alunno.bin;

public class Alunno {
    private String nome;
    private String cognome;
    private int eta;

    public Alunno() {
        eta = 15;
    }

    public Alunno(int neweta) {
        eta = neweta;
    }

    public Alunno(String newn, String newc) {
        nome = newn;
        cognome = newc;
        eta = 15;
    }

    public static void main(String[] args) {
        Alunno a1 = new Alunno();
        Alunno a2 = new Alunno();
        a1.setnome("Cesare");
        a2.setnome("Alessio");
        Alunno a3 = new Alunno(12);
        Alunno a4 = new Alunno("Mario", "Rossi");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        if (a4.maggioredi(21) == 0) {
            System.out.println(a4 + " minore21");
        }
        a2.seteta(16);
        System.out.println(a2);
        System.out.println(a4.getNome());
        a3.piuVecchio(a2);
        System.out.println(a3.piuVecchio2(a2).toString());
    }

    public void setnome(String cesare) {
        this.nome = cesare;
    }

    public void setcognome(String cesare) {
        this.cognome = cesare;
    }

    public void seteta(int neweta) {
        this.eta = neweta;
    }

    public String toString() {
        String out = "";
        out = " il nome è " + nome + "\n il cognome è " + cognome + "\n" + "l'età è " + eta;
        return out;
    }

    public String getNome() {
        return nome;
    }

    public void piuVecchio(Alunno a) {
        System.out.println("il più vecchio è ");
        if (this.eta > a.eta) {
            System.out.println(this);
        }
        if (this.eta == a.eta) {
            System.out.println("hanno la stessa età");
        }
        if (this.eta < a.eta) {
            System.out.println(a);
        }
    }

    public int maggiorenne() {
        if (eta < 18) {
            return 0;
        } else {
            return 1;
        }
    }

    public int maggioredi(int numero) {
        if (eta < numero) {
            return 0;
        } else {
            return 1;
        }
    }

    public Alunno piuVecchio2(Alunno a) {

        if (this.eta > a.eta) {
            return this;
        }

        if (this.eta == a.eta) {
            return a;
        }
        if (this.eta < a.eta) {
            return a;
        }
        return a;
    }
}
