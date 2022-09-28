package nicolis_A_Provabella.file;

public class SimpleDoor implements Door {
    private final Room destinationRoom;

    public SimpleDoor(Room destinationRoom) {
        this.destinationRoom = destinationRoom;
    }

    @Override
    public Room getRoom() {
        return destinationRoom;
    }

    @Override
    public boolean unlock(Player player) {
        destinationRoom.setLocked(false);
        return destinationRoom.isLocked();
    }

    @Override
    public boolean isLocked() {
        return destinationRoom.isLocked();
    }
}
