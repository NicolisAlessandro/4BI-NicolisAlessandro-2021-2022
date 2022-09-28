package nicolis_A_Provabella.file;


public abstract class Chest extends RoomObject {
    private static final boolean IS_PASSABLE = false;
    private final LootTable lootTable;
    private boolean opened = false;

    public Chest(String name, String imageSrc, Size imageSize, LootTable lootTable) {
        super(name, imageSrc, imageSize, IS_PASSABLE);
        this.lootTable = lootTable;
    }

    @Override
    public Option[] getOptions(Player player) {
        return new Option[]{Option.OPEN};
    }

    @Override
    public void doAction(Option option, Player player) {
        if (option == Option.OPEN) {
            open(player);
        } else {
            open(player);
        }

    }

    private void open(Player player) {
        if (player.isCloseToInteractable(this)) {
            if (!opened) {
                opened = true;
                for (Item item : lootTable.getRandomDrops()) {
                    item.dropAt(player.getPosition());
                    item.tryPickUp(player);
                }
            }
        }
    }

    public String getName() {
        if (opened) {
            return super.getName() + " (empty)";
        }
        return super.getName();

    }

}
