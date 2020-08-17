package P1;

import java.util.List;
import java.util.Objects;

/**
 * Represent the Vehicle class. It contains information about the vehicle, including make, model,
 * year, color, licensePlate, officialOwnerName, driverLicenseUniqueNumber, InsuranceInfo,
 * and vehicle history
 */
public class Vehicle {

  private String make;
  private String model;
  private Integer year;
  private String color;
  private String licensePlate;
  private Name officialOwnerName;
  private String driverLicenseUniqueNumber;
  private InsuranceInfo insuranceInfo;
  private List<VehicleHistory> vehicleHistories = null;

  /**
   * make a new vehicle based upon all of the provided input parameters without vehicle history
   * @param make - make of vehicle
   * @param model - model of vehicle
   * @param year - year of vehicle
   * @param licensePlate - license plate of vehicle
   * @param color - color of vehicle
   * @param officialOwnerName - official owner name of vehicle
   * @param driverLicenseUniqueNumber - driver license unique number of vehicle
   * @param insuranceInfo - insurance information of vehicle
   */
  public Vehicle(
          String make,
          String model,
          Integer year,
          String licensePlate,
          String color,
          Name officialOwnerName,
          String driverLicenseUniqueNumber,
          InsuranceInfo insuranceInfo)
  {
    this.make = make;
    this.model = model;
    this.year = year;
    this.licensePlate = licensePlate;
    this.color = color;
    this.officialOwnerName = officialOwnerName;
    this.driverLicenseUniqueNumber = driverLicenseUniqueNumber;
    this.insuranceInfo = insuranceInfo;
  }
  /**
   * make a new vehicle based upon all of the provided input parameters without vehicle history
   * @param make - make of vehicle
   * @param model - model of vehicle
   * @param year - year of vehicle
   * @param licensePlate - license plate of vehicle
   * @param color - color of vehicle
   * @param officialOwnerName - official owner name of vehicle
   * @param driverLicenseUniqueNumber - driver license unique number of vehicle
   * @param insuranceInfo - insurance information of vehicle
   * @param vehicleHistories - history of car's violation
   */
  public Vehicle(
          String make,
          String model,
          Integer year,
          String licensePlate,
          String color,
          Name officialOwnerName,
          String driverLicenseUniqueNumber,
          InsuranceInfo insuranceInfo,
          List<VehicleHistory> vehicleHistories)
  {
    this.make = make;
    this.model = model;
    this.year = year;
    this.color = licensePlate;
    this.color = color;
    this.officialOwnerName = officialOwnerName;
    this.driverLicenseUniqueNumber = driverLicenseUniqueNumber;
    this.insuranceInfo = insuranceInfo;
    this.vehicleHistories = vehicleHistories;
  }

  /**
   * Return the driver license unique number
   * @return the driver license unique number
   */
  public String getDriverLicenseUniqueNumber() {
    return driverLicenseUniqueNumber;
  }

  /**
   * Return the make of vehicle
   * @return the make of vehicle
   */
  public String getMake() {
    return make;
  }

  /**
   * Return the model
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Return the year
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Return the official owner name
   * @return the official owner name
   */
  public Name getOfficialOwnerName() {
    return officialOwnerName;
  }

  /**
   * Return the insurance info
   * @return the insurance info
   */
  public InsuranceInfo getInsuranceInfo() {
    return insuranceInfo;
  }

  /**
   * Return the list of vehicle histories
   * @return the list vehicle histories
   */
  public List<VehicleHistory> getVehicleHistories() {
    return vehicleHistories;
  }

  /**
   * Return the color of vehicle
   * @return the color vehicle
   */
  public String getColor() {
    return color;
  }

  /**
   * Return the license plate
   * @return the license plate
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(make, vehicle.make) &&
            Objects.equals(model, vehicle.model) &&
            Objects.equals(year, vehicle.year) &&
            Objects.equals(color, vehicle.color) &&
            Objects.equals(driverLicenseUniqueNumber, vehicle.driverLicenseUniqueNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, color, driverLicenseUniqueNumber);
  }
}
