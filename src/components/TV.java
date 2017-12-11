package components;

/**
 * Created by sys1095 on 8/12/17.
 */
public class TV extends ElectricComponent {

    private static final String DEFAULT_PREFIX_FOR_NAME_1 = "TV_";
    private static final String DEFAULT_PREFIX_FOR_NAME_2 = "_TV_";

    public TV(String name) {
        super(DEFAULT_PREFIX_FOR_NAME_1 + name);
    }

    public TV(String roomName, String name) {
        super(roomName + DEFAULT_PREFIX_FOR_NAME_2 + name);
    }
}
