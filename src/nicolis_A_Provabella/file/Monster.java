package nicolis_A_Provabella.file;

public abstract class Monster extends Creature implements Interactable {
    static final int MOVEMENT_SPEED = 1;
    LootTable lootTable;
    private final MonsterController controller;

    public Monster(String name, Size imageSize) {
        super(name, imageSize);
        controller = new MonsterController(this);
    }

    public void actIdle() {
        controller.actIdle();
    }

    public void target(Creature creature) {
        controller.target(creature);
    }

    public void setStartingPosition(Room room) {
        getPosition().setPoint(Util.randomPointInRoom(getImageSize(), room));
        getPosition().setRoom(room);
    }

    public void die() {
        controller.die();
    }

    @Override
    public Option[] getOptions(Player player) {
        return new Option[]{Option.ATTACK};
    }

    @Override
    public void doAction(Option option, Player player) {
        if (option == Option.ATTACK) {
            player.attackCreature(this);
        } else {
            player.attackCreature(this);
        }
    }
}
