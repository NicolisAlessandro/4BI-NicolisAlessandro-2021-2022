package nicolis_A_Graficasemplice.doc;

import java.awt.Color;
import javax.swing.*;


/**
 *
 * @author lorenzo
 */
public class JFR02 extends JFrame {

    public JFR02() {
        this("Lorenzo!!");
    }

    public JFR02(String title) {
        super(title);
        JButton b = new JButton("click");//create button  
        b.setBounds(130, 100, 100, 40);
        
        JLabel l1=new JLabel("Bellissimo!");
        l1.setBounds(130,140,100,40); // sotto pulsante

        JLabel l2=new JLabel("Bohhh!");
        Icon ic=new ImageIcon("icon/Burger.png");
        l2.setIcon(ic);
        l2.setBounds(130,180,ic.getIconWidth()+55,50); // sotto pulsante
        l2.setBorder(BorderFactory.createLineBorder(Color.yellow));
        
        JTextField jt1;
        
        jt1=new JTextField();

        jt1.setBackground(Color.CYAN);
        jt1.setBounds(60,320,250,30);
        
        setLayout(null);  // nessn layout manager coordinate assolute
        setSize(400, 500);

        add(l1);
        add(l2);
        add(b);  
        add(jt1);
        
        this.setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFR02 j1=new JFR02("Primo Esempio");



    }
    
}
