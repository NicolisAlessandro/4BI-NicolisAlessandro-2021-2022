package nicolis_A_Triangolo.bin;


public class Triangolo {
    private int base;
    private int altezza;
    private int lato1;
    private int lato2;
    private int lato3;

    public Triangolo() {
        this.base = 0;
        this.altezza = 0;
        this.lato1 = 0;
        this.lato2 = 0;
        this.lato3 = 0;
    }

    public Triangolo(int b, int a, int l1, int l2, int l3) {
        this.setTriangolo(b, a, l1, l2, l3);
    }

    public void setTriangolo(int b, int a, int l1, int l2, int l3) {
        this.base = b;
        this.altezza = a;
        this.lato1 = l1;
        this.lato2 = l2;
        this.lato3 = l3;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int b) {
        base = b;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int a) {
        altezza = a;
    }

    public int getLato1() {
        return lato1;
    }

    public void setLato1(int l1) {
        lato1 = l1;
    }

    public int getLato2() {
        return lato2;
    }

    public void setLato2(int l2) {
        lato2 = l2;
    }

    public int getLato3() {
        return lato3;
    }

    public void setLato3(int l3) {
        lato3 = l3;
    }

    public Triangolo getTriangolo() {
        Triangolo t = new Triangolo(this.getBase(), this.getAltezza(), this.getLato1(), this.getLato2(), this.getLato3());
        return t;
    }

    public double calcolaArea() {
        double area = (double) (this.base * this.altezza) / 2;
        return area;
    }

    public int calcolaPerimetro() {
        int perimetro = this.lato1 + this.lato2 + this.lato3;
        return perimetro;
    }

    @Override
    public String toString() {
        String out = "La base è : ";
        out += this.base + ", ";
        out += "l'altezza è " + this.altezza + ". ";
        out += "I lati sono: il primo è " + this.lato1 + ", ";
        out += "il secondo è " + this.lato2 + " ";
        out += "il terzo è " + lato3;
        out += "L'area è " + this.calcolaArea() + ", ";
        out += "mentre il perimetro è " + this.calcolaPerimetro();
        return out;
    }

}