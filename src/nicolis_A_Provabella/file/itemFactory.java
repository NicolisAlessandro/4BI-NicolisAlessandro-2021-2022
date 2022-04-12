package nicolis_A_Provabella.file;

import main.game.maze.interactable.item.food.Cake;
import main.game.maze.interactable.item.food.Fish;
import main.game.maze.interactable.item.weapon.Bow;
import main.game.maze.interactable.item.weapon.Staff;
import main.game.maze.interactable.item.weapon.Sword;

public class ItemFactory {
    private ItemFactory(){
        throw new IllegalAccessError("must not be initiated");
    }

    public static Item getItemForName(String name){
        return switch (name) {
            case Cake.NAME -> new Cake();
            case Fish.NAME -> new Fish();
            case Bow.NAME -> new Bow();
            case Staff.NAME -> new Staff();
            case Sword.NAME -> new Sword();
            case Coins.NAME -> new Coins();
            default -> throw new IllegalArgumentException("undefined item name: " + name);
        };
    }
}
