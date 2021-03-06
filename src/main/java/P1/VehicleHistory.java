package P1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Represent a VehicleHistory class. It contains name offending driver, driver license information,
 * date, crash , violationMoving, violationNonMoving.
 */
public class VehicleHistory {

  private Name nameOffendingDriver;
  private String driverLicenseInformation;
  private LocalDate date;
  private Crash crash = null;
  private ViolationMoving violationMoving = null;
  private ViolationNonMoving violationNonMoving = null;


  private VehicleHistory(Builder builder) {
    this.nameOffendingDriver = builder.nameOffendingDriver;
    this.driverLicenseInformation = builder.driverLicenseInformation;
    this.date = builder.date;
    this.crash = builder.crash;
    this.violationMoving = builder.violationMoving;
    this.violationNonMoving = builder.violationNonMoving;
  }

  /**
   * Return the nameOffendingDriver
   * @return the nameOffendingDriver
   */
  public Name getNameOffendingDriver() {
    return this.nameOffendingDriver;
  }

  /**
   * Return the DriverLicenseInformation
   * @return the DriverLicenseInformation
   */
  public String getDriverLicenseInformation() {
    return this.driverLicenseInformation;
  }

  /**
   * Return the date of violation or crash
   * @return the date of violation or crash
   */
  public LocalDate getDate() {
    return this.date;
  }

  /**
   * Return the Crash of vehicle
   * @return the crash of vehicle
   */
  public Crash getCrash() {
    return this.crash;
  }

  /**
   * Return the violationMoving
   * @return the violationMoving
   */
  public ViolationMoving getViolationMoving() {
    return this.violationMoving;
  }

  /**
   * Return the violationNonMoving
   * @return the violationNonMoving
   */
  public ViolationNonMoving getViolationNonMoving() {
    return this.violationNonMoving;
  }

  public static class Builder {
    private Name nameOffendingDriver;
    private String driverLicenseInformation;
    private LocalDate date;
    private Crash crash = null;
    private ViolationMoving violationMoving = null;
    private ViolationNonMoving violationNonMoving = null;
    private static VehicleHistory instance = null;

    public Builder (Name nameOffendingDriver, String driverLicenseInformation, LocalDate date) {
      this.nameOffendingDriver = nameOffendingDriver;
      this.driverLicenseInformation = driverLicenseInformation;
      this.date = date;
    }

    public Builder addCrash(Crash crash) {
      this.crash = crash;
      return this;
    }

    public Builder addViolationMoving(ViolationMoving violationMoving) {
      this.violationMoving = violationMoving;
      return this;
    }

    public Builder addViolationNonMoving(ViolationNonMoving violationNonMoving) {
      this.violationNonMoving = violationNonMoving;
      return this;
    }

    public VehicleHistory build() {
      if (this.instance == null) {
        this.instance = new VehicleHistory(this);
      }
      return instance;
    }
  }
}
