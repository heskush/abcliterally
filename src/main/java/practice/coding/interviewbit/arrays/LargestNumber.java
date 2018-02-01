package practice.coding.interviewbit.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// author -- hemantkumar

/**
 * https://www.interviewbit.com/problems/largest-number/
 *
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * 
 */
public class LargestNumber {
  public String largestNumber(final List<Integer> a) {
    List<String> stringNumbers = a.stream().map(Object::toString).collect(Collectors.toList());
    Collections.sort(stringNumbers, Collections.reverseOrder((s1, s2) -> {
      if (s1.charAt(0) != s2.charAt(0)) {
        return s1.compareTo(s2);
      }
      // if(){
      // return
      // }
      return (s1 + s2).compareTo((s2 + s1));
    }));
    String val = stringNumbers.stream().reduce("", String::concat);
    return val.indexOf("0") == 0 ? "0" : val;

  }

  public static void main(String[] args) {
    LargestNumber largestNumber = new LargestNumber();
    List<Integer> integers = Arrays.asList(0, 0, 0, 0);
    String s = largestNumber.largestNumber(integers);
    System.out.println(s);
    System.out.println("34".compareTo("341"));

  }

}
