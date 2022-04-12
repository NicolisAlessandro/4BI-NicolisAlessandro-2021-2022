package nicolis_A_Provabella.file;

import java.awt.Image;

import main.game.maze.interactable.Interactable;
import main.game.maze.interactable.Option;
import main.game.maze.interactable.Position;
import main.game.maze.interactable.creature.player.Player;
import main.game.util.Size;

public final class DummyObject implements Interactable {
    private static DummyObject dummyObject = new DummyObject();
    private DummyObject(){}

    public static DummyObject getInstance(){
        return dummyObject;
    }

    @Override
    public Position getPosition() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public Size getImageSize(){
        return null;
    }

    @Override
    public Option[] getOptions(Player player) {
        return null;
    }

    @Override
    public void doAction(Option optionFinal, Player player) {

    }
}
