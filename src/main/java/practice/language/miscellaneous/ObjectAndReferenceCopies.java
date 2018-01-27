package practice.language.miscellaneous;

// author -- hemantkumar

/**
 * @author hemantkumar Copies can be of three types: 1. Reference Copies 2. ShallowCopy 3. DeepCopy . Last two are types of object
 *         copies.
 *
 *
 */
public class ObjectAndReferenceCopies {
  public static void main(String[] args) {
    demonstrateReferenceCopy();
    demonstrateShallowCopy();
    demonstrateDeepCopy();

  }

  public static void demonstrateReferenceCopy() {
    Address oldReference = new Address(123456);
    Person person = new Person(999, oldReference);
    System.out.println("ObjectAndReferenceCopies.demonstrateReferenceCopy");
    System.out.printf("oldReference: %s %n", oldReference);
    Address newReference = oldReference; // This is a reference copy. Any change done in oldReference, would be reflected in
                                         // newReference
    System.out.printf("oldReference.equals(newReference) : %s%n", oldReference.equals(newReference));
    System.out.printf("oldReference==newReference : %s%n", oldReference == newReference);
    terminate();

  }

  /**
   * A deep copy copies the entire object and it's nested objects until only primitives and Immutables are left. Primtives can't
   * be shared and immutables(e.g. string) can't be changed so there is no issue in having a reference copy of them. Java doesn't
   * provide proper framework to make deep copies of objects (as per 'Effective Java by Joshua Bloch', clone method is highly
   * error prone and should be avoided) but a deep copy can be made by serializing and then deserializing an object.
   * 
   */

  public static void demonstrateDeepCopy() {
    System.out.println("ObjectAndReferenceCopies.demonstrateDeepCopy");
    Address address = new Address(123456);
    Person personOriginal = new Person(999, address);
    System.out.printf("personOriginal : %s%n", personOriginal);
    Person personCopy = personOriginal.deepCopy();
    System.out.printf("personCopy : %s%n", personCopy);
    System.out.printf("personOriginal==personCopy : %s%n", personOriginal == personCopy);
    System.out.printf("personOriginal.address==personCopy.address : %s%n", personOriginal.address == personCopy.address);
    System.out.printf("personOriginal.equals(personCopy) : %s%n", personOriginal.equals(personCopy));
    System.out.printf("personOriginal.address.equals(personCopy.address : %s%n",
        personOriginal.address.equals(personCopy.address));

    terminate();

  }

  /**
   * A shallow copy of an object copies the main object, but doesn’t copy the inner objects. The inner objects are shared between
   * the original object and its copy. Most of object copies done in java are usually shallow copies unless stated otherwise. For
   * e.g. System.arrayCopy() method makes shallow copies of the array passed.
   */
  public static void demonstrateShallowCopy() {
    System.out.println("ObjectAndReferenceCopies.demonstrateShallowCopy");
    Address address = new Address(123456);
    Person personOriginal = new Person(999, address);
    System.out.printf("personOriginal : %s%n", personOriginal);
    Person personCopy = personOriginal.shallowCopy();
    System.out.printf("personCopy : %s%n", personCopy);
    System.out.printf("personOriginal==personCopy : %s%n", personOriginal == personCopy);
    System.out.printf("personOriginal.address==personCopy.address : %s%n", personOriginal.address == personCopy.address);
    System.out.printf("personOriginal.equals(personCopy) : %s%n", personOriginal.equals(personCopy));
    System.out.printf("personOriginal.address.equals(personCopy.address : %s%n",
        personOriginal.address.equals(personCopy.address));

    terminate();

  }

  public static void terminate() {
    System.out.println("----------------------------------------------------");
  }

}

class Person {
  int val;
  Address address;

  public Person(int val, Address address) {
    this.val = val;
    this.address = address;
  }

  public Person shallowCopy() {
    Person personShallow = new Person(this.val, this.address);
    return personShallow;

  }

  public Person deepCopy() {
    Person personDeep = new Person(this.val, new Address(this.address.streetNumber));
    return personDeep;
  }

  @Override
  public String toString() {
    return "Person{" + "val=" + val + ", address=" + address + '}';
  }
}

class Address {
  int streetNumber;

  public Address(int streetNumber) {
    this.streetNumber = streetNumber;
  }

  @Override
  public String toString() {
    return "Address{" + "streetNumber=" + streetNumber + '}';
  }
}
