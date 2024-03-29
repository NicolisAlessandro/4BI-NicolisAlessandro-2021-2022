//layout   https://docs.oracle.com/javase/tutorial/uiswing/index.html

package nicolis_A_Graficasemplice.doc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFR06 extends JFrame
        implements ActionListener {

    private final JButton jbt1;

    public JFR06() {
        this("Lorenzo!!");
    }

    public JFR06(String title) {
        super(title);
        jbt1 = new JButton("Fix");//create button  
        JButton jbt2 = new JButton("add 02");//create button

        JLabel jl1 = new JLabel("Label 01");
        JLabel jl2 = new JLabel("Label 02");

        Icon ic = new ImageIcon("icon/Burger.png");
        jl2.setIcon(ic);

        JTextField jtx1 = new JTextField();
        JTextArea jta1 = new JTextArea();
        jta1.setColumns(30);
        jta1.setRows(25);
        jbt1.setVerticalAlignment(JButton.CENTER);
//1       setLayout(new FlowLayout());
//2
//        LayoutManager l = new BoxLayout(this.getContentPane(), 
//                BoxLayout.X_AXIS);
//        setLayout(l);

//3
        setLayout(new GridLayout(3, 0, 20, 5));


        setSize(600, 500);

        add(jl1);
        add(jl2);
        add(jtx1);
        add(jta1);
        add(jbt1);
        add(jbt2);


        jbt1.addActionListener(this);

        setResizable(true);
        updateJbt1Text();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFR06 j1 = new JFR06("Layout !!!!");

    }

    // cambia il testo del pulsante in base allo stato di Resizable
    private void updateJbt1Text() {
        if (isResizable()) {
            jbt1.setText("Fix");
        } else {
            jbt1.setText("Resiz");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jbt1) {
            setResizable(!this.isResizable());
            updateJbt1Text();

        }// discrimina la sorgente dell' azione e in sehuito agisce
    }

}
