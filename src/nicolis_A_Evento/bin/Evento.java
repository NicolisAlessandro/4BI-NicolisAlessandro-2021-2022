package nicolis_A_Evento.bin;

public class Evento {
    private String titolo;
    private String data;
    private String oraDiInizio;
    private String oraDiFine;
    private String colore;

    public Evento(String titolo, String data, String oraDiInizio, String oraDiFine, String colore) {
        this.titolo = titolo;
        this.data = data;
        this.oraDiInizio = oraDiInizio;
        this.oraDiFine = oraDiFine;
        this.colore = colore;
    }

    public Evento() {
        this.titolo = "";
        this.data = "";
        this.oraDiInizio = "";
        this.oraDiFine = "";
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOraDiInizio() {
        return oraDiInizio;
    }

    public void setOraDiInizio(String oraDiInizio) {
        this.oraDiInizio = oraDiInizio;
    }

    public String getOraDiFine() {
        return oraDiFine;
    }

    public void setOraDiFine(String oraDiFine) {
        this.oraDiFine = oraDiFine;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public String toString() {
        return "Evento [colore=" + colore + ", data=" + data + ", oraDiFine=" + oraDiFine + ", oraDiInizio="
                + oraDiInizio + ", titolo=" + titolo + "]";
    }
}
