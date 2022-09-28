package nicolis_A_Provabella.file;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerPanel extends JPanel {
    public static final int WIDTH = MiniMap.WIDTH;
    public static final int HEIGHT = Board.HEIGHT + KeyBag.HEIGHT - MiniMap.HEIGHT;
    static final Color COLOR_BACKGROUND = Color.BLACK;
    static final int SWITCHTAB_HEIGHT = 30;
    static final int INVENTORY_SLOTS_HORIZONTAL = 5;
    static final int INVENTORY_SLOTS_VERTICAL = 6;
    public static final int INVENTORY_SIZE = INVENTORY_SLOTS_HORIZONTAL * INVENTORY_SLOTS_VERTICAL;
    private static final long serialVersionUID = 8598148008009578889L;
    private Session session;
    private final PlayerPanelInterface openInterface;

    public PlayerPanel(Session session) {
        this.session = session;
        openInterface = new PlayerPanelInventory(session);
        addMouseListener(new MouceClickListener());
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(COLOR_BACKGROUND);
        openInterface.draw(g);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    private class MouceClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent me) {
            if (me.getPoint().y < SWITCHTAB_HEIGHT) {
                System.out
                        .println("PlayerPanel.MouceClickListener.mousePressed()");
            }
            openInterface.mousePressed(me);
        }
    }
}
