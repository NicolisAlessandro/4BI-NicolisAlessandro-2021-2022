package nicolis_A_Provabella.file;

import main.game.maze.interactable.item.Item;
import main.game.maze.interactable.item.ItemFactory;

public class StockItem {
    private Item item;
    private int price;

    public StockItem(Item item, int price){
        this.item = item;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public Item getItem(){
        return item;
    }

    public Item getNewItem(){
        return ItemFactory.getItemForName(item.getName());
    }

    //TODO: maybe player wants to buy something in bulk? check if item is stackable and make method for returning items with given quantity
}
