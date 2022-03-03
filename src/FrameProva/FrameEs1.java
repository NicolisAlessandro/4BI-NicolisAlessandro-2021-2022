package FrameProva;

import javax.swing.*;
import java.awt.*;
public class FrameProva extends JFrame{
    
    JLabel l0=new JLabel("rosso");
    JLabel l1=new JLabel("bianco");
    JLabel l2=new JLabel("verde");
    
    public FrameProva(){
        super("FlowÃLayout");
        
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l1);
        c.add(l2);
        c.add(l0);

        l0.setBounds(100,180,55,50); 
        l0.setBorder(BorderFactory.createLineBorder(Color.red));
        l1.setBounds(130,180,55,50); 
        l1.setBorder(BorderFactory.createLineBorder(Color.white));
        l2.setBounds(160,180,55,50); 
        l2.setBorder(BorderFactory.createLineBorder(Color.green));
        
        
        setSize(300,100);
        setVisible(true);
    }
}
