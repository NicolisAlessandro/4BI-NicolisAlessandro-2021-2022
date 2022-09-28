package nicolis_A_Provabella.file;

public class PlayerGameAction implements GameAction {
    private final Session session;

    public PlayerGameAction(Session session) {
        this.session = session;
        MainController.addGameAction(this);
    }

    @Override
    public void doAction() {
        if (session.getMaze().getPlayer().isDead()) {
            System.out.println("Am dead");
            session.getMaze().getPlayer().respawn();
        }
    }

}