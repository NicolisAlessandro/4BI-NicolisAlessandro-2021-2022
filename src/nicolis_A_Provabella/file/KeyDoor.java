package nicolis_A_Provabella.file;

public class KeyDoor implements Door {
    private final Room destinationRoom;
    private final Key key;

    public KeyDoor(Room destinationRoom, Key key) {
        this.destinationRoom = destinationRoom;
        this.key = key;
    }

    @Override
    public Room getRoom() {
        return destinationRoom;
    }

    @Override
    public boolean unlock(Player player) {
        if (player.getKeys().contains(key)) {
            player.removeKey(key);
            destinationRoom.setLocked(false);
        } else {
            System.out.println(key.getPosition().getRoom());
        }
        return destinationRoom.isLocked();
    }

    @Override
    public boolean isLocked() {
        return destinationRoom.isLocked();
    }

    public Key getKey() {
        return key;
    }


}
