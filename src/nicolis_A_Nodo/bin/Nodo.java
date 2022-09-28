package nicolis_A_Nodo.bin;

public class Nodo {
    private int e;
    private Nodo s;

    public Nodo() {
        this.e = 0;
        this.s = null;
    }

    public Nodo(int e) {
        if (e > 0) {
            this.e = e;
        }
    }

    public Nodo(Nodo s) {
        if (s != null) {
            this.s = s;
        }
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public Nodo getS() {
        return s;
    }

    public void setS(Nodo s) {
        this.s = s;
    }

    public String toString() {
        return "Nodo [elementi=" + e + ", Nodo successivo=" + s + "]";
    }

    public boolean equals(Nodo n) {
        if (n != null) {
            return this.s == n;
        } else {
            return false;
        }

    }
}
