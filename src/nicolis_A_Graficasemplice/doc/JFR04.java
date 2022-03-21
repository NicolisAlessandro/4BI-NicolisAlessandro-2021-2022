//Gestore interno 

package nicolis_A_Graficasemplice.doc;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author lorenzo
 */
public class JFR04 extends JFrame implements MouseListener{
    private JLabel jl1;
    public JFR04() {
        this("Lorenzo!!");
    }

    public JFR04(String title) {
        super(title);
        JButton jb1 = new JButton("click");//create button  
        jb1.setBounds(130, 100, 100, 40);
        
        jl1=new JLabel("Bellissimo!");
        jl1.setBounds(130,140,100,40); // sotto pulsante

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

        add(jl1);
        add(l2);
        add(jb1);  
        add(jt1);
        
        //attacca un gestore eventi
        ALST03 ga=new ALST03();
        jt1.addActionListener(ga);
        
        jb1.addActionListener(ga);
        
        
        //MLST03 gm=new MLST03();
        addMouseListener(this);  //autogestione
        
        l2.addMouseListener(this);
        
        
        
        this.setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void mouseClicked(MouseEvent me) {
        // ma soprattutto accesso agli oggetti della classe
        String tmp=jl1.getText();
        if (tmp.length()>15)
                tmp="#";
        else
            tmp+="#";
        jl1.setText(tmp);
        //System.out.println(me.getX()+ " "+me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
            System.out.println("mouse entrato in pos "+ me.getX()+ " "+me.getY());
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    
    
    
    
    
        public static void main(String[] args) {
        JFR04 j1=new JFR04("Primo Esempio");



    }
    
    
}
