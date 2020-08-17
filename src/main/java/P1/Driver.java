package P1;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *  Represent a new Driver with the Name, date of birth, list of license information,
 *  list of vehicles, and list of driver history
 */
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

  /**
   * Return a Name
   * @return a Name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Return the date of birth
   * @return the date of birth
   */
  public LocalDate getDateOfBirth() {
    return this.dateOfBirth;
  }

  /**
   * Return the list of license information
   * @return the list of license information
   */
  public LicenseInformation getLicenseInformation() {
    return this.licenseInformation;
  }

  /**
   * Return the list of vehicles
   * @return the list of vehicles
   */
  public List<Vehicle> getVehicles() {
    return vehicles;
  }

  /**
   * Return the list of driver history
   * @return the list of driver history
   */
  public List<DriverHistory> getDriverHistories() {
    return driverHistories;
  }

  /**
   * addVehicle received the new vehicle and adding it to the list of vehicle if it wasn't in the
   * list of vehicle.
   * @param newVehicle the new vehicle is adding to the Vehicle list if it is not already!
   */
  public void addVehicle (Vehicle newVehicle) {
    if (this.getVehicles().contains(newVehicle)) {
      return;
    }
    this.getVehicles().add(newVehicle);
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
