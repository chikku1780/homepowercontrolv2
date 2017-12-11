package components;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sys1095 on 8/12/17.
 */
public class Room {

    private String name;
    private HashMap<String, ElectricComponent> electricComponents;
    public int bulbCount;
    public int fanCount;
    public int tvCount;
    public int psCount;

    public Room(String name) {
        this.name = name;
        electricComponents = new HashMap<>();
    }

    public void addComponent(String electricComponentName, ElectricComponent electricComponent) {
        electricComponents.put(electricComponentName, electricComponent);
    }

    public HashMap<String, ElectricComponent> getElectricComponents() {
        return electricComponents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
