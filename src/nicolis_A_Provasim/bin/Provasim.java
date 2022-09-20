package nicolis_A_Provasim.bin;

import java.util.ArrayList;

class Provasim {

	private String numeroT;
	private float credito;
	private final double costo = 0.25;
	private ArrayList<Chiamata> lista;

	public Provasim() {
		this.numeroT = "";
		this.credito = 0;
		this.lista = new ArrayList<Chiamata>();
	}

	public Provasim(String n, float c ) {
		if (n == null) {
			this.numeroT = "";
		}else{
			this.numeroT = n;
		}
		if (c >= 0) {
			this.credito = c;
		}else{
			this.credito = 0;
		}

		this.lista = new ArrayList<Chiamata>();
	}

	public String getNumeroT() {
		return numeroT;
	}

	public void setNumeroT(String numeroT) {
		this.numeroT = numeroT;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public double getCosto() {
		return costo;
	}

	@Override
	public String toString() {
		String out="";

		out += "Provasim{" +
				"numeroT='" + numeroT + '\'' +
				", credito=" + credito +
				", costo=" + costo;

		for (Chiamata c : this.lista){
			out += "\n" + c.toString();
		}

		return out;
	}

	public Provasim(Provasim p){
		if (p.numeroT == null) {
			this.numeroT = "";
		}else{
			this.numeroT = p.numeroT;
		}
		if (p.credito >= 0) {
			this.credito = p.credito;
		}else{
			this.credito = 0;
		}

		this.lista = new ArrayList<Chiamata>();
		for (Chiamata c : p.lista){
			lista.add(new Chiamata(c));
		}
	}

	public boolean add(String s, in)

	public boolean equals(Provasim p) {
		return this.toString().equals(p.toString());
	}

}

class ProvasimTest {
	public static void main(String[] args) {
		String st="0000000000";
		Provasim s = new Provasim("0123456789", 20);
		s.add(st,3);
		s.add("7897897895",5);
		System.out.println(s);
		System.out.println("totale chiamate in min:" + s.calcolaDurataTotale());

		if(!s.inserimento(st,7)){
			System.out.println("credito esaurito");
		}
		Chiamata c=new Chiamata("4564564562",4);
		if(!s.inserimento(c)){
			System.out.println("credito esaurito");
		}
		else System.out.println(s);
		System.out.println("chiamate di:" +s.getNumero()+ "verso:" +c.getNumero()+" : " +s.contaChiamate(c));
		if(!s.inserimento(st,7)){
			System.out.println("credito esaurito";);
		}
		if(s.inserimento("7897897895",4) == false){
			System.out.println("credito esaurito");
		}
		System.out.println(s.toString());

	}
}