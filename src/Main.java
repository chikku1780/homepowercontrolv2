import components.*;
import utilities.Utility;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by sys1095 on 8/12/17.
 */

public class Main {

    public boolean keepRunning = true;
    public House house = null;

    public static void main(String[] args) {
        Main obj = new Main();
        obj.init();
    }

    public void init() {
        System.out.println("------- init() -----------");

        HashMap<Utility.conditionConstants, Boolean> conditionsZero = new HashMap<>();
        conditionsZero.put(Utility.conditionConstants.LESS_ZERO, true);

        String houseName = getStringFromConsole("Enter HouseName > ");
        int roomCount = getNumberFromConsole("Enter RoomCount > ", conditionsZero);
        house = getHouseInformation(houseName, roomCount);

//        showHouseStatus();
        showHint();

        getQueryFromConsole("Enter > ");

    }

    public House getHouseInformation(String houseName, int roomCount) {
        HashMap<Utility.conditionConstants, Boolean> conditionsPositive = new HashMap<>();
        conditionsPositive.put(Utility.conditionConstants.POSITIVE, true);

        HashMap<String, Room> rooms = new HashMap<>();
        House house = new House(houseName);
        house.setRoomCount(roomCount);
        for (int i = 1; i <= roomCount; i++) {
            System.out.println("Give Room " + i + " Details");
            String roomName = getStringFromConsole("Enter RoomName > ");
            Room room = new Room(roomName);
            int bulbCount = getNumberFromConsole("Enter BulbCount > ", conditionsPositive);
            int fanCount = getNumberFromConsole("Enter FanCount > ", conditionsPositive);
            int tvCount = getNumberFromConsole("Enter TVCount > ", conditionsPositive);
            int psCount = getNumberFromConsole("Enter PSCount > ", conditionsPositive);
            for (int b = 1; b <= bulbCount; b++) {
                Bulb bulbObj = new Bulb(roomName, Integer.toString(b));
                room.addComponent(bulbObj.getName(), bulbObj);
            }
            for (int f = 1; f <= fanCount; f++) {
                Fan fanObj = new Fan(roomName, Integer.toString(f));
                room.addComponent(fanObj.getName(), fanObj);
            }
            for (int tv = 1; tv <= tvCount; tv++) {
                TV tvObj = new TV(roomName, Integer.toString(tv));
                room.addComponent(tvObj.getName(), tvObj);
            }
            for (int ps = 1; ps <= psCount; ps++) {
                PowerSocket psObj = new PowerSocket(roomName, Integer.toString(ps));
                room.addComponent(psObj.getName(), psObj);
            }
            rooms.put(roomName, room);
        }
        house.setRooms(rooms);

        return house;
    }

    public void getQueryFromConsole(String showMessage) {
        String query;
        do {
            boolean isNull;
            boolean isNotProperQuery;
            boolean goAhead;
            boolean release;
            do {
                System.out.print(showMessage + "\t");
                query = Utility.getRawInput();
                isNull = query.equals("");
                isNotProperQuery = false;
                goAhead = false;
                if (!isNull) {
                    query = query.toLowerCase();
                    if (query.equals(Utility.processState.q.toString()) || query.equals(Utility.processState.quit.toString())) {
                        keepRunning = false;
                        exit();
                    } else if (query.equals(Utility.processState.hint.toString())) {
                        showHint();
                    } else if (query.equals(Utility.processState.show.toString())) {
                        showHouseStatus();
                    } else {
                        if (query.contains("_") && query.contains("=")) {
                            String[] queryParts1 = query.split("_");
                            String[] queryParts2 = query.split("=");
                            if (queryParts1.length == 3 && queryParts2.length == 2) {
                                goAhead = processQuery(queryParts1, queryParts2);
                                showHouseStatus();
                            } else {
                                isNotProperQuery = true;
                                System.out.println("Error:: Query Structure is not Proper!");
                            }
                        } else {
                            isNotProperQuery = true;
                            System.out.println("Error:: Query Structure is not Proper!");
                        }
                    }
                } else {
                    System.out.println("Error:: Required");
                }
                release = isNull || isNotProperQuery || goAhead;
            } while (release);

        } while (keepRunning);
    }

    public boolean processQuery(String[] queryParts1, String[] queryParts2) {
        String roomString = queryParts1[0];
        if (house.getRooms().containsKey(roomString)) {
            Room room = house.getRooms().get(roomString);
            if (room.getElectricComponents().containsKey(queryParts2[0])) {
                ElectricComponent electricComponent = room.getElectricComponents().get(queryParts2[0]);
                electricComponent.getaSwitch().setStatus(Integer.parseInt(queryParts2[1]));
            } else {
                System.out.println("No ElectricComponent found");
            }
        } else {
            System.out.println("No room found");
        }

        return true;

    }

