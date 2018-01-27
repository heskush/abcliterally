package practice.coding.interviewbit.arrays;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// author -- hemantkumar

/**
 * https://www.interviewbit.com/problems/largest-number/ Given a list of non negative integers, arrange them such that they form
 * the largest number.
 * 
 * 
 */
public class LargestNumber {
  public String largestNumber(final List<Integer> a) {
    List<String> stringNumbers = a.stream().map(x -> x.toString()).collect(Collectors.toList());
    stringNumbers.sort(Collections.reverseOrder(String::compareTo));
    return stringNumbers.stream().reduce("", String::concat);

  }

}
