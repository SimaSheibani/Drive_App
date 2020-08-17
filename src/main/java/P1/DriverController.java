package P1;

public class DriverController {

    private static DriverController instance;
    private DriverController () {

    }

    public static synchronized DriverController getInstance() {
        if (instance == null ) {
            instance = new DriverController();
        }
        return instance;
    }

    public boolean Register() {

        return true;
    }
}
