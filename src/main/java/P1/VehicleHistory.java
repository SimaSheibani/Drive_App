package P1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class VehicleHistory {

  private Name nameOffendingDriver;
  private LocalDate date;
  private Crash crash;
  private ViolationMoving violationMoving;
  private ViolationNonMoving violationNonMoving;
  private Map<Crash, LocalDate> crashMap;
  private Map<ViolationMoving, LocalDate> violationMovingMap;
  private Map<ViolationNonMoving, LocalDate> violationNonMovingLocalDateMap;

  public VehicleHistory(Name nameOffendingDriver,
      LocalDate date) {
    this.nameOffendingDriver = nameOffendingDriver;
    this.date = date;
    this.crash = null;
    this.violationMoving = null;
    this.violationNonMoving = null;
    this.crashMap = new HashMap<>();
    this.violationMovingMap = new HashMap<>();
    this.violationNonMovingLocalDateMap = new HashMap<>();
  }

  public Name getNameOffendingDriver() {
    return this.nameOffendingDriver;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setCrash(Crash crash) {
    this.crash = crash;
  }

  public void setViolationMoving(ViolationMoving violationMoving) {
    this.violationMoving = violationMoving;
  }

  public void setViolationNonMoving(ViolationNonMoving violationNonMoving) {
    this.violationNonMoving = violationNonMoving;
  }

  public Map<ViolationMoving, LocalDate> addMovingViolation(ViolationMoving violation, LocalDate date) {
    this.setViolationMoving(violation);
    this.violationMovingMap.put(this.violationMoving, this.date);
    return violationMovingMap;
  }
  public Map<ViolationNonMoving, LocalDate> addNonMovingViolation(
      ViolationNonMoving violation, LocalDate date) {
    this.setViolationNonMoving (violation);
    this.violationNonMovingLocalDateMap.put(this.violationNonMoving, this.date);
    return violationNonMovingLocalDateMap;
  }
  public Map<Crash, LocalDate> addCrashViolation(Crash crash, LocalDate date) {
    this.setCrash(crash);
    this.crashMap.put(this.crash, date);
    return crashMap;
  }

}
