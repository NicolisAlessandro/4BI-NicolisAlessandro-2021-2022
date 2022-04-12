package nicolis_A_Provabella.file;

import main.game.maze.interactable.creature.monster.MonsterGameAction;

public class MainController {
    private static GameClock gameClock;
    private static Session session;
    private static GameWindow gameWindow;

    public static void main(String[] args) {
        gameClock = new GameClock();
        session = new Session();
        gameWindow = new GameWindow(session);
        new PlayerGameAction(session);
        new MonsterGameAction(session);
        gameWindow.setVisible(true);
        gameClock.run();
    }

    public static void addGameAction(GameAction gameAction){
        gameClock.addGameAction(gameAction);
    }

    public static void disposeAction(GameAction gameAction) {
        gameClock.removeGameAction(gameAction);
    }
}