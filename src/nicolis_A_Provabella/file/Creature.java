package nicolis_A_Provabella.file;

import java.awt.Image;
import java.awt.Point;

import main.game.Config;
import main.game.maze.interactable.Position;
import main.game.maze.interactable.item.armour.Armour;
import main.game.maze.interactable.item.armour.NoArmour;
import main.game.maze.interactable.item.weapon.NoWeapon;
import main.game.maze.interactable.item.weapon.Weapon;
import main.game.maze.mechanics.damageCalculation.DamageCalculation;
import main.game.maze.mechanics.damageCalculation.SimpleDamageCalculation;
import main.game.maze.mechanics.stats.Stats;
import main.game.util.Size;
import main.game.util.Util;

public class Creature {
    private static final int DELAY_HEALTHBAR_FADEOUT = 5000;	//time after being attacked the healthbar disappears
    private static final DamageCalculation damageCalculation = new SimpleDamageCalculation();
    private String name;
    protected Weapon weapon = new NoWeapon();
    protected Armour armour = new NoArmour();
    protected Image image;
    protected Size imageSize;
    private long lastOpponentAttackedTime;
    protected long lastBeingAttackedTime;
    protected Position position = new Position();

    protected Stats stats;
    public Creature(String name, Size imageSize) {
        this.name = name;
        this.imageSize = imageSize;
    }

    public void setPosition(Position position){
        if (position == null){
            throw new IllegalArgumentException("cannot set player's position to null");
        }
        this.position = new Position(position);
    }

    public Position getPosition() {
        return position;
    }

    public Image getImage(){
        return image;
    }

    public Size getImageSize() {
        return imageSize;
    }

    public void moveInRoom(int dx, int dy){
        if (dx == 0 && dy == 0){
            return; //nothing to move
        }
        Point p = getPosition().getPoint();
        int newPositionX = p.x+dx;
        int newPositionY = p.y+dy;
        if (newPositionX < 0){
            newPositionX = 0;
        }
        if (newPositionY < 0){
            newPositionY = 0;
        }
        if (newPositionX > (Config.SIZE_ROOM_WIDTH-imageSize.width)){
            newPositionX = Config.SIZE_ROOM_WIDTH-imageSize.width;
        }
        if (newPositionY > (Config.SIZE_ROOM_HEIGHT-imageSize.width)){
            newPositionY = Config.SIZE_ROOM_HEIGHT-imageSize.width;
        }
        if (getPosition().getRoom().collidesWithRoomObject(new Point(newPositionX, newPositionY), getImageSize())){
            return;	//cant collide with an object
        }
        getPosition().setPoint(newPositionX, newPositionY);
    }

    public int getMaxHealth() {
        return stats.getMaxHealth();
    }

    public int getCurrentHealth() {
        return stats.getCurrentHealth();
    }

    public void attackCreature(Creature creature) {
        if (this == creature){
            throw new IllegalArgumentException("can't attack itself");
        }
        if (isWithinRange(creature)){
            if (lastOpponentAttackedTime + getWeaponDelay() < System.currentTimeMillis()){
                //damage = getWeaponDamage();
                int damage = damageCalculation.getDamage(this, creature);
                creature.doDamage(damage);
                lastOpponentAttackedTime = System.currentTimeMillis();
            }
        }
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void doDamage(int damage) {
        stats.doDamage(damage);
        lastBeingAttackedTime = System.currentTimeMillis();
    }

    public boolean drawHealthBar(){
        return lastBeingAttackedTime + DELAY_HEALTHBAR_FADEOUT > System.currentTimeMillis();
    }

    public boolean isDead() {
        return stats.isDead();
    }

    public boolean isWithinRange(Creature creature) {
        if (getPosition().getRoom() != creature.getPosition().getRoom()){
            return false;
        }
        Point p1 = getPosition().getPoint();
        Point p2 = creature.getPosition().getPoint();
        Size dim1 = getImageSize();
        Size dim2 = creature.getImageSize();
        return Util.areasOverlap(p1, dim1, p2, dim2, weapon.getWeaponRange());
    }

    protected long getWeaponDelay() {
        return weapon.getWeaponDelay();
    }

    public String getName(){
        return String.format("%s (level:%d)", name, stats.getLevel());
    }

    public Armour getArmour() {
        return armour;
    }

    public Stats getStats() {
        return stats;
    }

    public void increaseLevel(int levels){
        stats.increaseLevel(levels);
    }

    public long getLastBeingAttackedTime(){
        return lastBeingAttackedTime;
    }
}
