package P1;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Driver {

  private Name name;
  private LocalDate dateOfBirth;
  private LicenseInformation licenseInformation;
  private List<Vehicle> vehicles;
  private List<DriverHistory> driverHistories;


  private Driver(Builder builder) {
    this.name = builder.name;
    this.dateOfBirth = builder.dateOfBirth;
    this.licenseInformation = builder.licenseInformation;
    this.vehicles = builder.vehicles;
    this.driverHistories = builder.driverHistories;
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

  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  public List<DriverHistory> getDriverHistories() {
    return driverHistories;
  }

  public List<Vehicle> addVehicleToList(Vehicle vehicle) {
    this.vehicles.add(vehicle);
    return this.vehicles;
  }

  public static class Builder {

    private Name name;
    private LocalDate dateOfBirth;
    private LicenseInformation licenseInformation;
    private List<Vehicle> vehicles;
    private List<DriverHistory> driverHistories;
    private static Driver instance = null;

    public Builder(Name name, LocalDate dateOfBirth,
        LicenseInformation licenseInformation) {
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.licenseInformation = licenseInformation;
      this.vehicles = null;
    }

    public Builder addName(Name name) {
      this.name = name;
      return this;
    }

    public Builder addDateOfBirth(LocalDate dateOfBirth) {
      this.dateOfBirth = dateOfBirth;
      return this;
    }

    public Builder addLicenseInformation(LicenseInformation licenseInformation) {
      this.licenseInformation = licenseInformation;
      return this;
    }

    public Builder addDriverHistories(List<DriverHistory> driverHistories) {
      this.driverHistories = driverHistories;
      return this;
    }

    public Builder addVehicles(List<Vehicle> vehicles) {
      this.vehicles = vehicles;
      return this;
    }

    public Driver build() {
      if (this.instance == null) {
       this.instance = new Driver(this);
      }
      return instance;
    }
  }

}
