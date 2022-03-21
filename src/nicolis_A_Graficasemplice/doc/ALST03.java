package nicolis_A_Graficasemplice.doc;
import java.awt.event.*;
public class ALST03 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.getActionCommand());
        System.out.println(ae.getSource()); 
    }
}
