package nicolis_A_Provabella.file;


public class MenuItemReset implements MenuItem {
    private static final String TEXT = "Reset";

    @Override
    public String getText() {
        return TEXT;
    }

    @Override
    public void click(GameWindow gameWindow) {
        gameWindow.getSession().reset();
        gameWindow.closeMenuInterface();
    }
}
