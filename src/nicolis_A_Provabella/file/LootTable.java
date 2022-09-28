package nicolis_A_Provabella.file;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LootTable {
    private List<LootEntry> loot;
    private double totalWeight;

    private LootTable() {
    }

    public Item[] getRandomDrops() {
        Random rnd = new Random();
        Item[] items = new Item[0];
        double rndWeight = rnd.nextDouble() * totalWeight;
        for (LootEntry lootEntry : loot) {
            if (lootEntry.getWeight() >= rndWeight) {
                items = lootEntry.getLoot();
                break;
            }
            rndWeight -= lootEntry.getWeight();
        }
        return items;
    }

    public static class Builder {
        private final List<LootEntry> loot = new ArrayList<>();

        public Builder() {
        }

        public Builder addLootEntry(LootEntry lootEntry) {
            loot.add(lootEntry);
            return this;
        }

        public Builder addLootEntries(LootEntry... lootEntries) {
            for (LootEntry lootEntry : lootEntries) {
                addLootEntry(lootEntry);
            }
            return this;
        }

        public LootTable build() {
            LootTable lootTable = new LootTable();
            lootTable.loot = loot;
            lootTable.totalWeight = calculateTotalWeight();
            return lootTable;
        }

        private double calculateTotalWeight() {
            double weight = 0;
            for (LootEntry lootEntry : loot) {
                weight += lootEntry.getWeight();
            }
            return weight;
        }
    }
}
