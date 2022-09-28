package nicolis_A_Provabella.file;

import java.awt.*;

public final class DummyObject implements Interactable {
    private static final DummyObject dummyObject = new DummyObject();

    private DummyObject() {
    }

    public static DummyObject getInstance() {
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
    public Size getImageSize() {
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
