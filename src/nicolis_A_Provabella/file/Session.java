package nicolis_A_Provabella.file;

public class Session {
    private Maze maze;

    public Session(){
        maze = new Maze();
        Player player = new Player("bob");
        maze.setPlayer(player);
    }

    public void reset(){
        maze = new Maze();
        Player player = new Player("bob");
        maze.setPlayer(player);
    }

    public Maze getMaze(){
        Maze maze = this.maze;
        return maze;
    }
}
