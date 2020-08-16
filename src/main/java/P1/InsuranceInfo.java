package P1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsuranceInfo {

  protected Name name;
  protected LocalDate expirationDate;
  protected List<String> otherPeopleCovered;

  public InsuranceInfo(Name name, LocalDate expirationDate) {
    this.name = name;
    this.expirationDate = expirationDate;
    this.otherPeopleCovered = new ArrayList<>();
  }

  public Name getName() {
    return name;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setOtherPeopleCovered(List<String> otherPeopleCovered) {
    this.otherPeopleCovered = otherPeopleCovered;
  }


}

