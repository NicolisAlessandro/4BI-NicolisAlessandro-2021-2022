package nicolis_A_Provabella.file;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame implements GameAction {
    public static final int HEIGHT = Board.HEIGHT + KeyBag.HEIGHT;
    public static final int WIDTH = Board.WIDTH + MiniMap.WIDTH;
    public static final Size SIZE = new Size(WIDTH, HEIGHT);
    private static final long serialVersionUID = 2068148394786292635L;
    private final Session session;

    public GameWindow(Session session) {
        this.session = session;
        setTitle("Labyrinth");
        getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board(session);
        MiniMap miniMap = new MiniMap(session);
        KeyBag keyBag = new KeyBag(session);
        PlayerPanel playerPanel = new PlayerPanel(session);
        setLayout(null);
        add(board);
        add(miniMap);
        add(keyBag);
        add(playerPanel);
        board.setBounds(0, 0, Board.WIDTH, Board.HEIGHT);
        miniMap.setBounds(Board.WIDTH, 0, MiniMap.WIDTH, MiniMap.HEIGHT);
        keyBag.setBounds(0, Board.HEIGHT, KeyBag.WIDTH, KeyBag.HEIGHT);
        playerPanel.setBounds(Board.WIDTH, MiniMap.HEIGHT,
                PlayerPanel.WIDTH, PlayerPanel.HEIGHT);
        board.addKeyListener(new KeyPressListener(this));
        MenuInterface menu = new MenuInterface(this);
        menu.setOpaque(false);
        setGlassPane(menu);
        board.setFocusable(true);
        pack();
        setLocationRelativeTo(null);

        MainController.addGameAction(this);
    }

    @Override
    public void doAction() {
        repaint();
    }

    public void closeMenuInterface() {
        getGlassPane().setVisible(false);
    }

    public void openMenuInterface() {
        getGlassPane().setVisible(true);
    }

    public boolean isMenuInterfaceOpen() {
        return getGlassPane().isVisible();
    }

    public Session getSession() {
        return session;
    }
}
