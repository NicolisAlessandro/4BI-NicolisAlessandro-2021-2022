package nicolis_A_Punto.bin;

import java.util.Scanner;

public class Punto {
    private double x;
    private double y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setx(double x) {
        this.x = x;
    }

    public void sety(double y) {
        this.y = y;
    }

    public double getx() {
        return this.x;
    }

    public double gety() {
        return this.y;
    }

    public String toString() {
        String out = "";
        out = "le cordinate sono " + this.x + ";" + y + ";";
        return out;
    }

    public double differenzaPuntoOrigine(double x, double y) {
        double dis = 0;
        dis = Math.sqrt((0 - x) * (0 - x) + (0 - y) * (0 - y));
        return dis;
    }

    public double differenzaPunti(double x1, double y1, double x2, double y2) {
        double dis = 0;
        dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return dis;
    }

    public double differenzaPunti2(Punto pippo) {
        double dis = 0;
        x1 = this.x;
        y1 = this.y;
        x2 = pippo.x;
        y2 = pippo.y;
        dis = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return dis;
    }

    public int vicinoPunto(double dis1, double dis2) {
        int v = 0;
        if (dis1 < dis2) {
            v = 1;
        } else if (dis1 > dis2) {
            v = -1;
        } else {
            v = 0;
        }
        return v;
    }
}

class PuntoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        Punto P1 = new Punto(x1, y1);
        Punto P2 = new Punto(x2, y2);
        System.out.println(P1);
        System.out.println(P2);
        double disp = P1.differenzaPunti(x1, y1, x2, y2);
        double disp2 = P1.differenzaPunti(P2);
        double dis1 = P1.differenzaPuntoOrigine(x1, y1);
        double dis2 = P2.differenzaPuntoOrigine(x2, y2);
        System.out.println("La distanza del P1 dall'origine è " + dis1);
        System.out.println("La distanza del P2 dall'origine è " + dis2);
        System.out.println("La distanza tra i 2 punti è " + disp);
        int v = P1.vicinoPunto(dis1, dis2);
        if (v == 1) {
            System.out.println("il punto più vicino è il P1 ");
        } else if (v == -1) {
            System.out.println("il punto più vicino è il P2 ");
        } else {
            System.out.println("il punti sono distanti uguali ");
        }
    }
}
