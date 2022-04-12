package nicolis_A_Provabella.file;

import java.util.List;

public interface Builder {

    boolean makeKeyDoor(int currentRoomCount, int maxRoomCount);
    Key placeKeyInMaze(List<Room> currentRooms);
    void addMonsters(Maze maze);
    void createCriticalPath();
    void createStartingRoom();
    void buildLabyrinth();
}
