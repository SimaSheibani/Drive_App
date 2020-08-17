package P1;

import java.util.List;
import java.util.Objects;

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


  public String getDriverLicenseUniqueNumber() {
    return driverLicenseUniqueNumber;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public Integer getYear() {
    return year;
  }

  public Name getOfficialOwnerName() {
    return officialOwnerName;
  }

  public InsuranceInfo getInsuranceInfo() {
    return insuranceInfo;
  }

  public List<VehicleHistory> getVehicleHistories() {
    return vehicleHistories;
  }

  public String getColor() {
    return color;
  }

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
