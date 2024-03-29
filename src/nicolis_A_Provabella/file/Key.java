package nicolis_A_Provabella.file;

import java.util.ArrayList;
import java.util.List;

public final class Key extends NonInventoryItem {
    public final static List<Key> KEYS;
    private static final int SIZE_WIDTH = 20;
    private static final int SIZE_HEIGHT = 20;
    private static final String DESCRIPTION_SHORT = "";
    private final static Size SIZE = new Size(SIZE_WIDTH, SIZE_HEIGHT);

    static {
        List<Key> temp = new ArrayList<>();
        for (Color c : Color.values()) {
            for (Shape s : Shape.values()) {
                if (s == Shape.SHIELD && c == Color.GOLD) {
                    continue;
                }
                temp.add(new Key(c, s));
            }
        }
        KEYS = ImmutableList.copyOf(temp);
    }

    private final Shape shape;
    private final Color color;

    private Key(Color color, Shape shape) {
        super(String.format("%s %s", color, shape).toLowerCase(), String.format("%s%s_%s_key.png", Config.IMAGES_FOLDER_KEYS, color, shape), SIZE, String.format("A %s %s key.", color, shape).toLowerCase());
        this.color = color;
        this.shape = shape;
    }

    public static void resetAllPositions() {
        for (Key key : KEYS) {
            try {
                key.resetPosition();
            } catch (NullPointerException npe) {
                //Ignore, means that key wasn't placed in any of the rooms
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Key key)) {
            return false;
        }
        return this.shape == key.shape && this.color == key.color;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + shape.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s %s", color, shape).toLowerCase();
    }

    @Override
    public Option[] getOptions(Player player) {
        return new Option[]{Option.PICKUP};
    }

    @Override
    public void resetPosition() {
        getPosition().getRoom().setKey(null);
        setPosition(null);
    }

    @Override
    protected void pickUp(Player player) {
        player.addKey(this);
        getPosition().getRoom().removeKey();
        resetPosition();
    }

    @Override
    public void doAction(Option option, Player player) {
        if (option == Option.PICKUP) {
            tryPickUp(player);
        } else {
            tryPickUp(player);
        }
    }

    @Override
    public String getShortDescription() {
        return DESCRIPTION_SHORT;
    }

    public enum Color {
        PURPLE, YELLOW, GOLD, BLUE, SILVER, GREEN, CRIMSON, ORANGE
    }

    public enum Shape {
        TRIANGLE, PENTAGON, CRESCENT, SHIELD, RECTANGLE, DIAMOND, WEDGE, CORNER
    }
}
