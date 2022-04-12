package nicolis_A_Provabella.file;

import java.awt.*;

public class StartingRoom extends Room {

    public StartingRoom(Maze maze, Point point) {
        super(maze, point);
        RoomObject roomObject = new Merchant();
        roomObject.setPosition(new Position(Util.placeInMiddleOf(getRoomSize(), roomObject.getImageSize()), this));
        addRoomObject(roomObject);
    }

}
