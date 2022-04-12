package nicolis_A_Provabella.file;

import main.game.maze.interactable.Interactable;
import main.game.maze.interactable.Option;
import main.game.maze.interactable.creature.Creature;
import main.game.maze.interactable.creature.player.Player;
import main.game.maze.mechanics.lootTable.LootTable;
import main.game.maze.room.Room;
import main.game.util.Size;
import main.game.util.Util;

public abstract class Monster extends Creature implements Interactable{
    private MonsterController controller;
    static final int MOVEMENT_SPEED = 1;
    LootTable lootTable;

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

    public void die(){
        controller.die();
    }

    @Override
    public Option[] getOptions(Player player){
        return new Option[]{Option.ATTACK};
    }

    @Override
    public void doAction(Option option, Player player) {
        switch (option){
            case ATTACK: player.attackCreature(this); break;
            default: player.attackCreature(this); break;
        }
    }
}
