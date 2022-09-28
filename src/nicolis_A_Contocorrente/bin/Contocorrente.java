package nicolis_A_Contocorrente.bin;

public class contocorrente {
    private final int maxMovimenti;
    private final double maxPreleva;
    private String titolare;
    private int nMovimenti;
    private double saldo;

    public contocorrente() {
        this.titolare = "";
        this.nMovimenti = 0;
        this.maxMovimenti = 50;
        this.saldo = 0.0;
        this.maxPreleva = 100000;
    }

    public contocorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
        this.maxMovimenti = 50;
        this.maxPreleva = 100000;
    }

    public void setTitolare(String titolare) {
        this.titolare = titolare;
    }

    public int getnMovimenti() {
        return nMovimenti;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void preleva(double prel) {
        if (prel < this.maxPreleva) {
            if (this.nMovimenti < this.maxMovimenti) {
                this.saldo = this.saldo - prel;
            }
        } else {
            this.saldo = this.saldo - prel - 0.5;
        }
        nMovimenti += 1;
    }

    public double restituisciSaldo() {
        return this.saldo;
    }
}

class contocorrenteTest {
    public static void main(String[] args) {
        contocorrente n1 = new contocorrente("grassi luca", 20000);
        n1.preleva(1750);
        System.out.println(n1.restituisciSaldo());
    }
}