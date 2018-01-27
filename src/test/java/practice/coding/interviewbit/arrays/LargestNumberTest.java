package practice.coding.interviewbit.arrays;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.jupiter.api.Test;

class LargestNumberTest {

  @Test
  void largestNumber() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(8);
    a.add(89);
    String sol = new LargestNumber().largestNumber(a);
    String expectedSol = "898";
    Assert.assertEquals(expectedSol, sol);

  }
}
