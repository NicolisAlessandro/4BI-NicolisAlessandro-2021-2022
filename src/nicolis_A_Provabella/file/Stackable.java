package nicolis_A_Provabella.file;

public abstract class Stackable extends Item {
    private int quantity = 0;

    public Stackable(String name, String imageSrc, Size imagesize, int quantity, String description) {
        super(name, imageSrc, imagesize, description);
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalAccessError("cant add negative quantity");
        }
        this.quantity = this.quantity + quantity;
    }

    public void removeQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalAccessError("cant remove negative quantity");
        }
        if (this.quantity < quantity) {
            throw new IllegalAccessError("cant remove more than currently have");
        }
        this.quantity = this.quantity - quantity;
    }

    public void pickUp(Player player) {
        if (player.addItem(this)) {
            removeFromMaze();
        }
    }

    private void removeFromMaze() {
        getPosition().getRoom().removeDroppedItem(this);
        resetPosition();
    }
}
