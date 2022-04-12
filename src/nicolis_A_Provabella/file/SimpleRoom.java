package nicolis_A_Provabella.file;

import main.game.maze.Direction;
import main.game.maze.Maze;

public class SimpleRoom extends Room{

    public SimpleRoom(Maze maze, Room previousRoom, Direction directionOfPreviousRoom) {
        super(maze, previousRoom, directionOfPreviousRoom);
    }
}
