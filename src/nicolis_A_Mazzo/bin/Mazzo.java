package nicolis_A_Mazzo.bin;

import nicolis_A_Carta.bin.Carta;

public class Mazzo {

    private Carta[] m;
    private int numc;

    public Mazzo() {
        m = new Carta[10];
        numc = 0;
    }

    public int size() {
        return numc;
    }

    private void estendi() {
        Carta[] t = new Carta[m.length * 2];
        if (numc >= 0) System.arraycopy(m, 0, t, 0, numc);
        this.m = t;

    }

    public boolean add(Carta c) {
        if (numc >= m.length) {
            estendi();
        }
        m[numc] = c;
        numc++;
        return true;
    }

    public boolean add(Carta c, int pos) {
        if (pos >= 0 && pos <= numc) {
            if (numc >= m.length) {
                estendi();
            }

            for (int i = numc; i >= pos; i--)
                m[i] = m[i - 1];

            m[pos] = c;
            numc++;
            return true;
        } else
            return false;
    }

    public Carta rem() {
        return null;
    }

    public Carta rem(int pos) {
        return null;
    }

    public Carta get(int pos) {
        return null;
    }

    public void mescola() {

        for (int i = 0; i < numc * 10; i++) {
            int p1, p2;
            p1 = (int) (Math.random() * numc);
            p2 = (int) (Math.random() * numc);
            Carta c;
            c = m[p1];
            m[p1] = m[p2];
            m[p2] = c;


        }
    }

    public void init52() {
        numc = 0;
        m = new Carta[52];
        for (char c : "CQFP".toCharArray())
            for (int i = 1; i <= 13; i++)
                add(new Carta(i, c));

    }

    public void cover() {
        for (int i = 0; i < numc; i++)
            m[i].setNascosta(true);
    }

    public void show() {
        for (int i = 0; i < numc; i++)
            m[i].setNascosta(false);
    }

    public String toString() {
        StringBuffer t = new StringBuffer();
        t.append("[");
        if (numc > 0) {
            t.append(m[0]);
            for (int i = 1; i < numc; i++) {
                t.append(",");
                t.append(m[i]);
            }
        }
        t.append("]");
        return t.toString();
    }
}
