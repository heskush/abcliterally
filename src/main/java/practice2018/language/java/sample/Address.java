package practice2018.language.java.sample;

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
