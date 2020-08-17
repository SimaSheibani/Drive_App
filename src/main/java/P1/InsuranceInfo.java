package P1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsuranceInfo {

  private Name name;
  private String LicenseUniqueNumber;
  private LocalDate expirationDate;
  private List<Map<String, String>> otherPeopleCovered;

  private InsuranceInfo(Builder builder) {
    this.name = builder.name;
    this.LicenseUniqueNumber = builder.LicenseUniqueNumber;
    this.expirationDate = builder.expirationDate;
    this.otherPeopleCovered = builder.otherPeopleCovered;
  }

  public Name getName() {
    return this.name;
  }

  public String getDriverLicense() {
    return this.LicenseUniqueNumber;
  }

  public List<Map<String, String>> getOtherPeopleCovered() {
    return otherPeopleCovered;
  }

  public LocalDate getExpirationDate() {
    return this.expirationDate;
  }

  public void setOtherPeopleCovered(List<Map<String, String>> otherPeopleCovered) {
    this.otherPeopleCovered = otherPeopleCovered;
  }

  public class Builder {

    private Name name;
    private String LicenseUniqueNumber;
    private LocalDate expirationDate;
    private List<Map<String, String>> otherPeopleCovered;

    public Builder (Name name, String LicenseUniqueNumber, LocalDate expirationDate) {

      this.name = name;
      this.LicenseUniqueNumber = LicenseUniqueNumber;
      this.expirationDate = expirationDate;
      this.otherPeopleCovered = new ArrayList<>();
    }

    public Builder addOtherDriver (Name name, String LicenseUniqueNumber) {
      Map<String, String> driverInfo = new HashMap<>();
      driverInfo.put("First Name", name.getFirstName());
      driverInfo.put("Last Name", name.getLastName());
      driverInfo.put("License Unique Number", LicenseUniqueNumber);
      this.otherPeopleCovered.add(driverInfo);
      return this;
    }

    public InsuranceInfo build() {
      return new InsuranceInfo(this);
    }

  }

}

