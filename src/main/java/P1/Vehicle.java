package P1;

import P1.Driver.Builder;

public class Vehicle {

  protected String make;
  protected String model;
  protected Integer year;
  protected Name officialOwnerName;
  protected InsuranceInfo insuranceInfo;
  protected VehicleHistory vehicleHistory;

  public Vehicle(Builder builder) {
    this.make = builder.make;
    this.model = builder.model;
    this.year = builder.year;
    this.officialOwnerName = builder.officialOwnerName;
    this.insuranceInfo = builder.insuranceInfo;
    this.vehicleHistory = builder.vehicleHistory;
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

  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  public static class Builder {

    private String make;
    private String model;
    private Integer year;
    private Name officialOwnerName;
    private InsuranceInfo insuranceInfo;
    private VehicleHistory vehicleHistory;

    public Builder(String make, String model, Integer year, Name officialOwnerName,
        InsuranceInfo insuranceInfo) {
      this.make = make;
      this.model = model;
      this.year = year;
      this.officialOwnerName = officialOwnerName;
    }

    public Builder addVehicleHistory(VehicleHistory history) {
      this.vehicleHistory = history;
      return this;
    }

    public Vehicle build() {return new Vehicle(this);}

  }



}
