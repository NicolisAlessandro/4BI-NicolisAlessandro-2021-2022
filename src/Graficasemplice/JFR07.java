// layout composti e jpanel
package expl01;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

public class JFR07 extends JFrame
        implements ActionListener {

    private JLabel jl1;
    private JButton jbt1, jbt2, jbt3;
    private JTextArea jta1;
    private JTextField jtx1;
    private JPanel pdx, psx;
    private Boolean save;
    private JSlider jsl;
    private JFileChooser jfc;
    public JFR07() {
        this("Lorenzo!!");
    }

    public JFR07(String title) {
        super(title);
        save = true;

        jl1 = new JLabel("Layout composto");

        jbt1 = new JButton("Clear");//create button  
        jbt2 = new JButton("Save");//create button  
        jbt3 = new JButton("Close");//create button  
        jfc=new JFileChooser();
        pdx = new JPanel();
        pdx.setBackground(new Color(22, 0xcc, 44));
        pdx.setLayout(new BoxLayout(pdx, BoxLayout.Y_AXIS));

        
        
        pdx.add(jbt1);
        pdx.add(jbt2);
        pdx.add(jbt3);
        jfc.setVisible(false);

        pdx.add(jfc);
        psx = new JPanel();
        psx.setBackground(new Color(22, 0xcc, 44));
        psx.setLayout(new GridLayout(4, 4));

        String[] lbt = {
            " 7", " 8", " 9", " /",
            " 4", " 5", " 6", " +",
            " 1", " 2", " 3", " *",
            " 0", " .", " C", " +"};

        for (String s : lbt) {
            JButton jb = new JButton(s);
            psx.add(jb);
        }

        jsl = new JSlider(JSlider.HORIZONTAL, 10, 100, 55);
        jsl.setMajorTickSpacing(10);
        jsl.setMinorTickSpacing(1);
        jsl.setPaintTicks(true);
        jsl.setPaintLabels(true);
        Font font = new Font("Serif", Font.ITALIC, 15);
        jsl.setFont(font);
        
        jta1 = new JTextArea();

        setLayout(new BorderLayout());  // nessn layout manager coordinate assolute
        setSize(400, 500);

        add(jl1, BorderLayout.NORTH);
        add(jsl, BorderLayout.SOUTH);
        add(pdx, BorderLayout.EAST);
        add(jta1, BorderLayout.CENTER);
        add(psx, BorderLayout.WEST);

        jbt2.addActionListener(this);
        jfc.addActionListener(this);


        this.setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbt2) {
            jfc.setVisible(true);

        }

    }

    public static void main(String[] args) {
        JFR07 j1 = new JFR07("Layout sample");

    }

}
