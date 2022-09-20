package nicolis_A_Calendario.bin;


public class calendario {
    private Evento[] lista;
    private int conta;

    public calendario(Evento[] lista, int conta) {
        for(int i =0; i < lista.length; i++){
            this.lista[i] = lista[i];
        }
        
        this.conta = conta;
    }

    public calendario() {
        this.lista = new Evento[10];
        this.conta = 0;
    }

    public Evento[] getLista() {
        return lista;
    }

    public void setLista(Evento[] lista) {
        this.lista = lista;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;       
    }

    public void aggiungiEvento(String titolo, String data, String oraDiInizio, String oraDiFine, String colore){

        Evento a = new Evento(titolo, data, oraDiInizio, oraDiFine, colore);

        if(conta >= lista.length){
            espandi();
        }
        lista [conta] = a;
        conta++;
    }

    public void aggiungiEvento(Evento a){

        if(conta >= lista.length){
            espandi();
        }
        lista [conta] = a;
        conta++;
    }

    public void espandi(){
        Evento[] b = new Evento[lista.length*2];
            for (int i = 0; i < lista.length; i++){
                b[i] = lista[i];
            }
            lista = b;
    }

    public void rimuoviEvento(String titolo){

        for (int i = 0; i < conta; i++){
            Evento tm = lista[i];
            
            if (tm.getTitolo().equals(titolo)){
                
                for (int j = i; j < conta-1; j++){
                    lista[j] = lista[j+1];
                    
                }
            conta --;
            }
            System.out.println(lista[i]);
        }
    }
    
    public Evento[] cercaEventi(String data){
        
        Evento[] a = new Evento[lista.length];

        for (int i = 0; i < this.conta; i++){
            Evento tm = lista[i];
            

            if (tm.getData().equals(data)){
                int b = 0;
                a[b] = tm;
                b++;
                
            }
            
        }
        return a;
    }  
}
