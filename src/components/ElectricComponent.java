package components;

/**
 * Created by sys1095 on 8/12/17.
 */
public class ElectricComponent {

    private String name;
    private Switch aSwitch;

    public ElectricComponent(String name) {
        this.name = name.toLowerCase();
        aSwitch = new Switch();
    }

    public String getComponentStatus() {
        return "Name " + getName() + " - Status " + aSwitch.getStatus();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Switch getaSwitch() {
        return aSwitch;
    }

    public void setaSwitch(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }
}
