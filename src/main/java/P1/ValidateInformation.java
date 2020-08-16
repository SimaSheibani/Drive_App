package P1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

public class ValidateInformation {

  public static final int TWENTY_One_YEARS = 21;
  public static final int FIFTEEN_YEARS = 15;
  public static final long SIX_MONTH_IN_DAYS = 180;


  public boolean validationAgeDriver(LocalDate birthday) {
    long age = ChronoUnit.YEARS.between(birthday, LocalDate.now());
    return age > TWENTY_One_YEARS;
  }

  public boolean validationNameDriver(Name name1, Name name2) {
    return (name1.equals(name2));
  }


  public boolean validationBirthdayDriver(LocalDate birthday1, LocalDate birthday2) {
    int diff = birthday1.compareTo(birthday2);
    return diff == 0;
  }

  public boolean validationLicenseState(String  country) {
    return (country.equals("US") || country.equals("Canada"));
  }

  public boolean validationDateOFIssued(LocalDate localDate) {
    long diff = ChronoUnit.DAYS.between(localDate, LocalDate.now());
    return diff > SIX_MONTH_IN_DAYS;
  }

  public boolean validationExpirationDate(LocalDate localDate) {
    long diff = ChronoUnit.DAYS.between(LocalDate.now(), localDate);
    return diff > 0;
  }

  public boolean validationYearVehicle(Integer year) {
    Integer diff = LocalDate.now().getYear() - year;
    return diff > FIFTEEN_YEARS;
  }

  public boolean validationVehicleInsuranceInformation(Name nameDriver, Name nameInsurance,
      List<Name> list) {
    if (nameDriver.equals(nameInsurance)) {
      return true;
    }
    else if (list.contains(nameDriver)) {
        return true;
      }
    return false;
  }
  public boolean validationVehicleInsuranceExpiration(LocalDate date) {
    long diff = ChronoUnit.DAYS.between(LocalDate.now(), date);
    return diff > 0;
  }

  public boolean validationDriverHistory(Map<ViolationMoving, LocalDate> map) {
    if (map == null) {
      return true;
    }
    else if (map.containsKey(ViolationMoving.recklessDriving) ||
        map.containsKey(ViolationMoving.Speeding) ||
        map.containsKey(ViolationMoving.DrivingUnderInfluence) ||
        map.containsKey(ViolationMoving.drivingWithoutValidLicenseOrInsurance)) {
      return false;
    }
    else
      return true;
  }

  public boolean validationVehicleHistory(Map<ViolationMoving, LocalDate> map) {
    if (map == null) {
      return true;
    }
    else
      for(LocalDate date : map.values()) {
        long diff = ChronoUnit.DAYS.between(date, LocalDate.now());
        if (diff < SIX_MONTH_IN_DAYS) {
          return false;
        }
      }
      return true;
  }
}
