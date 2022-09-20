package nicolis_A_Motorino.bin;

package esinfo;

import java.util.Scanner;

public class Motorino{
    private String colore;
    private double velocità;
    private String tipo;
    private boolean antifurto;

    public Motorino(){
        this.colore = "";
        this.velocità = 0.0;
        this.tipo = "";
        this.antifurto = false;
    }

    public Motorino(String colore, double velocità, String tipo){
        this.colore = colore;
        this.velocità = velocità;
        this.tipo = tipo;
        this.antifurto = false;
    }
    
    public String toString() {
        String out = "";
        out = out + "il colore è " + this.colore + ", ";
        out = out + "la velocità è " + this.velocità + ", ";
        out = out + "il tipo è " + this.tipo + " e ";
        out = out + "l'antifurto è " + this.antifurto;
        return out;
    }
    
    public void setColore(String colore){
        this.colore = colore;
    }

    public void setVelocità(double velocità) {
        this.velocità = velocità;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColore(){
        return this.colore;
    }

    public double getVelocità(){
        return this.velocità;
    }

    public String getTipo(){
        return this.tipo;
    }

    public double acceleraV(double ac){
        if(antifurto == false){
            this.velocità += ac; 
        }
        return this.velocità;
    }

    public boolean inserisciAntifurto(){
        this.antifurto = true;
        return this.antifurto;
    }
}

class UsoMotorino{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String colore, tipo;
        double velocità;
        System.out.printf("il colore è ");
        colore = sc.nextLine();
        System.out.printf("il tipo è ");
        tipo = sc.nextLine();
        System.out.printf("la velocità Max è ");
        velocità = sc.nextDouble();
        Motorino m1 = new Motorino(colore, velocità, tipo);
        System.out.println(m1.toString());
        System.out.println(m1.getVelocità());
        double ac = 30;
        System.out.println(m1.acceleraV(ac));
        System.out.println(m1.inserisciAntifurto());
        System.out.println(m1.acceleraV(ac));
    }
}