package P1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import sun.util.resources.LocaleData;

public class DriverHistory {

  private LocalDate date;
  private ViolationMoving violationMoving;
  private ViolationNonMoving violationNonMoving;
  private Map<ViolationMoving, LocalDate> movingViolationLocalDateMap;
  private Map<ViolationNonMoving, LocalDate> nonMovingViolationLocalDateMap;

  public DriverHistory(LocalDate date) {
    this.violationMoving = null;
    this.violationNonMoving = null;
    this.movingViolationLocalDateMap = new HashMap<>();
    this.nonMovingViolationLocalDateMap = new HashMap<>();
  }

  public Map<ViolationMoving, LocalDate> addMovingViolation(ViolationMoving violation, LocalDate date) {
    this.setViolationMoving(violation);
    this.movingViolationLocalDateMap.put(this.violationMoving, this.date);
    return movingViolationLocalDateMap;
  }
  public Map<ViolationNonMoving, LocalDate> addNonMovingViolation(
      ViolationNonMoving violation, LocalDate date) {
    this.setViolationNonMoving (violation);
    this.nonMovingViolationLocalDateMap.put(this.violationNonMoving, this.date);
    return nonMovingViolationLocalDateMap;
  }

  public LocalDate getDate() {
    return date;
  }

  public ViolationMoving getViolationMoving() {
    return violationMoving;
  }

  public void setViolationMoving(ViolationMoving violationMoving) {
    this.violationMoving = violationMoving;
  }

  public ViolationNonMoving getViolationNonMoving() {
    return violationNonMoving;
  }

  public void setViolationNonMoving(ViolationNonMoving violationNonMoving) {
    this.violationNonMoving = violationNonMoving;
  }

}
