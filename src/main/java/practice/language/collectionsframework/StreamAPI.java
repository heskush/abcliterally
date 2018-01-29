package practice.language.collectionsframework;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import practice.language.sample.Person;

// author -- hemantkumar
public class StreamAPI {
  public static void main(String[] args) {
    List<Person> personList = Person.generateCollection(1);
    System.out.println(Arrays.toString(personList.toArray()));
    Person p = personList.get(0);

    Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getVal));
    personList.get(0).val = 12345;
    Person x = personList.get(0);
    // collect.values().forEach(x -> System.out.println(x));

    System.out.println("yoo");

  }
}
