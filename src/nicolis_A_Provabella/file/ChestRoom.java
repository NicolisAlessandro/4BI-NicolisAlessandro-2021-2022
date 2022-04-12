package nicolis_A_Provabella.file;

import java.awt.*;

public class ChestRoom extends Room{
    public ChestRoom(Maze maze, Room previousRoom, Direction directionOfPreviousRoom) {
        super(maze, previousRoom, directionOfPreviousRoom);
        RoomObject roomObject = new SmallChest();
        roomObject.setPosition(new Position(new Point(0,0), this));
        addRoomObject(roomObject);
    }
}
