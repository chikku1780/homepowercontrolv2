package components;

/**
 * Created by sys1095 on 8/12/17.
 */
public class Fan extends ElectricComponent {

    private static final String DEFAULT_PREFIX_FOR_NAME_1 = "F_";
    private static final String DEFAULT_PREFIX_FOR_NAME_2 = "_F_";

    public Fan(String name) {
        super(DEFAULT_PREFIX_FOR_NAME_1 + name);
    }

    public Fan(String roomName, String name) {
        super(roomName + DEFAULT_PREFIX_FOR_NAME_2 + name);
    }
}
