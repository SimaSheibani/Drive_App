package P1;

import java.util.List;

public class Vehicle {

  private String make;
  private String model;
  private Integer year;
  private Name officialOwnerName;
  private String driverLicenseUniqueNumber;
  private InsuranceInfo insuranceInfo;
  private List<VehicleHistory> vehicleHistories = null;


  public Vehicle(
          String make,
          String model,
          Integer year,
          Name officialOwnerName,
          String driverLicenseUniqueNumber,
          InsuranceInfo insuranceInfo)
  {
    this.make = make;
    this.model = model;
    this.year = year;
    this.officialOwnerName = officialOwnerName;
    this.driverLicenseUniqueNumber = driverLicenseUniqueNumber;
    this.insuranceInfo = insuranceInfo;
  }

  public Vehicle(
          String make,
          String model,
          Integer year,
          Name officialOwnerName,
          String driverLicenseUniqueNumber,
          InsuranceInfo insuranceInfo,
          List<VehicleHistory> vehicleHistories)
  {
    this.make = make;
    this.model = model;
    this.year = year;
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

}
