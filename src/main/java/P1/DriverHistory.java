package P1;

import java.time.LocalDate;

public class DriverHistory {

  private LocalDate date;
  private ViolationMoving violationMoving = null;
  private ViolationNonMoving violationNonMoving = null;

  public DriverHistory(ViolationMoving violationMoving, LocalDate date) {
    this.violationMoving = violationMoving;
    this.date = date;
  }

  public DriverHistory(ViolationNonMoving violationNonMoving, LocalDate date) {
    this.violationNonMoving = violationNonMoving;
    this.date = date;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public ViolationMoving getViolationMoving() {
    return this.violationMoving;
  }

  public ViolationNonMoving getViolationNonMoving() {
    return this.violationNonMoving;
  }


}
