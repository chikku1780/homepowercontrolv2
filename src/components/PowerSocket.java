package components;

/**
 * Created by sys1095 on 8/12/17.
 */
public class PowerSocket extends ElectricComponent {

    private static final String DEFAULT_PREFIX_FOR_NAME_1 = "PS_";
    private static final String DEFAULT_PREFIX_FOR_NAME_2 = "_PS_";

    public PowerSocket(String name) {
        super(DEFAULT_PREFIX_FOR_NAME_1 + name);
    }

    public PowerSocket(String roomName, String name) {
        super(roomName + DEFAULT_PREFIX_FOR_NAME_2 + name);
    }

}
