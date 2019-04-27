package practice2018.maths.eulerproject;

import practice2018.language.java.util.DemonstrationUtil;

// author -- hemantkumar
public class Solutions {

  /*
   * https://projecteuler.net/problem=2
   *
   * There is no trick to the question, one needs to iterate over all the fibonacci number less than 4 mil. and sum even ones. But
   * from a programming perspective, one should think whether the sum can be fit in a int or even a long?
   */
  static class P2 {
    public static int execute() {
      int x = 0;
      int y = 1;
      int z = 0;
      int sum = 0;
      while (y < 4000000) {
        z = x + y;
        if (z % 2 == 0) {
          sum = sum + z;
        }
        x = y;
        y = z;

      }
      return sum;
    }

    public static void demonstrate() {
      System.out.println("P2.demonstrate");
      int sum = execute();
      System.out.println(sum);
      DemonstrationUtil.terminate();

    }

  }

  public static void main(String[] args) {
    P2.demonstrate();
  }

}
