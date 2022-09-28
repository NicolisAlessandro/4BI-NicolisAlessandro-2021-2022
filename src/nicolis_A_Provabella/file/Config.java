package nicolis_A_Provabella.file;

import java.awt.*;
import java.awt.event.KeyEvent;

public final class Config {
    public static final int SCREEN_REFRESH_DELAY = 50;
    public static final int ROOM_COUNT_HORIZONTAL = 8;
    public static final int ROOM_COUNT_VERTICAL = 8;

    public static final int SIZE_ROOM_WIDTH = 200;
    public static final int SIZE_ROOM_HEIGHT = 200;
    public static final int SIZE_HEALTHBAR_WIDTH = 20;
    public static final int SIZE_HEALTHBAR_HEIGHT = 5;
    public static final int SIZE_DOOR_ROOM = 40;
    public static final int SIZE_DOOR_MINIMAP = 80;    //relative to room width/height
    public static final int SIZE_THICKNESS_WALL = 7; // width/height of wall and corner image
    public static final int SIZE_THICKNESS_DOOR = 8;

    //Paddings
    public static final int PADDING_BOARD_ROOM_EXTERNAL = 100;
    public static final int PADDING_BOARD_ROOM_INTERNAL = 20;
    public static final int PADDING_MINIMAP_ROOM_INTERNAL = 60;    //relative to room width/height
    public static final int PADDING_MINIMAP_ROOM_EXTERNAL = 100;    //relative to room width/height
    public static final int PADDING_HEALTHBAR = 5;
    public static final int PADDING_MOUSE_CLICK = 5;

    //KeyBindings
    public static final int KEYBIND_MOVE_UP = KeyEvent.VK_W;
    public static final int KEYBIND_MOVE_DOWN = KeyEvent.VK_S;
    public static final int KEYBIND_MOVE_LEFT = KeyEvent.VK_A;
    public static final int KEYBIND_MOVE_RIGHT = KeyEvent.VK_D;
    public static final int KEYBIND_DROP_GATESTONE_PERSONAL = KeyEvent.VK_Q;
    public static final int KEYBIND_TELEPORT_TO_GATESTONE_PERSONAL = KeyEvent.VK_E;
    public static final int KEYBIND_DROP_GATESTONE_GROUP = KeyEvent.VK_1;
    public static final int KEYBIND_TELEPORT_TO_GATESTONE_GROUP = KeyEvent.VK_2;
    public static final int KEYBIND_PICK_UP_ITEM = KeyEvent.VK_SPACE;
    public static final int KEYBIND_INTERACT_WITH_DOOR = KeyEvent.VK_SHIFT;
    public static final int KEYBIND_TELEPORT_TO_BASE = KeyEvent.VK_H;
    public static final int KEYBIND_CLOSE_INTERFACE = KeyEvent.VK_ESCAPE;
    public static final int KEYBIND_OPEN_MENU = KeyEvent.VK_ESCAPE;

    public static final int DEBUG_MOVE_ROOM_UP = KeyEvent.VK_UP;
    public static final int DEBUG_MOVE_ROOM_DOWN = KeyEvent.VK_DOWN;
    public static final int DEBUG_MOVE_ROOM_LEFT = KeyEvent.VK_LEFT;
    public static final int DEBUG_MOVE_ROOM_RIGHT = KeyEvent.VK_RIGHT;

    //Colours
    public static final Color COLOR_BACKGROUND = Color.BLACK;
    public static final Color COLOR_ROOM_UNLOCKED = Color.LIGHT_GRAY;
    public static final Color COLOR_ROOM_LOCKED = Color.DARK_GRAY;
    public static final Color COLOR_DOOR = Color.LIGHT_GRAY;
    public static final Color COLOR_ROOM_START = Color.LIGHT_GRAY;

    //Images
    public static final String IMAGES_FOLDER = "/images/";
    public static final String IMAGES_FOLDER_KEYS = "keys/";
    public static final String IMAGES_FOLDER_CREATURES = "creatures/";
    public static final String IMAGES_FOLDER_ITEMS = "items/";
    public static final String IMAGES_FOLDER_ROOMS = "rooms/";
    public static final String IMAGES_FOLDER_OBJECTS = "objects/";
    public static final String IMAGE_ROOM_CORNER = IMAGES_FOLDER_ROOMS + "room_corner.png";
    public static final String IMAGE_ROOM_WALL_WEST = IMAGES_FOLDER_ROOMS + "room_wall_west.png";
    public static final String IMAGE_ROOM_WALL_NORTH = IMAGES_FOLDER_ROOMS + "room_wall_north.png";
    public static final String IMAGE_ROOM_WALL_EAST = IMAGES_FOLDER_ROOMS + "room_wall_east.png";
    public static final String IMAGE_ROOM_WALL_SOUTH = IMAGES_FOLDER_ROOMS + "room_wall_south.png";
    public static final String IMAGE_ROOM_FLOOR = IMAGES_FOLDER_ROOMS + "room_floor.png";
    public static final String IMAGE_ROOM_DOOR_WEST = IMAGES_FOLDER_ROOMS + "room_door_west.png";
    public static final String IMAGE_ROOM_DOOR_NORTH = IMAGES_FOLDER_ROOMS + "room_door_north.png";
    public static final String IMAGE_ROOM_DOOR_EAST = IMAGES_FOLDER_ROOMS + "room_door_east.png";
    public static final String IMAGE_ROOM_DOOR_SOUTH = IMAGES_FOLDER_ROOMS + "room_door_south.png";
    public static final String IMAGES_NULL = "null.png";

    public static final int DELAY_TELEPORT_TO_BASE = 4000;
    public static final int MAX_INTERACTION_DISTANCE = 5;

    private Config() {
        throw new IllegalAccessError("Config must not be initiated");
    }

}
