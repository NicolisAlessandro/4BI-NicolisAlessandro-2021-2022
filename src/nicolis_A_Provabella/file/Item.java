package nicolis_A_Provabella.file;

import java.awt.*;

public abstract class Item implements Interactable {
    private Image image;
    private final String name;
    private Position position;
    private final Size imageSize;
    private final String description;

    public Item(String name, String imageSrc, Size imagesize, String description) {
        this.name = name;
        this.imageSize = imagesize;
        this.description = description;
        if (imageSrc != null) {
            this.image = Util.readImage(imageSrc);
        }
    }

    public abstract void resetPosition();

    protected abstract void pickUp(Player player);

    public abstract String getShortDescription();

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (position == null) {
            this.position = null;
        } else {
            this.position = new Position(position);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Size getImageSize() {
        return imageSize;
    }

    public void dropAt(Position position) {
        setPosition(position);
        position.getRoom().addDroppedItem(this);
    }

    public boolean tryPickUp(Player player) {
        if (player.isCloseToInteractable(this)) {
            pickUp(player);
            return true;
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}
