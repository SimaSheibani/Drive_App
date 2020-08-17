package P1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

public class DriverValidator {

    public static final int TWENTY_ONE_YEARS_IN_MONTH = 252;
    public static final int FIFTEEN_YEARS = 15;
    public static final long SIX_MONTH_IN_DAYS = 180;
    private Name applicationName;
    private LocalDate applicationBirthDate;
    private Driver driver;
    private Vehicle vehicle;

    public DriverValidator(Driver driver, Vehicle vehicle, Name applicationName, LocalDate applicationBirthDate) {
        this.driver = driver;
        this.applicationName = applicationName;
        this.applicationBirthDate = applicationBirthDate;
        this.vehicle = vehicle;
    }


    public boolean validateLicenseInformation() {
        return validateAge();
    }

    private boolean validateAge() {
        if (Period.between(LocalDate.now(), this.driver.getDateOfBirth()).toTotalMonths() < TWENTY_ONE_YEARS_IN_MONTH) {
            return false;
        }
        return validateName();
    }

    private boolean validateName() {
        if (!this.applicationName.equals(this.driver.getLicenseInformation().getName().getFirstName())) {
            return false;
        }
        return validateBirthDate();
    }

    private boolean validateBirthDate() {
        if (this.applicationBirthDate.compareTo(this.driver.getLicenseInformation().getBirthDate()) != 0) {
            return false;
        }
        return validateCountryOfIssuance();
    }

    private boolean validateCountryOfIssuance() {
        if (!this.driver.getLicenseInformation().getCountryIssue().equals("US") &&
                !(this.driver.getLicenseInformation().getCountryIssue().equals("Canada"))) {
            return false;
        }
        return validateDateOfIssuance();
    }

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
                if (history.getViolationMoving() != null) {
                    return false;
                } else if (history.getCrash() != null) {
                    return false;
                }
            }
        }
        return true;
    }
}