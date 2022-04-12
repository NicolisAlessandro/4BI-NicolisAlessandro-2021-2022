package nicolis_A_Provabella.file;

import main.game.maze.interactable.creature.player.Player;
import main.game.maze.room.Room;

public class SimpleDoor implements Door{
    private Room destinationRoom;
    public SimpleDoor(Room destinationRoom){
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
