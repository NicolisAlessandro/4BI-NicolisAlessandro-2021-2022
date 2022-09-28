package nicolis_A_Provabella.file;

public class ItemStats {
    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private final int stamina;

    public ItemStats(int strength, int dexterity, int intelligence, int stamina) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStamina() {
        return stamina;
    }

}
