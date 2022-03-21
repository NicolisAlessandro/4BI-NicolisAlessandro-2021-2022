package nicolis_A_Graficasemplice.doc;

import java.awt.Color;
import javax.swing.*;


/**
 *
 * @author lorenzo
 */
public class JFR03 extends JFrame {

    public JFR03() {
        this("Lorenzo!!");
    }

    public JFR03(String title) {
        super(title);
        JButton jb1 = new JButton("click");//create button  
        jb1.setBounds(130, 100, 100, 40);
        
        JLabel l1=new JLabel("Bellissimo!");
        l1.setBounds(130,140,100,40); // sotto pulsante

        JLabel l2=new JLabel("Bohhh!");
        Icon ic=new ImageIcon("icon/Burger.png");
        l2.setIcon(ic);
        l2.setBounds(130,180,ic.getIconHeight()+55,ic.getIconWidth()); // sotto pulsante
        l2.setBorder(BorderFactory.createLineBorder(Color.yellow));
        
        JTextField jt1;
        
        jt1=new JTextField();

        jt1.setBackground(Color.CYAN);
        jt1.setBounds(60,320,250,30);
        
        setLayout(null);  // nessn layout manager coordinate assolute
        setSize(400, 500);

        add(l1);
        add(l2);
        add(jb1);  
        add(jt1);
        
        //attacca un gestore eventi
        ALST03 ga=new ALST03();
        jt1.addActionListener(ga);
        jb1.addActionListener(ga);
        
        MLST03 gm=new MLST03();
        this.addMouseListener(gm);
        l2.addMouseListener(gm);
        
        
        
        this.setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFR03 j1=new JFR03("Primo Esempio");



    }
    
}
