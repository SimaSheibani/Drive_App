package P1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represent LicenseInformation class. A LicenseInformation contains
 * information about the Driver license, including licenseUniqueNumber, driverName, driverAddress,
 * driverBirthDay, countryIssue, stateIssue, issueDate, expirationDate.
 */
public class LicenseInformation {

  private String licenseUniqueNumber;
  private Name name;
  private String driverAddress;
  private LocalDate birthDate;
  private String countryIssue;
  private String stateIssue;
  private LocalDate issueDate;
  private LocalDate expirationDate;

  /**
   * Make a new licenseInformation, based upon all of the provided input parameters.
   * @param licenseUniqueNumber - information about the a license unique number
   * @param name - driver's name
   * @param driverAddress - driver's address
   * @param birthDate - driver's birthday
   * @param countryIssue - country issuance
   * @param stateIssue - state of issuance
   * @param issueDate - date of issue
   * @param expirationDate - expiration date
   */
  public LicenseInformation(String licenseUniqueNumber, Name name,
                            String driverAddress, LocalDate birthDate, String countryIssue,
                            String stateIssue, LocalDate issueDate, LocalDate expirationDate) {
    this.licenseUniqueNumber = licenseUniqueNumber;
    this.name = name;
    this.driverAddress = driverAddress;
    this.birthDate = birthDate;
    this.countryIssue = countryIssue;
    this.stateIssue = stateIssue;
    this.issueDate = issueDate;
    this.expirationDate = expirationDate;
  }

  /**
   * An String representing the alphanumeric unique license number.
   * @return the license unique number
   */
  public String getLicenseUniqueNumber() {
    return licenseUniqueNumber;
  }

  /**
   * Return the name
   * @return the name
   */
  public Name getName() { return name;}

  /**
   * Return the driver address
   * @return the driver address
   */
  public String getDriverAddress() {
    return driverAddress;
  }

  /**
   * Return the birth date of driver
   * @return the birth date of driver
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * Return the country which license issued
   * @return the country which license issued
   */
  public String getCountryIssue() {
    return countryIssue;
  }

  /**
   * Return the state of license
   * @return the state of license
   */
  public String getStateIssue() {
    return stateIssue;
  }

  /**
   * Return the issue date of license
   * @return the issue date of license
   */
  public LocalDate getIssueDate() {
    return issueDate;
  }

  /**
   * Return the expiration date of license
   * @return the expiration date of license
   */
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
        Objects.equals(getBirthDate(), that.getBirthDate()) &&
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
            getBirthDate(), getCountryIssue(), getStateIssue(), getIssueDate(), getExpirationDate());
  }

  @Override
  public String toString() {
    return "LicenseInformation{" +
        "licenseUniqueNumber=" + licenseUniqueNumber +
        ", driverFirstName='" + name + '\'' +
        ", driverAddress='" + driverAddress + '\'' +
        ", birthday=" + birthDate +
        ", countryIssue='" + countryIssue + '\'' +
        ", stateIssue='" + stateIssue + '\'' +
        ", issueDate=" + issueDate +
        ", expirationDate=" + expirationDate +
        '}';
  }
}
