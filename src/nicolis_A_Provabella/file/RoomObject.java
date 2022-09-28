package nicolis_A_Provabella.file;

import java.awt.*;

public abstract class RoomObject implements Interactable {
    private final boolean isPassable;
    private final String name;
    private final Size imageSize;
    private final Image image;
    private Position position;

    public RoomObject(String name, String imageSrc, Size imageSize, boolean isPassable) {
        this.name = name;
        this.imageSize = imageSize;
        this.isPassable = isPassable;
        image = Util.readImage(imageSrc);
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

    public boolean isPassable() {
        return isPassable;
    }
}
