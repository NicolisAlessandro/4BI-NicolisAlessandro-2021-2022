package nicolis_A_Dipendente.bin;


import java.util.Scanner;

public class Dipendente {
    private String matricola;
    private double stipendio;
    private double straordinario;

    public Dipendente() {
        this.matricola = "";
        this.stipendio = 0.0;
        this.straordinario = 0.0;
    }

    public Dipendente(String m, double stip, double stra) {
        this.matricola = m;
        this.stipendio = stip;
        this.straordinario = stra;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public double getStraordinario() {
        return straordinario;
    }

    public void setStraordinario(double straordinario) {
        this.straordinario = straordinario;
    }

    public double paga(int ore) {
        double pagatot = 0;
        pagatot = this.stipendio + this.straordinario * ore;
        return pagatot;
    }

    public String stampa() {
        String out = "";
        out = out + "il stipendio è " + this.stipendio + ", ";
        out = out + "la matricola è " + this.matricola + " e ";
        out = out + "lo straordinario è " + this.straordinario;
        return out;
    }
}

class DipendenteTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String matricola;
        double stipendio, straordinario;
        System.out.print("il matricola è ");
        matricola = sc.nextLine();
        System.out.print("lo straordinario è ");
        straordinario = sc.nextDouble();
        System.out.print("lo stipendio è ");
        stipendio = sc.nextDouble();
        Dipendente a1 = new Dipendente(matricola, stipendio, straordinario);
        System.out.println(a1.getStipendio());
        int ore = sc.nextInt();
        System.out.println("la paga totale è " + a1.paga(ore));
        System.out.println(a1.stampa());
    }
}