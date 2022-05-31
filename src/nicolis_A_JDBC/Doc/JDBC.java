import java.squil.*;
import java.until.*;


public JDBC{

        public JDBC{

        }

        conn=DriverManager.getConnection(
        "jdbc:sqlite:magaz.db");

public static int insertProdotti(Connection c,String nome,String matricola,String cognome,String classe,String annoSc)throws SQLException{
        int r;
        String insertTableSQL="INSERT INTO prodotti values (?,?,?)";
        PreparedStatement ps=c.prepareStatement(insertTableSQL);
        ps.setString(1,nome);
        ps.setString(2,cognome);
        ps.setString(3,matricola);
        r=ps.executeUpdate();
        return r;
        }


public static int creaTab(Connection c)throws SQLException{
        Statement stmt=null;
        stmt=c.createStatement();
        String create="CREATE TABLE studenti ("
        +"  nome varchar(10) primary key,"
        +"  cognome varchar(30) DEFAULT NULL,"
        +"  matricola int not null auto_increment,"
        +") ";
        System.out.println(create);
        int r=stmt.executeUpdate(create);
        return r;
        }


public static void visProdotti(Connection c)throws SQLException{
        Statement stmt=null;
        ResultSet rs=null;
        stmt=c.createStatement();
        rs=stmt.executeQuery("SELECT * FROM prodotti");

        while(rs.next()){
        System.out.println(rs.getString("nome")
        +"  "+rs.getString("cognome")+"  "
        rs.getString("matricola")
        }
        stmt.close();
        }

}

public static void main(String[]args){
        JDBC data = new JBCD;

        }

//# mysql -h Decal.marconivr.it  -u utfrasi -p  connetersi a un daatbase
// MySQL [(nome)] use dbfrasi
//query ok, 4 rows affected    query dice se è riuscito a caricare i dati e quante righe sono state modificate
// select from frase join autore on (frase.idautore = autore.id); mette in collegamento le 2 tabelle
// order by nomeVariabile  mette in ordinare a seconda della variabile data (desc dal più grande al più piccolo, )
//show create table nomeTable mostra come viene creato
//show tables mostra tutte le tabelle
//utfrasi pass psfrasi
