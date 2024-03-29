package nicolis_A_Provabella.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootEntry {
    private final int minQuantity;
    private final int maxQuantity;
    private Item item;
    private final double weight;
    private boolean stackable;

    private LootEntry(int minQuantity, int maxQuantity, double weight) {
        if (minQuantity > maxQuantity) {
            throw new IllegalArgumentException("minimum quantity cant be greater than maximum");
        }
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
        this.weight = weight;
    }

    public LootEntry(int minQuantity, int maxQuantity, Stackable item, double weight) {
        this(minQuantity, maxQuantity, weight);
        stackable = true;
        this.item = item;
    }

    public LootEntry(int minQuantity, int maxQuantity, NonStackable item, double weight) {
        this(minQuantity, maxQuantity, weight);
        stackable = false;
        this.item = item;
    }

    public double getWeight() {
        return weight;
    }

    public Item[] getLoot() {
        int rndQuantity;
        if (minQuantity == maxQuantity) {
            rndQuantity = minQuantity;
        } else {
            Random rnd = new Random();
            rndQuantity = minQuantity + rnd.nextInt(maxQuantity - minQuantity);
        }
        List<Item> items = new ArrayList<>();
        final String itemName = item.getName();
        if (stackable) {
            Stackable item = (Stackable) ItemFactory.getItemForName(itemName);
            item.addQuantity(rndQuantity);
            items.add(item);
        } else {
            for (int i = 0; i < rndQuantity; i++) {
                items.add(ItemFactory.getItemForName(itemName));
            }
        }
        return items.toArray(new Item[0]);
    }
}
