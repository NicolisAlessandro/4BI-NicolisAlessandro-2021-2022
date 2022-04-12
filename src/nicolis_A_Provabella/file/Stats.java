package nicolis_A_Provabella.file;

public class Stats {
    //public static final int MAX_LEVEL = 10;
    private static int MAX_LEVEL = 20;
    private int strength, dexterity, intelligence, stamina, maxHealth, currentHealth, movementSpeed, level;
    private int baseStrength, baseDexterity, baseIntelligence, baseStamina, baseMaxHealth;
    public Stats(int strength, int dexterity, int intelligence, int stamina, int maxHealth, int movementSpeed){
        level = 1;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.stamina = stamina;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.movementSpeed = movementSpeed;

        baseStrength = this.strength;
        baseDexterity = this.dexterity;
        baseIntelligence = this.intelligence;
        baseStamina = this.stamina;
        this.baseMaxHealth = this.maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStamina() {
        return stamina;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void doDamage(int damage) {
        if (damage<currentHealth){
            currentHealth -= damage;
        } else {
            currentHealth = 0;
        }
    }

    public boolean isDead() {
        return currentHealth == 0;
    }

    public void resetHealth() {
        currentHealth = maxHealth;
    }

    public void increaseLevel(int levels) {
        if (level >= MAX_LEVEL){
            return;
        } else if (level + levels > MAX_LEVEL){
            levels = MAX_LEVEL - level;
        }
        strength = increaseLevel(strength, levels*baseStrength);
        dexterity = increaseLevel(dexterity, levels*baseDexterity);
        intelligence = increaseLevel(intelligence, levels*baseIntelligence);
        stamina = increaseLevel(stamina, levels*baseStamina);
        maxHealth = increaseLevel(maxHealth, levels*baseMaxHealth);
        currentHealth = maxHealth;
    }

    public int getLevel(){
        int level = 0;
        level += Math.max(strength, Math.max(dexterity, intelligence));
        level += stamina;
        return level;
    }

    private int increaseLevel(int stat, int levels) {
        stat += levels;
        return stat;
    }

    @Override
    public String toString() {
        return "Stats [strength=" + strength + ", dexterity=" + dexterity
                + ", intelligence=" + intelligence + ", stamina=" + stamina
                + ", maxHealth=" + maxHealth + ", currentHealth="
                + currentHealth + "]";
    }

    public void heal(int healAmount) {
        if (healAmount < 0){
            throw new IllegalArgumentException("healing amount must be positive");
        }
        if (currentHealth + healAmount > maxHealth){
            currentHealth = maxHealth;
        } else {
            currentHealth += healAmount;
        }
    }
}
