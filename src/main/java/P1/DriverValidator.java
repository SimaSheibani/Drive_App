package P1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

/**
 * Represent the validator class. It contains application name, application birthday, driver and
 * vehicle
 */
public class DriverValidator {

    public static final int TWENTY_ONE_YEARS_IN_MONTH = 252;
    public static final int FIFTEEN_YEARS = 15;
    public static final long SIX_MONTH_IN_DAYS = 180;
    private Name applicationName;
    private LocalDate applicationBirthDate;
    private Driver driver;
    private Vehicle vehicle;

    /**
     * Create a new Driver validator, based upon all af the provided input parameter
     * @param driver - driver information
     * @param vehicle - vehicle information
     * @param applicationName - the name in the application
     * @param applicationBirthDate - the birthday in the application
     */
    public DriverValidator(Driver driver, Vehicle vehicle, Name applicationName, LocalDate applicationBirthDate) {
        this.driver = driver;
        this.applicationName = applicationName;
        this.applicationBirthDate = applicationBirthDate;
        this.vehicle = vehicle;
    }

    /**
     * This method is using the chain of responsibilities, it check if the driver can add to the
     * pool of driver or not
     * @return true if the driver is valid to add to the pool and return false other wise.
     */
    public boolean validateLicenseInformation() {
        return validateAge();
    }

    /**
     * Return true if the age is more than 21 years old, and return false if it is less than 21
     * years old.
     * @return true if the age is more than 21 years old, and return false if it is less than 21
     * years old.
     */
    private boolean validateAge() {
        if (Period.between(LocalDate.now(), this.driver.getDateOfBirth()).toTotalMonths() < TWENTY_ONE_YEARS_IN_MONTH) {
            return false;
        }
        return validateName();
    }

    /**
     * Return true if the name of driver in License is the same as application
     * @return true if the name of driver in License is the same as application
     */
    private boolean validateName() {
        if (!this.applicationName.equals(this.driver.getLicenseInformation().getName().getFirstName())) {
            return false;
        }
        return validateBirthDate();
    }

    /**
     * Return true if the dat of birth of driver in License is the same as application
     * @return true if the dat of birth of driver in License is the same as application
     */
    private boolean validateBirthDate() {
        if (this.applicationBirthDate.compareTo(this.driver.getLicenseInformation().getBirthDate()) != 0) {
            return false;
        }
        return validateCountryOfIssuance();
    }

    /**
     * Return true if the country of driver license issued is US or Canada
     * @return true if he country of driver license issued is US or Canada
     */
    private boolean validateCountryOfIssuance() {
        if (!this.driver.getLicenseInformation().getCountryIssue().equals("US") &&
                !(this.driver.getLicenseInformation().getCountryIssue().equals("Canada"))) {
            return false;
        }
        return validateDateOfIssuance();
    }

    /**
     * Return true if the driver license issued more than 6 months
     * @return true if the driver license issued more than 6 months
     */
    private boolean validateDateOfIssuance() {
        if (Period.between(LocalDate.now(), this.driver.getLicenseInformation().getIssueDate()).getDays() > SIX_MONTH_IN_DAYS) {
            return false;
        }
        return validateExpirationDate();
    }


    private boolean validateExpirationDate() {
        if (this.driver.getLicenseInformation().getExpirationDate().compareTo(LocalDate.now()) < 0) {
            return false;
        }
        return validateVehicleAge();
    }
    /**
     * Return true if the age of vehicle is less than 15 years
     * @return true if the age of vehicle is less than 15 years
     */
    private boolean validateVehicleAge() {
        if (LocalDate.now().getYear() - this.vehicle.getYear() > FIFTEEN_YEARS) {
            return false;
        }
        return validateOfficialOwnerOfVehicle();
    }

    private boolean validateOfficialOwnerOfVehicle() {
        if (!(this.driver.getLicenseInformation().getLicenseUniqueNumber().equals(this.vehicle.getDriverLicenseUniqueNumber()))) {
            boolean check = false;
            for (Map<String, String> map : this.vehicle.getInsuranceInfo().getOtherPeopleCovered()) {
                if (this.driver.getLicenseInformation().getLicenseUniqueNumber().equals(map.get("License Unique Number"))) {
                    check = true;
                }
            }
            if (check == false) {
                return false;
            }
        }
        return validateInsuranceExpirationDate();
    }

    private boolean validateInsuranceExpirationDate() {
        if (this.vehicle.getInsuranceInfo().getExpirationDate().compareTo(LocalDate.now()) < 0) {
            return false;
        }
        return validateDriverViolations();
    }

    private boolean validateDriverViolations() {

        if (!this.driver.getDriverHistories().isEmpty()) {
            for (DriverHistory history : this.driver.getDriverHistories()) {
                if (history.getViolationMoving() != null) {
                    if (history.getViolationMoving().isRecklessDriving()) {
                        return false;
                    } else if (history.getViolationMoving().isSpeeding()) {
                        return false;
                    } else if (history.getViolationMoving().isDUI()) {
                        return false;
                    } else if (history.getViolationMoving().isDrivingWithoutValidLicenseOrInsurance()) {
                        return false;
                    }
                }
            }
        }
        return validateVehicleHistory();
    }

    private boolean validateVehicleHistory() {
        if (!this.vehicle.getVehicleHistories().isEmpty()) {
            for (VehicleHistory history : this.vehicle.getVehicleHistories()) {
                if (history.getViolationMoving() != null &&
                        Period.between(LocalDate.now(), history.getDate()).getDays() < SIX_MONTH_IN_DAYS) {
                    return false;
                } else if (history.getCrash() != null &&
                        Period.between(LocalDate.now(), history.getDate()).getDays() < SIX_MONTH_IN_DAYS) {
                    return false;
                }
            }
        }
        return true;
    }
}