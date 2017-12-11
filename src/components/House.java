package components;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sys1095 on 8/12/17.
 */
public class House {

    private String name;
    private int roomCount;
    private HashMap<String, Room> rooms;

    public House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }
}
