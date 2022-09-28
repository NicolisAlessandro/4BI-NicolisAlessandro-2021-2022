package nicolis_A_Provabella.file;

public abstract class NonInventoryItem extends Item {

    public NonInventoryItem(String name, String imageSrc, Size imagesize,
                            String description) {
        super(name, imageSrc, imagesize, description);
    }
}
