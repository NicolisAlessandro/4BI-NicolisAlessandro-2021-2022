package expl01;
import javax.swing.*;

/**
 *
 * @author lorenzo
 */
public class JFR01 extends JFrame {

    public JFR01() {
        this("Lorenzo!!");
    }

    public JFR01(String title) {
        super(title);
        JButton b = new JButton("click");//create button  
        b.setBounds(10, 100, 100, 40); // x,y,w,h posizionamento

        this.add(b);//adding button on frame  
        setSize(400, 500);
        setLayout(null);  // nessn layout manager coordinate assolute
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFR01 j1=new JFR01("Primo Esempio");


        //con un click si cancella tutto
    }
    
}
