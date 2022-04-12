package nicolis_A_Provabella.file;

import main.game.maze.interactable.creature.monster.Monster;
import main.game.maze.interactable.creature.monster.MonsterFactory;
import main.game.util.Util;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleBuilder implements Builder {
    private static final double CHANCE_KEYDOOR_START = 0.1;	//must not be larger than CHANCE_KEYDOOR_END
    private static final double CHANCE_KEYDOOR_END = 0.6;	//must not be larger than 1
    private static final int MONSTERS_MAX_COUNT = 6;	//per room, that is
    private static final double CHANCE_CHESTROOM = 0.1;
    private final MonsterFactory monsterFactory = MonsterFactory.getInstance();
    private Maze maze;

    public SimpleBuilder(Maze maze) {
        this.maze = maze;
    }

    @Override
    public boolean makeKeyDoor(int currentRoomCount, int maxRoomCount) {
        Random rnd = new Random();
        double chance = CHANCE_KEYDOOR_START + ((double) currentRoomCount/(double) maxRoomCount)*(CHANCE_KEYDOOR_END - CHANCE_KEYDOOR_START);
        double random = rnd.nextDouble();
        if (random < chance){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Key placeKeyInMaze(List<Room> currentRooms) {
        Key key;
        Room randomRoom;
        Random rnd = new Random();
        while (true){
            int randomIndex = -1;
            //randomIndex = rnd.nextInt(currentRooms.size());
            double totalWeight = 0;
            for (Room room: currentRooms){
                totalWeight = totalWeight + Math.pow(room.getDistance()+1, 3);
            }
            double random = rnd.nextInt((int) totalWeight);
            double current = 0;
            for (int i = 0; i < currentRooms.size(); i++){
                current = current + Math.pow(currentRooms.get(i).getDistance()+1, 3);
                if (random <= current){
                    randomIndex = i;
                    break;
                }
            }
            key = maze.getAvailableKeys().get(rnd.nextInt(maze.getAvailableKeys().size()));
            randomRoom = currentRooms.get(randomIndex);
            if (randomRoom.getKey() == null){
                break;
            }
        }
        key.setPosition(new Position(Util.randomPointInRoom(key.getImageSize(), randomRoom), randomRoom));
        randomRoom.setKey(key);
        maze.removeKey(key);
        return key;
    }


    private void addNormalMonsters(Room room) {
        Random rnd = new Random();
        int monsterCount = rnd.nextInt(MONSTERS_MAX_COUNT);
        for (int i = 0; i < monsterCount; i++){
            Monster monster = monsterFactory.getNormalMonster();
            monster.increaseLevel(getRandomLevelNormal(room));
            room.addMonster(monster);
            monster.setStartingPosition(room);
        }
    }

    @Override
    public void addMonsters(Maze maze) {
        addNormalMonsters(maze);
        addBossMonster(maze.getBossRoom());
    }

    private void addNormalMonsters(Maze maze) {
        for (int i = 0; i < maze.getWidth(); i++){
            for (int j = 0; j < maze.getHeight(); j++){
                Room room = maze.getRooms().get(i).get(j);
                if (room != null && room != maze.getStartingRoom() && room != maze.getBossRoom()){
                    addNormalMonsters(room);
                }
            }
        }
    }

    private void addBossMonster(Room room) {
        Monster monster = monsterFactory.getBossMonster();
        monster.increaseLevel(getRandomLevelSpecial(room));
        room.addMonster(monster);
        monster.getPosition().setRoom(room);
    }

    private int getRandomLevelSpecial(Room room) {
        double maxLevel = 0;
        int mazeSize = maze.getHeight()*maze.getWidth();
        Random rnd = new Random();
        maxLevel = Math.sqrt(mazeSize) + 1;
        maxLevel = maxLevel/2;
        maxLevel = maxLevel + rnd.nextDouble() * maxLevel;
        return (int) maxLevel;
    }

    private int getRandomLevelNormal(Room room) {
        double maxLevel = 0;
        int mazeSize = maze.getHeight()*maze.getWidth();
        int distance = room.getDistance();
        boolean isCritical = room.isCritical();
        maxLevel = Math.min(distance, Math.sqrt(mazeSize)) + 1;
        if (!isCritical){
            maxLevel = maxLevel/2;
        }
        Random rnd = new Random();
        return rnd.nextInt((int) maxLevel);
    }

    @Override
    public void createCriticalPath() {
        List<Room> rooms = getAllRooms();
        List<Room> currentRooms = new ArrayList<Room>();
        currentRooms.add(maze.getStartingRoom());
        Collections.sort(rooms);
        Collections.reverse(rooms);
        Random rnd = new Random();
        int maxSize = (int) (maze.getWidth()*maze.getHeight()*(0.25+rnd.nextDouble()*0.125)+2);
        //maxSize = 100;
        AtomicInteger keyCount = new AtomicInteger();
        Room destinationRoom = null;
        Iterator<Room> i = rooms.iterator();
        while (currentRooms.size() < maxSize && i.hasNext()){
            destinationRoom = i.next();
            if (currentRooms.contains(destinationRoom)){
                continue;
            }
            int oldSize = currentRooms.size();
            Room currentFurthestRoom = currentRooms.get(oldSize - 1);
            currentRooms = getCriticalRoomsToDestination(destinationRoom, currentRooms, maxSize, keyCount);
            if (oldSize != currentRooms.size()){
                lockDestinationRoom(currentFurthestRoom, destinationRoom, keyCount);
            }
            //System.out.println(TAG + ".createcriticalpath: room: " + destinationRoom);
        }
        for (Room room: currentRooms){
            room.setCritical(true);
        }
        boolean createdBossRoom = createBossRoom(currentRooms, destinationRoom);
        if (!createdBossRoom){
            System.out.println("rebuilding");
            maze.rebuild();
            return;
        }
		/*System.out.println(TAG + ".createcriticalpath: maxsize: " + maxSize);
		System.out.println(TAG + ".createcriticalpath: size: " + currentRooms.size());
		System.out.println(TAG + ".createcriticalpath: keys: " + keyCount.get());*/

    }

    private List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < maze.getWidth(); i++){
            for (int j = 0; j < maze.getHeight(); j++){
                Room room = maze.getRooms().get(i).get(j);
                if (room != null && room != maze.getStartingRoom()){
                    rooms.add(room);
                }
            }
        }
        return rooms;
    }

    private boolean createBossRoom(List<Room> currentRooms, Room destinationRoom) {
        if (destinationRoom == null){
            throw new NullPointerException("destination room can not be null");
        }
        List<Room> usableRooms = new ArrayList<Room>(currentRooms);
        Collections.shuffle(usableRooms);
        maze.removeKey(destinationRoom);
        Direction[] directions = Direction.values();
        for (Room room: usableRooms){	//for each room we currently hold
            for (Direction dir: directions){	//for each direction
                Door door = room.getDoorByDirection(dir);	//try getting door to room at direction
                if (door != null && dir != room.getDirectionOfPreviousRoom()){	//if the room exists and room is not parent room
                    Room candidateRoom = room.getDoorByDirection(dir).getRoom();	//get the possible candidate room
                    if ((candidateRoom.numberOfDoors() == 1) && candidateRoom.getKey() == null && !candidateRoom.isCritical()){
                        //if candidate room is dead end and it has no keys in it and it is not critical (i.e. we don't already have the room)
                        Key key;
                        if (candidateRoom.isLockedWithKey()){
                            //if the room is locked with key then reset the key's position
                            key = candidateRoom.getLockingKey();
                            key.getPosition().getRoom().setKey(null);
                            key.resetPosition();
                        } else {
                            //if room is not locked, lock the room with random available key
                            Random rnd = new Random();
                            key = maze.getAvailableKeys().get(rnd.nextInt(maze.getAvailableKeys().size() - 1));
                            room.setDoor(dir, new KeyDoor(candidateRoom, key));
                        }
                        //position the key is farthest position in the maze
                        key.setPosition(new Position(Util.randomPointInRoom(key.getImageSize(), destinationRoom), destinationRoom));
                        destinationRoom.setKey(key);
                        maze.setBossRoom(candidateRoom);
                        return true;
                    }
                }

            }
        }
        //if we got this far, it means we couldn't find suitable room and we are forced to rebuild the whole maze and try again
        return false;
    }

    private void lockDestinationRoom(Room currentFurthestRoom, Room destinationRoom, AtomicInteger keyCount) {
        final List<Key> keys = maze.getAvailableKeys();
        if (keys.size() == 1 && !destinationRoom.isLockedWithKey()){
            //must keep at least one key for boss
            return;
        }
        maze.removeKey(currentFurthestRoom);
        Key key = null;
        if (destinationRoom.isLockedWithKey()){
            key = destinationRoom.getLockingKey();
            key.getPosition().getRoom().setKey(null);
            key.resetPosition();
        } else {
            Random rnd = new Random();
            key = keys.get(rnd.nextInt(keys.size()));
            Direction dir = destinationRoom.getDirectionOfPreviousRoom().getOpposite();
            destinationRoom.getPreviousRoom().setDoor(dir, new KeyDoor(destinationRoom, key));
            keys.remove(key);
            keyCount.incrementAndGet();
        }
        key.setPosition(new Position(Util.randomPointInRoom(key.getImageSize(), currentFurthestRoom), currentFurthestRoom));
        currentFurthestRoom.setKey(key);
    }

    /**
     * Returns list of rooms to destination room, so that total number of rooms are less than maximum size,
     * in which case initial list of rooms is returned.
     * @param destinationRoom target room
     * @param currentRooms current list of rooms
     * @param maxSize maximum number of rooms
     * @param keyCounterFinal counter to get number of critical keys
     * @return
     */
    private List<Room> getCriticalRoomsToDestination(Room destinationRoom, List<Room> currentRooms, int maxSize, AtomicInteger keyCounterFinal) {
        List<Room> roomsToUnlock = roomsToDestination(currentRooms, destinationRoom);
        List<Room> newRooms = new ArrayList<Room>(currentRooms);
        AtomicInteger keyCounterTemp = new AtomicInteger();
        for (Iterator<Room> i = roomsToUnlock.iterator(); i.hasNext();){
            if (newRooms.size() > maxSize){
                return currentRooms;
            }
            Room room = i.next();
            if (!newRooms.contains(room)){	//if we already have got the room added
                if (room.isLockedWithKey()){	//is the room locked with key
                    Room keyRoom = room.getLockingKey().getPosition().getRoom();	//position of the key
                    List<Room> returnList = new ArrayList<Room>();
                    if (!newRooms.contains(keyRoom)){	//do we already have access to room the key is located in
                        returnList = getCriticalRoomsToDestination(keyRoom, newRooms, maxSize, keyCounterTemp);
                    }
                    if (returnList.contains(keyRoom)){	//does the returned list contain the keyroom now, if not, it must've been too long path
                        newRooms = returnList;
                    } else if (!newRooms.contains(keyRoom)){	//did we already have the keyroom
                        return currentRooms;
                    }
                    keyCounterTemp.incrementAndGet();	//increase key counter for statistical purposes
                    newRooms.add(room);	//as we now have access to room, add it to collection
                } else {	//if the room isnt locked with key, we can just add it
                    newRooms.add(room);
                }
            }
        }
        keyCounterFinal.addAndGet(keyCounterTemp.get());	//increase the initial counter by our result
        return newRooms;

    }

    /**
     * Returns list of all rooms from base to destinationroom (inclusive) that are not in given list.
     * @param currentRooms list of current rooms
     * @param destinationRoom target room
     * @return
     */
    private List<Room> roomsToDestination(List<Room> currentRooms, Room destinationRoom) {
        List<Room> roomsToUnlock = new ArrayList<Room>();
        Room room = destinationRoom;
        while (!currentRooms.contains(room)){
            roomsToUnlock.add(room);
            room = room.getPreviousRoom();
        }
        Collections.sort(roomsToUnlock);
        return roomsToUnlock;
    }

    protected Room createStartingRoom(Point point) {
        return new StartingRoom(maze, point);
    }

    protected Room createRoom(Room room, Direction direction){
        Random rnd = new Random();
        if (rnd.nextDouble() < CHANCE_CHESTROOM){
            return new ChestRoom(maze, room, direction);
        } else {
            return new SimpleRoom(maze, room, direction);
        }
    }

    public void buildLabyrinth() {
        List<Room> extendableRooms = new ArrayList<Room>();
        List<Room> currentRooms = new ArrayList<Room>();
        extendableRooms.add(maze.getStartingRoom());
        currentRooms.add(maze.getStartingRoom());
        Random rnd = new Random();
        Room room;
        while (!extendableRooms.isEmpty()){
            room = extendableRooms.get(rnd.nextInt(extendableRooms.size()));
            List<Direction> directions = maze.validDirections(room);
            if (directions.isEmpty()){
                extendableRooms.remove(room);
                continue;
            }
            Direction dir = directions.get(rnd.nextInt(directions.size()));	//random direction from valid directions
            Point p = dir.add(room.getCoordinates());
            Room newRoom = createRoom(room, dir.getOpposite());
            createDoor(dir, room, newRoom,currentRooms);
            currentRooms.add(newRoom);
            maze.getRooms().get(p.x).put(p.y, newRoom);
            if (!maze.validDirections(newRoom).isEmpty()){
                extendableRooms.add(newRoom);
            }
            if (maze.validDirections(room).isEmpty()){
                extendableRooms.remove(room);
            }
        }
    }

    private void createDoor(Direction direction, Room parentRoom, Room newRoom, List<Room> currentRooms){
        if (makeKeyDoor(currentRooms.size(), maze.getWidth()*maze.getHeight()) && (Key.KEYS.size()-maze.getAvailableKeys().size()) < currentRooms.size() && maze.getAvailableKeys().size()>1){	// 1 key for boss
            Key key = placeKeyInMaze(currentRooms);
            parentRoom.setDoor(direction, new KeyDoor(newRoom, key));
        } else {
            parentRoom.setDoor(direction, new SimpleDoor(newRoom));
        }
    }

    public void createStartingRoom(){
        Random rnd = new Random();
        int x = rnd.nextInt(maze.getWidth());
        int y = rnd.nextInt(maze.getHeight());
        maze.setStartingRoom(createStartingRoom(new Point(x,y)));
        maze.getRooms().get(x).put(y, maze.getStartingRoom());
    }
}