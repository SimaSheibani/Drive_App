package P1;

import java.time.LocalDate;
import java.util.List;

public class Driver {

  private Name name;
  private LocalDate dateOfBirth;
  private LicenseInformation licenseInformation;
  private DriverHistory driverHistory;
  private List<Vehicle> listOfVehicle;

  public Driver(Builder builder) {
    this.name = builder.name;
    this.dateOfBirth = builder.dateOfBirth;
    this.licenseInformation = builder.licenseInformation;
    this.driverHistory = builder.driverHistory;
    this.listOfVehicle = builder.listOfVehicles;
  }

  public Name getName() {
    return this.name;
  }

  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  public LicenseInformation getLicenseInformation() {
    return this.licenseInformation;
  }

  public DriverHistory getDriverHistory() {
    return this.driverHistory;
  }

  public List<Vehicle> addVehicleToList(Vehicle vehicle) {
    this.listOfVehicle.add(vehicle);
    return this.listOfVehicle;
  }



  public static class Builder {

    private Name name;
    private LocalDate dateOfBirth;
    private LicenseInformation licenseInformation;
    private DriverHistory driverHistory;
    private List<Vehicle> listOfVehicles;

    public Builder(Name name, LocalDate dateOfBirth,
        LicenseInformation licenseInformation) {
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.licenseInformation = licenseInformation;
      this.listOfVehicles = null;
    }

    public Builder addHistory(DriverHistory driverHistory) {
      this.driverHistory = driverHistory;
      return this;
    }

    public Driver build() {
      return new Driver(this);
    }
  }
}
