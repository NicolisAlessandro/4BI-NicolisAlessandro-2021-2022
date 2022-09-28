package nicolis_A_Provabella.file;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPressListener extends KeyAdapter implements GameAction {
    private final GameWindow gameWindow;
    private final boolean[] keyPressed = new boolean[256];

    public KeyPressListener(GameWindow gameWindow) {
        MainController.addGameAction(this);
        this.gameWindow = gameWindow;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Player player = gameWindow.getSession().getMaze().getPlayer();
        if (gameWindow.isMenuInterfaceOpen()) {
            if (e.getKeyCode() == Config.KEYBIND_CLOSE_INTERFACE) {
                gameWindow.closeMenuInterface();
                return;
            }
            return;
        }
        if (player.getGameInterface() != null) {
            player.getGameInterface().keyPressed(e);
            return;
        }
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case Config.DEBUG_MOVE_ROOM_UP:
                player.move(Direction.NORTH);
                break;
            case Config.DEBUG_MOVE_ROOM_RIGHT:
                player.move(Direction.EAST);
                break;
            case Config.DEBUG_MOVE_ROOM_DOWN:
                player.move(Direction.SOUTH);
                break;
            case Config.DEBUG_MOVE_ROOM_LEFT:
                player.move(Direction.WEST);
                break;
            case Config.KEYBIND_PICK_UP_ITEM:
                player.pickUpItems();
                break;
            case Config.KEYBIND_DROP_GATESTONE_PERSONAL:
                player.getPersonalGateStone().dropGateStone();
                break;
            case Config.KEYBIND_TELEPORT_TO_GATESTONE_PERSONAL:
                player.getPersonalGateStone().teleportTo();
                break;
            case Config.KEYBIND_DROP_GATESTONE_GROUP:
                player.getGroupGateStone().dropGateStone();
                break;
            case Config.KEYBIND_TELEPORT_TO_GATESTONE_GROUP:
                player.getGroupGateStone().teleportTo();
                break;
            case Config.KEYBIND_INTERACT_WITH_DOOR:
                player.interactWithDoor();
                break;
            case Config.KEYBIND_TELEPORT_TO_BASE:
                player.teleportToBase();
                break;
            case Config.KEYBIND_OPEN_MENU:
                gameWindow.openMenuInterface();
                break;
            case Config.KEYBIND_MOVE_UP:
                keyPressed[Config.KEYBIND_MOVE_UP] = true;
                break;
            case Config.KEYBIND_MOVE_RIGHT:
                keyPressed[Config.KEYBIND_MOVE_RIGHT] = true;
                break;
            case Config.KEYBIND_MOVE_DOWN:
                keyPressed[Config.KEYBIND_MOVE_DOWN] = true;
                break;
            case Config.KEYBIND_MOVE_LEFT:
                keyPressed[Config.KEYBIND_MOVE_LEFT] = true;
                break;
            default:
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case Config.KEYBIND_MOVE_UP:
                keyPressed[Config.KEYBIND_MOVE_UP] = false;
                break;
            case Config.KEYBIND_MOVE_RIGHT:
                keyPressed[Config.KEYBIND_MOVE_RIGHT] = false;
                break;
            case Config.KEYBIND_MOVE_DOWN:
                keyPressed[Config.KEYBIND_MOVE_DOWN] = false;
                break;
            case Config.KEYBIND_MOVE_LEFT:
                keyPressed[Config.KEYBIND_MOVE_LEFT] = false;
                break;
            default:
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    private void processKeys() {
        Player player = gameWindow.getSession().getMaze().getPlayer();
        int dx = 0, dy = 0;
        if (keyPressed[Config.KEYBIND_MOVE_UP]) {
            dy--;
        }
        if (keyPressed[Config.KEYBIND_MOVE_RIGHT]) {
            dx++;
        }
        if (keyPressed[Config.KEYBIND_MOVE_DOWN]) {
            dy++;
        }
        if (keyPressed[Config.KEYBIND_MOVE_LEFT]) {
            dx--;
        }
        player.moveInRoom(dx * player.getMovementSpeed(), dy * player.getMovementSpeed());
    }

    @Override
    public void doAction() {
        processKeys();
    }
}
