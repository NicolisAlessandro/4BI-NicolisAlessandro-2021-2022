/*
 * gestisce un eventodel mouse hw
 */
package expl01;
import java.awt.event.*;
public class MLST03 implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println(me.getX()+ " "+me.getY());
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