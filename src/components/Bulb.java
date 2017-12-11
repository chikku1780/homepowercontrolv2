package components;

/**
 * Created by sys1095 on 8/12/17.
 */
public class Bulb extends ElectricComponent {

    private static final String DEFAULT_PREFIX_FOR_NAME_1 = "B_";
    private static final String DEFAULT_PREFIX_FOR_NAME_2 = "_B_";

    public Bulb(String name) {
        super(DEFAULT_PREFIX_FOR_NAME_1 + name);
    }

    public Bulb(String roomName, String name) {
        super(roomName + DEFAULT_PREFIX_FOR_NAME_2 + name);
    }
}
