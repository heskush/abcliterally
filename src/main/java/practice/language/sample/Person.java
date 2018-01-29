package practice.language.sample;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
  public int val;
  public Address address;

  private static Person samplePerson1 = new Person(999, new Address(919));
  private static Person samplePerson2 = new Person(888, new Address(818));

  public Person(int val, Address address) {
    this.val = val;
    this.address = address;
  }

  public int getVal() {
    return val;
  }

  public Address getAddress() {
    return address;
  }

  public Person shallowCopy() {
    Person personShallow = new Person(this.val, this.address);
    return personShallow;

  }

  public Person deepCopy() {
    Person personDeep = new Person(this.val, new Address(this.address.streetNumber));
    return personDeep;
  }

  public static Person getSamplePerson1() {
    return samplePerson1;
  }

  public static Person getSamplePerson2() {
    return samplePerson2;
  }

  public static List<Person> generateCollection(int size) {
    return IntStream.rangeClosed(1, size).mapToObj(x -> new Person(ThreadLocalRandom.current().nextInt(1, size + 1),
        new Address(ThreadLocalRandom.current().nextInt(1, size + 1)))).collect(Collectors.toList());

  }

  @Override
  public String toString() {
    return "Person{" + "val=" + val + ", address=" + address + '}';
  }
}
