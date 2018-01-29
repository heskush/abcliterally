package practice.language.sample;

public class Address {
  public int streetNumber;

  public Address(int streetNumber) {
    this.streetNumber = streetNumber;
  }

  @Override
  public String toString() {
    return "Address{" + "streetNumber=" + streetNumber + '}';
  }
}
