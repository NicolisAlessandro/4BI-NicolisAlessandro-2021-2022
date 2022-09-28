package nicolis_A_Motorino.bin;

import java.util.Scanner;

public class Motorino {
    private String colore;
    private double velocita;
    private String tipo;
    private boolean antifurto;

    public Motorino() {
        this.colore = "";
        this.velocita = 0.0;
        this.tipo = "";
        this.antifurto = false;
    }

    public Motorino(String colore, double velocita, String tipo) {
        this.colore = colore;
        this.velocita = velocita;
        this.tipo = tipo;
        this.antifurto = false;
    }

    public String toString() {
        String out = "";
        out = out + "il colore è " + this.colore + ", ";
        out = out + "la velocità è " + this.velocita + ", ";
        out = out + "il tipo è " + this.tipo + " e ";
        out = out + "l'antifurto è " + this.antifurto;
        return out;
    }

    public String getColore() {
        return this.colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public double getVelocita() {
        return this.velocita;
    }

    public void setVelocita(double velocita) {
        this.velocita = velocita;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double acceleraV(double ac) {
        if (!antifurto) {
            this.velocita += ac;
        }
        return this.velocita;
    }

    public boolean inserisciAntifurto() {
        this.antifurto = true;
        return this.antifurto;
    }
}

class UsoMotorino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String colore, tipo;
        double velocita;
        System.out.print("il colore è ");
        colore = sc.nextLine();
        System.out.print("il tipo è ");
        tipo = sc.nextLine();
        System.out.print("la velocita Max è ");
        velocita = sc.nextDouble();
        Motorino m1 = new Motorino(colore, velocita, tipo);
        System.out.println(m1);
        System.out.println(m1.getVelocita());
        double ac = 30;
        System.out.println(m1.acceleraV(ac));
        System.out.println(m1.inserisciAntifurto());
        System.out.println(m1.acceleraV(ac));
    }
}