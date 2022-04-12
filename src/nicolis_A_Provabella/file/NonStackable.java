package nicolis_A_Provabella.file;

import main.game.maze.interactable.creature.player.Player;
import main.game.util.Size;

public abstract class NonStackable extends Item{

    public NonStackable(String name, String imageSrc, Size imagesize, String description) {
        super(name, imageSrc, imagesize, description);
    }

    public void pickUp(Player player) {
        if (player.addItem(this)){
            getPosition().getRoom().removeDroppedItem(this);
            resetPosition();
        }
    }
}
