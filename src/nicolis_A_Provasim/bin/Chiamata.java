package nicolis_A_Provasim.bin;

public class Chiamata {

    private String numero;
    private int durata;

    public Chiamata() {
        this.numero = "0000000000";
        durata = 0;
    }

    public Chiamata(String n, int d) {
        this.numero = n;
        this.durata = d;
    }

    public Chiamata(Chiamata c) {
        this.numero = c.getNumero();
        this.durata = c.durata;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String n) {
        this.numero = n;
    }

    public int getDurata() {
        return this.durata;
    }

    public void setDurata(int d) {
        this.durata = d;
    }

    public void setChiamata(String n, int d) {
        this.numero = n;
        this.durata = d;
    }

    @Override
    public String toString() {
        String st;

        st = "Chiamata verso il numero:" + this.numero + "durata minuti: " + this.durata;
        return st;
    }

    public boolean equals(Chiamata c) {
        return (this.toString().equals(c.toString()));
    }

}
