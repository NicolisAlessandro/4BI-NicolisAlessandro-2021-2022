package nicolis_A_Cinema.bin;

public class Cinema {
    private static int numero=0;
    private int salaCinema;
    private String film;
    private int postiOcc;
    private int file;
    private final int maxFila=21;

    public Cinema(){
        this.salaCinema=numero++;
        this.film="";
        this.postiOcc=0;
        this.file=0;
    }
    public Cinema(String film,int file){
        this.salaCinema=numero++;
        this.film=film;
        this.file=file;
        this.postiOcc=0;
    }

    public int getPosti(){
        return this.file*this.maxFila-postiOcc;
    }

    public void VendiBiglietti(int nBiglietti){
        if(nBiglietti>0){
           this.postiOcc=this.postiOcc+nBiglietti;
        }
    }

    public String toString() {
        return "Cinema{" +
                "salaCinema=" + salaCinema +
                ", film='" + film +
                ", postiOcc=" + postiOcc +
                ", file=" + file +
                ", maxFila=" + maxFila +
                '}';
    }
    public int Confronta (Cinema s2){
        if (s2.postiOcc <= this.postiOcc) {
            return s2.salaCinema;
        } else {
            return this.salaCinema;
        }
    }
}

public class salaCinema extends Cinema() {
    
}
class CinemaTest{
    public static void main(String[] args) {

        Cinema c1=new Cinema(" Creed || ",15);
        Cinema c2=new Cinema(" Scooby doo ",18);

        c1.VendiBiglietti(5);
        c2.VendiBiglietti(24);

        System.out.println(c1.getPosti());
        System.out.println(c2.getPosti());

        System.out.println(c1.Confronta(c2));
    }
}