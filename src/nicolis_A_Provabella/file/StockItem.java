package nicolis_A_Provabella.file;

public class StockItem {
    private final Item item;
    private final int price;

    public StockItem(Item item, int price) {
        this.item = item;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Item getItem() {
        return item;
    }

    public Item getNewItem() {
        return ItemFactory.getItemForName(item.getName());
    }

    //TODO: maybe player wants to buy something in bulk? check if item is stackable and make method for returning items with given quantity
}
