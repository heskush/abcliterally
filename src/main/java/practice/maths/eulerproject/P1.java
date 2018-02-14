package practice.maths.eulerproject;

// author -- hemantkumar
public class P1 {
  /*
   * https://projecteuler.net/problem=1
   *
   * Essentially there are three APs, AP1 for the multiples of three, AP2 for the multiple of 5 and AP3 for the multiples of 15.
   * The answer is AP1+AP2-AP3
   */

  public static long sumMultiplesOfThreeAndFive(long maxMultiple) {
    long a1 = 3;
    long d1 = 3;
    long n1 = (maxMultiple / a1);
    long a2 = 5;
    long d2 = 5;
    long n2 = (maxMultiple / a2);
    long a3 = 15;
    long d3 = 15;
    long n3 = (maxMultiple / a3);

    long sum1 = (n1 * (2 * a1 + (n1 - 1) * d1)) / 2;
    long sum2 = (n2 * (2 * a2 + (n2 - 1) * d2)) / 2;
    long sum3 = (n3 * (2 * a3 + (n3 - 1) * d3)) / 2;

    return sum1 + sum2 - sum3;

  }

  public static void main(String[] args) {
    long sum = sumMultiplesOfThreeAndFive(999L);
    System.out.println(sum);
  }
}
