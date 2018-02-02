package practice.language.java.collectionsframework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import practice.language.java.sample.Person;

// author -- hemantkumar

/**
 * All examples from https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 */
public class StreamAPI {
  public static void main(String[] args) {
    List<Person> personList = Person.generateCollection(100);
    personList.forEach(System.out::println);
    personList.sort(Comparator.comparing(Person::getVal));
    System.out.println();
    personList.forEach(System.out::println);

    List<String> singletonList = Collections.singletonList("123");
    singletonList.add("129");
  }
}
