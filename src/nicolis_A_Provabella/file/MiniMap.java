package nicolis_A_Provabella.file;

import javax.swing.*;
import java.awt.*;

public class MiniMap extends JPanel {
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    private static final long serialVersionUID = -3846521993094337688L;
    private final Dimension IMAGE_SIZE = new Dimension(100, 100);
    private final Session session;
    private double scale;
    private Dimension totalSize;
    private Point offset;    //to put minimap in middle of its designated area while compensating for keeping ratio
    private int roomWidth;
    private int roomHeight;
    private int paddingInternal;
    private int paddingExternal;
    private int doorSize;
    private int imageSize;

    public MiniMap(Session session) {
        this.session = session;
        calculateTotalSize();
        calculateScale();
        calculateSizesToScale();
        calculateTotalSizeToScale();
        calculateOffset();
    }

    private void calculateOffset() {
        offset = new Point((WIDTH - totalSize.width) / 2, (HEIGHT - totalSize.height) / 2);
    }

    private void calculateSizesToScale() {
        roomWidth = (int) (scale * Config.SIZE_ROOM_WIDTH);
        roomHeight = (int) (scale * Config.SIZE_ROOM_HEIGHT);
        paddingInternal = (int) (scale * Config.PADDING_MINIMAP_ROOM_INTERNAL);
        paddingExternal = (int) (scale * Config.PADDING_MINIMAP_ROOM_EXTERNAL);
        doorSize = (int) (scale * Config.SIZE_DOOR_MINIMAP);
        imageSize = (int) (scale * IMAGE_SIZE.width);
    }

    private void calculateScale() {
        double scaleW = (double) WIDTH / (double) totalSize.width;
        double scaleH = (double) HEIGHT / (double) totalSize.height;
        if (scaleW > scaleH) {
            scale = scaleH;
        } else {
            scale = scaleW;
        }
    }

    private void calculateTotalSize() {
        totalSize = new Dimension(2 * Config.PADDING_MINIMAP_ROOM_EXTERNAL + Config.ROOM_COUNT_HORIZONTAL * Config.SIZE_ROOM_WIDTH + (Config.ROOM_COUNT_HORIZONTAL - 1) * Config.PADDING_MINIMAP_ROOM_INTERNAL,
                2 * Config.PADDING_MINIMAP_ROOM_EXTERNAL + Config.ROOM_COUNT_VERTICAL * Config.SIZE_ROOM_HEIGHT + (Config.ROOM_COUNT_VERTICAL - 1) * Config.PADDING_MINIMAP_ROOM_INTERNAL);
    }

    private void calculateTotalSizeToScale() {
        totalSize = new Dimension(2 * paddingExternal + Config.ROOM_COUNT_HORIZONTAL * roomWidth + (Config.ROOM_COUNT_HORIZONTAL - 1) * paddingInternal,
                2 * paddingExternal + Config.ROOM_COUNT_VERTICAL * roomHeight + (Config.ROOM_COUNT_VERTICAL - 1) * paddingInternal);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Config.COLOR_BACKGROUND);
        drawRooms(g);
        drawDoors(g);
        drawGateStones(g);
        drawPlayer(g);
    }

    private void drawPlayer(Graphics g) {
        Player player = session.getMaze().getPlayer();
        Image image = player.getImage();
        Point p = player.getPosition().getRoom().getCoordinates();
        Point corner = getRoomCorner(p.x, p.y);
        Point temp = new Point(corner.x + (roomWidth - imageSize) / 2,
                corner.y + (roomWidth - imageSize) / 2);
        g.drawImage(image, temp.x, temp.y, imageSize, imageSize, null);
    }

    private void drawRooms(Graphics g) {
        for (int i = 0; i < session.getMaze().getWidth(); i++) {
            for (int j = 0; j < session.getMaze().getHeight(); j++) {
                Point corner = getRoomCorner(i, j);
                Room room = session.getMaze().getRooms().get(i).get(j);
                if (room != null) {
                    if (!room.isLocked()) {
                        g.setColor(Config.COLOR_ROOM_UNLOCKED);
                        g.fillRect(corner.x, corner.y, roomWidth, roomHeight);
                    } else if (!room.isPreviousRoomLocked()) {
                        g.setColor(Config.COLOR_ROOM_LOCKED);
                        g.fillRect(corner.x, corner.y, roomWidth, roomHeight);
                    }
                }
            }
        }
    }

    private void drawDoors(Graphics g) {
        g.setColor(Config.COLOR_DOOR);
        for (int i = 0; i < session.getMaze().getWidth(); i++) {
            for (int j = 0; j < session.getMaze().getHeight(); j++) {
                Room room = session.getMaze().getRooms().get(i).get(j);
                if (room != null) {
                    if (!room.isPreviousRoomLocked()) {
                        Direction direction = room.getDirectionOfPreviousRoom();
                        Point corner = getRoomCorner(i, j);
                        Point temp = new Point(corner.x + roomWidth / 2, corner.y + roomHeight / 2);
                        Point doorCorner;
                        switch (direction) {
                            case NORTH:
                                doorCorner = new Point(temp.x - doorSize / 2, temp.y - roomHeight / 2 - paddingInternal);
                                break;
                            case EAST:
                                doorCorner = new Point(temp.x + roomWidth / 2, temp.y - doorSize / 2);
                                break;
                            case SOUTH:
                                doorCorner = new Point(temp.x - doorSize / 2, temp.y + roomHeight / 2);
                                break;
                            case WEST:
                                doorCorner = new Point(temp.x - roomWidth / 2 - paddingInternal, temp.y - doorSize / 2);
                                break;
                            default:
                                throw new IllegalArgumentException("found no direction " + direction);
                        }
                        Point d = direction.getCoordinates();
                        Dimension size = new Dimension(Math.abs(d.x * (paddingInternal + 1) + d.y * doorSize),
                                Math.abs(d.y * (paddingInternal + 1) + d.x * doorSize));
                        g.fillRect(doorCorner.x, doorCorner.y, size.width, size.height);
                    }
                }
            }
        }
    }

    private void drawGateStones(Graphics g) {
        drawGroupGateStone(g);
        drawPersonalGateStone(g);
    }

    private void drawGroupGateStone(Graphics g) {
        Player player = session.getMaze().getPlayer();
        if (player.getGroupGateStone().exists()) {
            Image image = player.getGroupGateStone().getImage();
            Point p = player.getGroupGateStone().getPosition().getRoom().getCoordinates();
            Point corner = getRoomCorner(p.x, p.y);
            Point temp = new Point(corner.x + (roomWidth - imageSize) / 2,
                    corner.y + (roomHeight - imageSize) / 2);
            g.drawImage(image, temp.x, temp.y, imageSize, imageSize, null);

        }
    }

    private void drawPersonalGateStone(Graphics g) {
        Player player = session.getMaze().getPlayer();
        if (player.getPersonalGateStone().exists()) {
            Image image = player.getPersonalGateStone().getImage();
            Point p = player.getPersonalGateStone().getPosition().getRoom().getCoordinates();
            Point corner = getRoomCorner(p.x, p.y);
            Point temp = new Point(corner.x + (roomWidth - imageSize) / 2,
                    corner.y + (roomHeight - imageSize) / 2);
            g.drawImage(image, temp.x, temp.y, imageSize, imageSize, null);

        }
    }

    private Point getRoomCorner(int i, int j) {
        return new Point(paddingExternal + i * (paddingInternal + roomWidth) + offset.x,
                paddingExternal + j * (paddingInternal + roomHeight) + offset.y);
    }
}