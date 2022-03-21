//Gestore interno 
// attributi e non locali

package nicolis_A_Graficasemplice.doc;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class JFR05 extends JFrame 
        implements MouseListener,ActionListener{
    private JLabel jl1;
    private JButton jb1;
    private JTextField jt1;
    private JLabel jl2;
    public JFR05() {
        this("Lorenzo!!");
    }

    public JFR05(String title) {
        super(title);
        jb1= new JButton("click");//create button  
        jb1.setBounds(130, 100, 100, 40);
        
        jl1=new JLabel("Bellissimo!");
        jl1.setBounds(130,140,100,40); // sotto pulsante

        jl2=new JLabel("Bohhh!");
        Icon ic=new ImageIcon("icon/Burger.png");
        jl2.setIcon(ic);
        jl2.setBounds(130,180,ic.getIconHeight()+55,ic.getIconWidth()); // sotto pulsante
        jl2.setBorder(BorderFactory.createLineBorder(Color.yellow));
        jl2.setOpaque(true);
        
        jt1=new JTextField();

        jt1.setBackground(Color.CYAN);
        jt1.setBounds(60,320,250,30);
        
        setLayout(null);  // nessn layout manager coordinate assolute
        setSize(400, 500);

        add(jl1);
        add(jl2);
        add(jb1);  
        add(jt1);
        
        //attacca un gestore eventi

        jt1.addActionListener(this); // autogestione
        
        jb1.addActionListener(this);
        
        
        //MLST03 gm=new MLST03();
        addMouseListener(this);  //autogestione
        
        jl2.addMouseListener(this);
        
        
        
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        // discrimina la sorgente dell' azione e in sehuito agisce
        if (ae.getActionCommand().equals("click")){ // pulsante
            //cambia sfondo al frame
            Color c;
            c=jl2.getBackground();
            jl2.setBackground(c.darker());

        }
        if (ae.getSource()==jt1){
            jl1.setText(jt1.getText());
        }
    }
    
    
        public static void main(String[] args) {
        JFR05 j1=new JFR05("Primo Esempio");


    }
    
    
}
