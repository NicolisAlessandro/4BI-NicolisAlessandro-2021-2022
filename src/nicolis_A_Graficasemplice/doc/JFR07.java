// layout composti e jpanel
package nicolis_A_Graficasemplice.doc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFR07 extends JFrame
        implements ActionListener {

    private final JButton jbt2;
    private JTextField jtx1;
    private final JFileChooser jfc;

    public JFR07() {
        this("Lorenzo!!");
    }

    public JFR07(String title) {
        super(title);
        Boolean save = true;

        JLabel jl1 = new JLabel("Layout composto");

        JButton jbt1 = new JButton("Clear");//create button
        jbt2 = new JButton("Save");//create button  
        JButton jbt3 = new JButton("Close");//create button
        jfc = new JFileChooser();
        JPanel pdx = new JPanel();
        pdx.setBackground(new Color(22, 0xcc, 44));
        pdx.setLayout(new BoxLayout(pdx, BoxLayout.Y_AXIS));


        pdx.add(jbt1);
        pdx.add(jbt2);
        pdx.add(jbt3);
        jfc.setVisible(false);

        pdx.add(jfc);
        JPanel psx = new JPanel();
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

        JSlider jsl = new JSlider(JSlider.HORIZONTAL, 10, 100, 55);
        jsl.setMajorTickSpacing(10);
        jsl.setMinorTickSpacing(1);
        jsl.setPaintTicks(true);
        jsl.setPaintLabels(true);
        Font font = new Font("Serif", Font.ITALIC, 15);
        jsl.setFont(font);

        JTextArea jta1 = new JTextArea();

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

    public static void main(String[] args) {
        JFR07 j1 = new JFR07("Layout sample");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbt2) {
            jfc.setVisible(true);

        }

    }

}
