package components;

/**
 * Created by sys1095 on 8/12/17.
 */
public class Switch {

    private int status;

    public Switch() {
        this.status = 0;
    }

    public void on() {
        this.status = 1;
    }

    public void off() {
        this.status = 0;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
