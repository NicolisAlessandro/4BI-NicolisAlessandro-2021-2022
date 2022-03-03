package FrameProva;
import javax.swing.*;
import java.awt.*;
public class FrameProva extends JFrame{
    JButton uno=new JButton("Uno");
    JButton due=new JButton("Due");
    JButton tre=new JButton("Tre");
    JButton quattro=new JButton("Quattro");
    JButton cinque = new JButton("Cinque");
    
    public FrameProva(){
        super("FlowÃLayout");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());
        c.add(uno);
        c.add(due);
        c.add(tre);
        c.add(quattro);
        c.add(cinque);
        setSize(300,100);
        setVisible(true);
    }
}
