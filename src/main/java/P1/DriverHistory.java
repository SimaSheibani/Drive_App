package P1;

import java.time.LocalDate;

/**
 * Represent a DriverHistory. Driver history contains a date, violationMoving and
 * violationNonMoving
 */
public class DriverHistory {

  private LocalDate date;
  private ViolationMoving violationMoving = null;
  private ViolationNonMoving violationNonMoving = null;

  /**
   * creat a new DriverHistory, based on violation moving and date
   * @param violationMoving - violation moving
   * @param date - date of violation
   */
  public DriverHistory(ViolationMoving violationMoving, LocalDate date) {
    this.violationMoving = violationMoving;
    this.date = date;
  }

  /**
   * creat a new DriverHistory, based on violation non moving and date
   * @param violationNonMoving - violation non moving
   * @param date - date of violation
   */
  public DriverHistory(ViolationNonMoving violationNonMoving, LocalDate date) {
    this.violationNonMoving = violationNonMoving;
    this.date = date;
  }

  /**
   * Return the date of violation
   * @return the date of violation
   */
  public LocalDate getDate() {
    return this.date;
  }

  /**
   * Return the violation moving
   * @return the violation moving
   */
  public ViolationMoving getViolationMoving() {
    return this.violationMoving;
  }

  /**
   * Return the violation non moving
   * @return the violation non moving
   */
  public ViolationNonMoving getViolationNonMoving() {
    return this.violationNonMoving;
  }


}
