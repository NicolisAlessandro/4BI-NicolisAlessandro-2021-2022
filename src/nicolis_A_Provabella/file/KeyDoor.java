package nicolis_A_Provabella.file;

import main.game.maze.interactable.creature.player.Player;
import main.game.maze.interactable.item.Key;
import main.game.maze.room.Room;

public class KeyDoor implements Door {
    private Room destinationRoom;
    private Key key;
    public KeyDoor(Room destinationRoom, Key key){
        this.destinationRoom = destinationRoom;
        this.key = key;
    }

    @Override
    public Room getRoom() {
        return destinationRoom;
    }

    @Override
    public boolean unlock(Player player) {
        if (player.getKeys().contains(key)){
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