    public void showHouseStatus() {
        if (house != null) {
            System.out.println("------- info() -----------");
            System.out.println("House Name:: " + house.getName() + " with RoomCount " + house.getRoomCount());
            HashMap<String, Room> rooms = house.getRooms();
            for (Room room : rooms.values()) {
                System.out.println("Room Name :: " + room.getName());
                HashMap<String, ElectricComponent> electricComponents = room.getElectricComponents();
                for (ElectricComponent electricComponent : electricComponents.values()) {
                    System.out.print(electricComponent.getName() + " - ");
                    System.out.println(electricComponent.getaSwitch().getStatus());
                }
            }
            System.out.println("------------------------------");
        } else {
            System.out.println("Error:: Oops! House found null");
        }
    }

    public void showHint() {
        System.out.println("------- hint() -----------");
        System.out.println("Give:: hint - for this");
        System.out.println("Give:: show - for current stats");
        System.out.println("Give:: room1_b_1 = 1 (<RoomName>_<ElectricComponent(b/f/tv/ps)>_<Number> = 1) - for changing status");
        System.out.println("Give:: q/quit- for exit");
        System.out.println("--------------------------");
    }


    public String getStringFromConsole(String showMessage) {
        return takeInputFromKeyBoard(showMessage, Utility.dataType.String);
    }

    public Integer getNumberFromConsole(String showMessage) {
        String inputString = takeInputFromKeyBoard(showMessage, Utility.dataType.Number);
        return Integer.parseInt(inputString);
    }

    public Integer getNumberFromConsole(String showMessage, HashMap<Utility.conditionConstants, Boolean> conditions) {
        String inputString = takeInputFromKeyBoard(showMessage, Utility.dataType.Number, conditions);
        return Integer.parseInt(inputString);
    }


    public String takeInputFromKeyBoard(String showMessage, Utility.dataType dataType) {
        String s;
        boolean isNull;
        boolean isNotNumber;
        boolean release;
        do {
            System.out.print(showMessage + "\t");
            s = Utility.getRawInput();
            isNull = s.equals("");
            isNotNumber = false;
            if (!isNull) {
                if (dataType.equals(Utility.dataType.Number)) {
                    isNotNumber = !Utility.isInteger(s);
                    if (isNotNumber) {
                        System.out.println("Error:: Number required");
                    }
                }
            } else {
                System.out.println("Error:: Required");
            }
            release = isNull || isNotNumber;
        } while (release);
        return s.trim();
    }

    public String takeInputFromKeyBoard(String showMessage, Utility.dataType dataType, HashMap<Utility.conditionConstants, Boolean> conditions) {
        String s;
        boolean isNull;
        boolean isNotNumber;
        boolean isNotPositive;
        boolean isLessZero;
        boolean release;
        do {
            System.out.print(showMessage + "\t");
            s = Utility.getRawInput();
            isNull = s.equals("");
            isNotNumber = false;
            isNotPositive = false;
            isLessZero = false;
            if (!isNull) {
                if (dataType.equals(Utility.dataType.Number)) {
                    isNotNumber = !Utility.isInteger(s);
                    if (isNotNumber) {
                        System.out.println("Error:: Number required");
                    } else {
                        if (!conditions.isEmpty()) {
                            if (conditions.containsKey(Utility.conditionConstants.LESS_ZERO)) {
                                boolean conditionZero = conditions.get(Utility.conditionConstants.LESS_ZERO);
                                if (conditionZero) {
                                    int inputNumber = Integer.parseInt(s);
                                    if (inputNumber <= 0) {
                                        isLessZero = true;
                                        System.out.println("Error:: Number > 0");
                                    }
                                }
                            }

                            if (conditions.containsKey(Utility.conditionConstants.POSITIVE)) {
                                boolean conditionPositive = conditions.get(Utility.conditionConstants.POSITIVE);
                                if (conditionPositive) {
                                    int inputNumber = Integer.parseInt(s);
                                    if (inputNumber < 0) {
                                        isNotPositive = true;
                                        System.out.println("Error:: Number >= 0");
                                    }
                                }
                            }

                        }
                    }
                }
            } else {
                System.out.println("Error:: Required");
            }
            release = isNull || isNotNumber || isNotPositive || isLessZero;
        } while (release);
        return s.trim();
    }

    public void exit() {
        System.out.println();
        System.out.println("------- exit() Bye -----------");
    }

}
