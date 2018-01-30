package practice.language.collectionsframework;

// author -- hemantkumar

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import practice.language.sample.Person;
import practice.language.util.DemonstrationUtil;

/**
 * This is not a proper overview of the collections framework but rather a demonstration of some of the more subtle aspects of the
 * different operations available in the collection interface and it's provided implementations. For a comprehensive introduction
 * go to : https://docs.oracle.com/javase/tutorial/collections/index.html
 */
public class CollectionsAPI {

  public static void main(String[] args) {
    demonstrateToArray();
    demostrateToArrayV2();

  }

  /**
   * The toArray() function give a newly created array that has REFERENCE COPIES of the object elements in the collection.
   */
  public static void demonstrateToArray() {
    System.out.println("CollectionsAPI.demonstrateToArray");
    List<Person> personCollection = new ArrayList<>();
    personCollection.add(Person.getSamplePerson1());

    Object[] personArray = personCollection.toArray();
    System.out.printf("personArray[0]==personCollection.get(0) : %s%n", personArray[0] == personCollection.get(0));
    DemonstrationUtil.terminate();
  }

  /**
   * toArray(T[] arr) works like the previous version expect for the fact that it type cast the collection elements to the type of
   * the array passed. If the collections fits inside the array then the same array is used otherwise a new array is created. If
   * the the size of the array is more then the remaining elements are filled with null.
   */
  public static void demostrateToArrayV2() {
    System.out.println("CollectionsAPI.demostrateToArrayV2");
    Collection<Person> personCollection = new ArrayList<>();
    personCollection.add(Person.getSamplePerson1());
    personCollection.add(Person.getSamplePerson2());

    Person[] personArr1 = new Person[1];
    Person[] personArr2 = new Person[2];
    System.out.printf("personArr1==personCollection.toArray(personArr1) : %s%n",
        personArr1 == personCollection.toArray(personArr1));
    System.out.printf("personArr2==personCollection.toArray(personArr2) : %s%n",
        personArr2 == personCollection.toArray(personArr2));
    DemonstrationUtil.terminate();

  }

}
