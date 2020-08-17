package P1;

import java.util.HashMap;
import java.util.Map;

public class Pool {

    private Map<String, Driver> drivers;
    private static Pool instance = null;

    private Pool() {
        this.drivers = new HashMap<>();
        instance = this;
    }

    public Pool GetPool() {
        if (instance == null) {
            return new Pool();
        }
        return instance;
    }

    public Map<String, Driver> getDrivers() {
        return drivers;
    }

    public void AddDriver(Driver newDriver) {
        if (this.drivers.containsKey(newDriver.getLicenseInformation().getLicenseUniqueNumber())) {
            for (Vehicle v : newDriver.getVehicles()) {
                if(!this.drivers.get(newDriver.getLicenseInformation().getLicenseUniqueNumber()).getVehicles().contains(v))
                {
                    this.drivers.get(newDriver.getLicenseInformation().getLicenseUniqueNumber()).getVehicles().add(v);
                }
            }
        }
        else {
            this.drivers.put(newDriver.getLicenseInformation().getLicenseUniqueNumber(), newDriver);
        }
    }

    public String provideDriverInfo(String lastName) {
        StringBuilder sb = new StringBuilder();
        for (Driver driver : this.drivers.values()) {
            if (driver.getName().getLastName().equals(lastName)) {
                sb.append(driver.getName().getLastName()+", "+driver.getName().getFirstName()+" \n");

            }
        }
        return "";
    }
}
