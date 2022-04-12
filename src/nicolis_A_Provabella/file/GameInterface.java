package nicolis_A_Provabella.file;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface GameInterface {
    void drawInterface(Graphics g, Point cornerOfScreen, Size screenSize);

    void mousePressed(MouseEvent me);

    void keyPressed(KeyEvent e);
}
