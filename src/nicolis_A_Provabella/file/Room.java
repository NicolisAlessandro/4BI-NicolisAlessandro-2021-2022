package nicolis_A_Provabella.file;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Room implements Comparable<Room> {
    private static final int ROOM_WIDTH = Config.SIZE_ROOM_WIDTH;
    private static final int ROOM_HEIGHT = Config.SIZE_ROOM_HEIGHT;
    private static final Size roomSize = new Size(ROOM_WIDTH, ROOM_HEIGHT);
    private Door north;
    private Door east;
    private Door south;
    private Door west;
    private Room previousRoom;
    private int distanceFromStart;
    private Point coordinates;
    private Direction directionOfPreviousRoom;
    private Key key;
    private boolean isLocked = true;
    private final List<Monster> monsters = new ArrayList<>();
    private final Maze maze;
    private final List<Item> droppedItems = new ArrayList<>();
    private final List<RoomObject> roomObjects = new ArrayList<>();
    private boolean isCritical = false;

    protected Room(Maze maze, Point point) {
        this.maze = maze;
        coordinates = new Point(point);
        isLocked = false;
    }

    protected Room(Maze maze, Room previousRoom, Direction directionOfPreviousRoom) {
        this.maze = maze;
        this.previousRoom = previousRoom;
        this.distanceFromStart = previousRoom.getDistance() + 1;
        this.directionOfPreviousRoom = directionOfPreviousRoom;
        setDoor(directionOfPreviousRoom, new SimpleDoor(previousRoom));
        setCoordinates();
    }

    public int getDistance() {
        return distanceFromStart;
    }

    private void setCoordinates() {
        Point prevRoomCoord = previousRoom.getCoordinates();
        Point dirCoord = directionOfPreviousRoom.getOpposite().getCoordinates();
        coordinates = new Point(prevRoomCoord.x + dirCoord.x, prevRoomCoord.y + dirCoord.y);
    }


    public Point getCoordinates() {
        return new Point(coordinates);
    }

    public void setDoor(Direction direction, Door door) {
        switch (direction) {
            case NORTH:
                north = door;
                break;
            case EAST:
                east = door;
                break;
            case SOUTH:
                south = door;
                break;
            case WEST:
                west = door;
                break;
            default:
                throw new IllegalArgumentException("unexpected direction" + direction);
        }
    }

    public Door getDoorByDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                return north;
            case EAST:
                return east;
            case SOUTH:
                return south;
            case WEST:
                return west;
            default:
                throw new IllegalArgumentException("unexpected direction " + direction);
        }
    }

    public boolean hasDoorAtDirection(Direction direction) {
        return getDoorByDirection(direction) != null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Room room)) {
            return false;
        }
        return getCoordinates().equals(room.getCoordinates()) && getDistance() == room.getDistance();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getCoordinates().x;
        result = 31 * result + getCoordinates().y;
        result = 31 * result + getDistance();
        return result;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void removeKey() {
        key = null;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isLockedWithKey() {
        if (!isLocked()) {
            return false;
        }
        return previousRoom.getDoorByDirection(directionOfPreviousRoom.getOpposite()) instanceof KeyDoor;
    }

    public boolean isPreviousRoomLocked() {
        if (getDistance() == 0) {
            return true;
        }
        return getDoorByDirection(getDirectionOfPreviousRoom()).getRoom().isLocked();
    }

    public Room getPreviousRoom() {
        if (getDistance() == 0) {
            throw new IllegalStateException("cannot call this function on starting room");
        }
        return getDoorByDirection(getDirectionOfPreviousRoom()).getRoom();
    }

    /**
     * @return Key that is locking the room
     */
    public Key getLockingKey() {
        if (!isLockedWithKey()) {
            throw new IllegalStateException("method can be only called on room locked with keydoor. Check with isLockedWithKey()");
        }
        KeyDoor keyDoor = (KeyDoor) previousRoom.getDoorByDirection(directionOfPreviousRoom.getOpposite());
        return keyDoor.getKey();
    }


    public Direction getDirectionOfPreviousRoom() {
        return directionOfPreviousRoom;
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    @Override
    public String toString() {
        return "Room [north=" + hasDoorAtDirection(Direction.NORTH) + ", east=" + hasDoorAtDirection(Direction.EAST) +
                ", south=" + hasDoorAtDirection(Direction.SOUTH) + ", west=" + hasDoorAtDirection(Direction.WEST) +
                ", coordinates=[" + coordinates.x + "," + coordinates.y + "], key=" + key + ", isLocked=" + isLocked +
                ", monsterCount=" + monsters.size() + ", droppedItemCount=" + droppedItems.size() + "]";
    }

    public Maze getMaze() {
        return maze;
    }

    public java.util.List<Item> getDroppedItems() {
        return droppedItems;
    }

    public void addDroppedItem(Item item) {
        droppedItems.add(item);
    }

    public void removeDroppedItem(Item item) {
        if (droppedItems.contains(item)) {
            droppedItems.remove(item);
        }
    }

    public boolean hasDroppedItems() {
        return droppedItems.size() > 0;
    }


    @Override
    public int compareTo(Room o) {
        return distanceFromStart - o.distanceFromStart;
    }

    public int numberOfDoors() {
        int counter = 0;
        for (Direction dir : Direction.values()) {
            if (getDoorByDirection(dir) != null) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }

    void addRoomObject(RoomObject roomObject) {
        roomObjects.add(roomObject);
    }

    public java.util.List<RoomObject> getRoomObjects() {
        return roomObjects;
    }

    public boolean collidesWithRoomObject(Point point, Size size) {
        for (RoomObject ro : roomObjects) {
            if (!ro.isPassable()) {
                if (Util.areasOverlap(ro.getPosition().getPoint(), ro.getImageSize(), point, size, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Size getRoomSize() {
        return roomSize;
    }


}
