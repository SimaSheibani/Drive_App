package P1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represent LicenseInformation class. A LicenseInformation contains
 * information about the Driver license, including licenseUniqueNumber, driverName, driverAddress,
 * driverBirthDay, countryIssue, stateIssue, issueDate, expirationDate.
 */
public class LicenseInformation {

  private Integer licenseUniqueNumber;
  private Name name;
  private String driverAddress;
  private LocalDate birthday;
  private String countryIssue;
  private String stateIssue;
  private LocalDate issueDate;
  private LocalDate expirationDate;

  /**
   * A constructor make a new licenseInformation, based upon all of the provided input parameters.
   * @param licenseUniqueNumber - information about the a license unique number
   * @param name - driver's name
   * @param driverAddress - driver's address
   * @param birthday - driver's birthday
   * @param countryIssue - country issuance
   * @param stateIssue - state of issuance
   * @param issueDate - date of issue
   * @param expirationDate - expiration date
   */
  public LicenseInformation(Integer licenseUniqueNumber, Name name,
      String driverAddress, LocalDate birthday, String countryIssue,
      String stateIssue, LocalDate issueDate, LocalDate expirationDate) {
    this.licenseUniqueNumber = licenseUniqueNumber;
    this.name = name;
    this.driverAddress = driverAddress;
    this.birthday = birthday;
    this.countryIssue = countryIssue;
    this.stateIssue = stateIssue;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
  }

  public Integer getLicenseUniqueNumber() {
    return licenseUniqueNumber;
  }

  public Name getName() { return name;}

  public String getDriverAddress() {
    return driverAddress;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public String getCountryIssue() {
    return countryIssue;
  }

  public String getStateIssue() {
    return stateIssue;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LicenseInformation)) {
      return false;
    }
    LicenseInformation that = (LicenseInformation) o;
    return Objects.equals(getLicenseUniqueNumber(), that.getLicenseUniqueNumber()) &&
        Objects.equals(getName(), that.getName())&&
        Objects.equals(getDriverAddress(), that.getDriverAddress()) &&
        Objects.equals(getBirthday(), that.getBirthday()) &&
        Objects.equals(getCountryIssue(), that.getCountryIssue()) &&
        Objects.equals(getStateIssue(), that.getStateIssue()) &&
        Objects.equals(getIssueDate(), that.getIssueDate()) &&
        Objects.equals(getExpirationDate(), that.getExpirationDate());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getLicenseUniqueNumber(), getName(),
            getDriverAddress(),
            getBirthday(), getCountryIssue(), getStateIssue(), getIssueDate(), getExpirationDate());
  }

  @Override
  public String toString() {
    return "LicenseInformation{" +
        "licenseUniqueNumber=" + licenseUniqueNumber +
        ", driverFirstName='" + name + '\'' +
        ", driverAddress='" + driverAddress + '\'' +
        ", birthday=" + birthday +
        ", countryIssue='" + countryIssue + '\'' +
        ", stateIssue='" + stateIssue + '\'' +
        ", issueDate=" + issueDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
