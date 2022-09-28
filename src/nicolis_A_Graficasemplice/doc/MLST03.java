/*
 * gestisce un eventodel mouse hw
 */
package nicolis_A_Graficasemplice.doc;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MLST03 implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println(me.getX() + " " + me.getY());
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}