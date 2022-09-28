package nicolis_A_Provabella.file;

public interface Door {
    Room getRoom();

    boolean unlock(Player player);

    boolean isLocked();
}
