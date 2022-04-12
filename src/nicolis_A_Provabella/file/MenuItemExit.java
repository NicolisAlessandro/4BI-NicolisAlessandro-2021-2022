package nicolis_A_Provabella.file;

import main.game.ui.GameWindow;

public class MenuItemContinue implements MenuItem {
    private static final String TEXT = "Continue";

    @Override
    public String getText() {
        return TEXT;
    }

    @Override
    public void click(GameWindow gameWindow) {
        gameWindow.closeMenuInterface();
    }
}