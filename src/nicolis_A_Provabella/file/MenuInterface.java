package nicolis_A_Provabella.file;

import main.game.ui.GameWindow;
import main.game.util.Size;
import main.game.util.Util;

public class MenuInterface extends JPanel {
    private static final long serialVersionUID = 655967667289292763L;
    private static final Color COLOR_TRANSPARENT = new Color(0, 0, 0, 100);
    private static final Color COLOR_MENU = new Color(50, 50, 50, 250);
    private static final Color COLOR_MENU_ITEM = new Color(60, 60, 60, 250);
    private static final Size SIZE_MENU_ITEM = new Size(200,40);
    private static final int MARGIN_EDGE = 30;
    private static final int MARGIN_INSIDE = 10;
    private static final Size SIZE_MENU;
    private final static List<MenuItem> MENU_ITEMS;
    private final Point interfaceCorner;
    private final GameWindow gameWindow;
    static {
        List<MenuItem> temp = new ArrayList<MenuItem>();
        temp.add(new MenuItemContinue());
        temp.add(new MenuItemReset());
        temp.add(new MenuItemExit());
        MENU_ITEMS = ImmutableList.copyOf(temp);
        SIZE_MENU = new Size(2 * MARGIN_EDGE + SIZE_MENU_ITEM.width,
                2 * MARGIN_EDGE + (SIZE_MENU_ITEM.height + MARGIN_INSIDE) * MENU_ITEMS.size());
    }

    public MenuInterface(GameWindow gameWindow) {
        addMouseListener(new MouseClickListener());
        interfaceCorner = Util.placeInMiddleOf(GameWindow.SIZE, SIZE_MENU);
        this.gameWindow = gameWindow;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawBackgroundOverlay(g);
        drawInterfaceBackground(g, interfaceCorner);
        drawButtons(g, interfaceCorner);
    }

    private void drawButtons(Graphics g, Point interfaceCorner) {
        for (int i = 0; i < MENU_ITEMS.size(); i++) {
            Point point = getMenuItemCorner(interfaceCorner, i);
            g.setColor(COLOR_MENU_ITEM);
            g.fillRect(point.x, point.y, SIZE_MENU_ITEM.width, SIZE_MENU_ITEM.height);
            Util.drawTextLarge(g, point, SIZE_MENU_ITEM, 20, MENU_ITEMS.get(i).getText());
        }
    }

    private Point getMenuItemCorner(Point interfaceCornerAbsolute, int index) {
        Point point = new Point(interfaceCornerAbsolute.x + MARGIN_EDGE,
                interfaceCornerAbsolute.y + MARGIN_EDGE + index
                        * (SIZE_MENU_ITEM.height + MARGIN_INSIDE));
        return point;
    }

    private void drawBackgroundOverlay(Graphics g) {
        g.setColor(COLOR_TRANSPARENT);
        g.fillRect(0, 0, GameWindow.WIDTH, GameWindow.HEIGHT);
    }

    private void drawInterfaceBackground(Graphics g,
                                         Point interfaceCornerAbsolute) {
        g.setColor(COLOR_MENU);
        g.fillRect(interfaceCornerAbsolute.x, interfaceCornerAbsolute.y, SIZE_MENU.width, SIZE_MENU.height);
    }

    public void mousePressed(MouseEvent me) {
        System.out.println("MenuInterface.mousePressed()");
    }

    private class MouseClickListener extends MouseAdapter {

        public void mousePressed(MouseEvent me){
            for (int i = 0; i < MENU_ITEMS.size(); i++) {
                Point point = getMenuItemCorner(interfaceCorner, i);
                if (Util.clickedOn(me.getPoint(), point, SIZE_MENU_ITEM, 0)){
                    MENU_ITEMS.get(i).click(gameWindow);
                    return;
                }
            }
        }
    }
}
