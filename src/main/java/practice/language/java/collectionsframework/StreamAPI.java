package practice.language.java.collectionsframework;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import practice.language.java.sample.Person;

// author -- hemantkumar

/**
 * All examples from https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 */
public class StreamAPI {
  public static void main(String[] args) {
    List<Person> personList = Person.generateCollection(100);
    Arrays.stream(new Integer[] { 1, 2 }).collect(Collectors.toList());

  }
}
