package P1;

import java.util.Objects;

/**
 * Represent name class. This class includes first name and last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Creat a new Name. It contains first name and last name.
   * @param firstName - first name of Name
   * @param lastName - last name of Name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Return the first name
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Return the last name
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) &&
            Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
