package nicolis_A_Provabella.file;

import main.game.maze.interactable.item.food.Food;
import main.game.maze.interactable.item.weapon.NoWeapon;
import main.game.maze.interactable.item.weapon.Weapon;

import java.awt.*;
import java.util.List;

public class PlayerController {
    private Player player;
    public PlayerController(Player player){
        this.player = player;
    }

    void pickUpItems(){
        pickUpKeys();
        pickUpGroupGateStone();
        pickUpDroppedItems();
    }

    private void pickUpDroppedItems() {
        if (player.getPosition().getRoom().hasDroppedItems()){
            for (Item item: player.getPosition().getRoom().getDroppedItems()){
                if (item.tryPickUp(player)){
                    return;
                }
            }
        }
    }

    private void pickUpGroupGateStone() {
        if (player.getGroupGateStone().exists()){
            if (player.getPosition().getRoom() == player.getGroupGateStone().getPosition().getRoom()){
                if (player.isCloseToInteractable(player.getGroupGateStone())){
                    player.getGroupGateStone().resetPosition();
                }
            }
        }
    }

    void pickUpKeys() {
        Key key = player.getPosition().getRoom().getKey();
        if (key != null){
            key.tryPickUp(player);
        }
    }

    void respawn() {
        if (!player.getGroupGateStone().exists()){
            player.getGroupGateStone().dropGateStone();
        }
        player.getStats().resetHealth();
        player.setStartingPosition();
    }

    void teleportToBase() {
        MainController.addGameAction(new GameAction() {
            final long startTeleportTime = System.currentTimeMillis();
            final Position startTeleportPosition= new Position(player.getPosition());
            final long startLastBeingAttackedTime = player.getLastBeingAttackedTime();

            @Override
            public void doAction() {
                if (startTeleportTime < System.currentTimeMillis() - Config.DELAY_TELEPORT_TO_BASE){
                    player.setStartingPosition();
                    MainController.disposeAction(this);
                    return;
                }
                if (!startTeleportPosition.equals(player.getPosition())){
                    MainController.disposeAction(this);
                    return;
                }
                if (startLastBeingAttackedTime != player.getLastBeingAttackedTime()){
                    MainController.disposeAction(this);
                    return;
                }

            }
        });
    }

    synchronized boolean addItem(Item item) {
        if (item instanceof NonStackable){
            if (player.hasItemSpace()){
                player.getItems().add(item);
                return true;
            }
        } else if (item instanceof Stackable) {
            if (!player.ownsItem(item)){
                List<Item> playerItems = player.getItems();
                for (Item playerItem: playerItems){
                    if (playerItem.getClass().equals(item.getClass())){
                        Stackable newItem = (Stackable) item;
                        Stackable oldItem = (Stackable) playerItem;
                        oldItem.addQuantity(newItem.getQuantity());
                        return true;
                    }
                }
                if (player.hasItemSpace()){
                    player.getItems().add(item);
                    return true;
                }
            }
        } else {
            throw new IllegalStateException("player cant pick this up");
        }
        return false;
    }

    void drop(Item item) {
        if (!player.hasEquipped(item)){
            if (player.getItems().contains(item)){
                player.getItems().remove(item);
                item.setPosition(player.getPosition());
                player.getPosition().getRoom().addDroppedItem(item);
            }
        } else {
            System.out.println("PlayerController.drop(): cant drop, equipped item");
        }
    }

    void equip(Item item) {
        if (item instanceof Weapon){
            System.out.println("PlayerController.equip(): " + item.getName());
            player.setWeapon((Weapon) item);
        } else {
            throw new IllegalArgumentException("cant equip item " + item.getName());
        }
    }

    void unequip(Item item) {
        if (item instanceof Weapon){
            if (player.getWeapon() == item){
                System.out.println("PlayerController.unequip(): " + item.getName());
                player.setWeapon(new NoWeapon());
            }
        }
    }

    void eat(Food food) {
        if (player.ownsItem(food)){
            player.getStats().heal(food.getHealAmount());
            player.getItems().remove(food);
        }
    }

    void interactWithDoor() {
        Direction dir;
        if ((dir = getClosestDoorDirection()) != null){
            move(dir);
        }
    }

    private Direction getClosestDoorDirection(){
        Point p = player.getPosition().getPoint();
        Point d = new Point((Config.SIZE_ROOM_WIDTH - Config.SIZE_DOOR_ROOM - player.getImageSize().width)/2,
                (Config.SIZE_ROOM_HEIGHT - Config.SIZE_DOOR_ROOM - player.getImageSize().height)/2);
        Point k = new Point((Config.SIZE_ROOM_WIDTH - player.getImageSize().width)/2, (Config.SIZE_ROOM_HEIGHT - player.getImageSize().height)/2);
        for (Direction dir: Direction.values()){
            if (!player.getPosition().getRoom().hasDoorAtDirection(dir)){
                continue;
            }
            Point l = dir.getCoordinates();
            Point s = new Point(d.x*Math.abs(l.y) + (l.x+Math.abs(l.x))*k.x,d.y*Math.abs(l.x) + (l.y+Math.abs(l.y))*k.y);
            Dimension f = new Dimension(Math.abs(l.y)*Config.SIZE_DOOR_ROOM, Math.abs(l.x)*Config.SIZE_DOOR_ROOM);
            if (p.x >= s.x && p.x <= s.x+f.width){
                if (p.y >= s.y && p.y <= s.y + f.height){
                    return dir;
                }
            }
        }
        return null;
    }

    void move(Direction direction) {
        if (player.getPosition().getRoom().getDoorByDirection(direction) == null){
            return;
        } else if (player.getPosition().getRoom().getDoorByDirection(direction).isLocked()){
            player.getPosition().getRoom().getDoorByDirection(direction).unlock(player);
        } else {
            player.getPosition().setRoom(player.getPosition().getRoom().getDoorByDirection(direction).getRoom());
            Dimension area = new Dimension((Config.SIZE_ROOM_WIDTH - player.getImageSize().width) * Math.abs(direction.getCoordinates().x),
                    (Config.SIZE_ROOM_HEIGHT - player.getImageSize().height) * Math.abs(direction.getCoordinates().y));
            Point p = player.getPosition().getPoint();
            player.getPosition().setPoint(Math.abs(area.width - p.x), Math.abs(area.height - p.y));
        }
    }
}