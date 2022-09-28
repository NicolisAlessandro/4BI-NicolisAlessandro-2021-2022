package nicolis_A_Provabella.file;

import main.game.maze.interactable.item.Coins;
import main.game.maze.interactable.item.food.Cake;
import main.game.maze.interactable.item.food.Fish;
import main.game.maze.interactable.item.food.Food;
import main.game.maze.interactable.item.gatestone.GateStone;
import main.game.maze.interactable.item.gatestone.GroupGateStone;
import main.game.maze.interactable.item.gatestone.PersonalGateStone;
import main.game.maze.interactable.item.weapon.Bow;
import main.game.maze.interactable.item.weapon.Staff;
import main.game.maze.interactable.item.weapon.Sword;
import main.game.maze.interactable.item.weapon.Weapon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player extends Creature {
    private static final int HEALTH = 1000;
    private static final int MOVEMENT_SPEED = 5;
    private static final int SIZE_WIDTH = 20;
    private static final int SIZE_HEIGHT = 20;
    private static final String IMAGE = Config.IMAGES_FOLDER_CREATURES + "player.png";

    private final List<Key> keys = new ArrayList<>();
    private final GateStone personalGateStone = new PersonalGateStone(this);
    private final GateStone groupGateStone = new GroupGateStone(this);
    private Position startingPosition;
    private final List<Item> items = new ArrayList<>();
    private final PlayerController controller;
    private GameInterface gameInterface;

    public Player(String name) {
        super(name, new Size(SIZE_WIDTH, SIZE_HEIGHT));
        controller = new PlayerController(this);
        image = Util.readImage(IMAGE);
        stats = new Stats(5, 5, 5, 10, HEALTH, MOVEMENT_SPEED);
        //increaseLevel(1000);
        weapon = new Sword();
        addItem(weapon);
        addItem(new Bow());
        addItem(new Staff());
        addItem(new Coins(10000));
        addItem(new Cake());
        addItem(new Fish());
    }

    public void addKey(Key key) {
        keys.add(key);
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void removeKey(Key key) {
        keys.remove(key);
    }

    public void move(Direction direction) {
        controller.move(direction);
    }

    public void pickUpKeys() {
        controller.pickUpKeys();
    }

    public GateStone getGroupGateStone() {
        return groupGateStone;
    }

    public GateStone getPersonalGateStone() {
        return personalGateStone;
    }

    public void interactWithDoor() {
        controller.interactWithDoor();
    }

    public void moveTo(Point positionInRoom) {
        getPosition().setPoint(positionInRoom);
    }

    public int getMovementSpeed() {
        return stats.getMovementSpeed();
    }

    public void createStartingPosition(Room startingRoom) {
        startingPosition = new Position();
        startingPosition.setRoom(startingRoom);
        startingPosition.setPoint((Config.SIZE_ROOM_WIDTH - imageSize.width) / 2, (Config.SIZE_ROOM_HEIGHT - imageSize.height) / 2);
    }

    public void setStartingPosition() {
        setPosition(startingPosition);
    }

    public void interactWith(Option option, Interactable interactable) {
        if (interactable instanceof DummyObject) {
            return;
        }
        if (getPosition().getRoom() == interactable.getPosition().getRoom()) {
            interactable.doAction(option, this);
        }
    }

    @Override
    protected long getWeaponDelay() {
        return 0;
    }

    public boolean hasItemSpace() {
        return items.size() < PlayerPanel.INVENTORY_SIZE;
    }

    public boolean addItem(Item item) {
        return controller.addItem(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void equip(Item item) {
        controller.equip(item);
    }

    public void teleportToBase() {
        controller.teleportToBase();
    }

    public void drop(Item item) {
        controller.drop(item);
    }

    public boolean hasEquipped(Item item) {
        if (item instanceof Weapon) {
            return weapon == item;
        }
        return false;
    }

    public void unequip(Item item) {
        controller.unequip(item);
    }

    public boolean isCloseToInteractable(Interactable interactable) {
        if (getPosition().getRoom() != interactable.getPosition().getRoom()) {
            return false;
        }
        Point p = getPosition().getPoint();
        return Util.areasOverlap(p, getImageSize(), interactable.getPosition().getPoint(),
                interactable.getImageSize(), Config.MAX_INTERACTION_DISTANCE);
    }

    public boolean ownsItem(Item item) {
        return items.contains(item);
    }

    public void eat(Food food) {
        controller.eat(food);
    }

    public void pickUpItems() {
        controller.pickUpItems();
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void respawn() {
        controller.respawn();
    }

    public void setInterface(GameInterface gameInterface) {
        this.gameInterface = gameInterface;
    }

    public GameInterface getGameInterface() {
        return gameInterface;
    }

    public Item getItemForClass(Class<?> clazz) {
        for (Item item : items) {
            if (item.getClass().equals(clazz)) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}
