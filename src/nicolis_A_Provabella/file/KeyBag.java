package nicolis_A_Provabella.file;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

import main.game.Config;
import main.game.maze.interactable.creature.player.Player;
import main.game.system.Session;
import main.game.util.Size;
import main.game.util.Util;

public class KeyBag extends JPanel {
    private static final long serialVersionUID = 6640663680636318930L;
    public static final int HEIGHT = 30;	//2*padding for key image + keybag key image size
    public static final int WIDTH = Board.WIDTH;
    public static final int PADDING_KEY_IMAGE = 5;
    public static final Size SIZE_IMAGE = new Size(20,20);
    private Session session;

    public KeyBag(Session session){
        this.session = session;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        setBackground(Config.COLOR_BACKGROUND);
        drawPlayerKeys(g);
    }

    private void drawPlayerKeys(Graphics g) {
        Player player = session.getMaze().getPlayer();
        for (int i = 0; i < player.getKeys().size(); i++){
            Image image = player.getKeys().get(i).getImage();
            Point point = new Point(PADDING_KEY_IMAGE + i * (PADDING_KEY_IMAGE + SIZE_IMAGE.width),
                    PADDING_KEY_IMAGE);
            Util.drawImage(g, image, point, SIZE_IMAGE);
        }
    }
}
