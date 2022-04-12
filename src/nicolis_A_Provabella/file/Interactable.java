package nicolis_A_Provabella.file;

import java.awt.*;

public interface Interactable {
    Option[] getOptions(Player player);
    Position getPosition();
    String getName();
    Image getImage();
    Size getImageSize();
    void doAction(Option optionFinal, Player player);

}
