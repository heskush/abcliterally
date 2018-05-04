package practice.coding.hr.algorithms.dynamicprogramming;

import java.util.Arrays;

// author -- hemantkumar
/*
 * https://www.hackerrank.com/challenges/coin-change/problem
 *
 * Passed all test cases.
 *
 * */
public class CoinChangeProblem {


    static class Solution {
        /*
         *The recursive relation would be  ways(n,m)=ways(n,m-1) + ways(n-1*val[m],m-1)+ways(n-2*val[m],m-1)
         * + ways(n-3*val[m],m-1)........for all 'i' such that n-i*val[m] >=0
         *
         * Corner Cases:
         * if the unit 'n' is 0:
         * if types of coins 'm' is 0:
         *
         *
         * */
        static long getWays(long n, long[] c) {
            Arrays.sort(c);
//            Row represents value and column represents the number of coins available in increasing order of value

            long[][] dpSolArr = new long[(int) n + 1][c.length + 1];
            for (int units = 0; units <= (int) n; units++) {
                for (int coins = 0; coins <= c.length; coins++) {
                    if (units == 0 && coins == 0) {
                        dpSolArr[units][coins] = 1;
                        continue;
                    }
                    //Sum left but no coins left
                    if (units != 0 && coins == 0) {
                        dpSolArr[units][coins] = 0;
                        continue;
                    }
//                    Sum must have been obtained zero after subtracting a multiple of a higher coins value.
                    if (units == 0 && coins != 0) {
                        dpSolArr[units][coins] = 1;
                        continue;
                    }
                    dpSolArr[units][coins] = 0;
                    long val = 0;
                    int i = 1;
                    long coinVal = c[coins - 1];
                    while (units - i * coinVal >= 0) {
                        val = val + dpSolArr[(int) (units - i * coinVal)][coins - 1];
                        i++;
                    }
                    dpSolArr[units][coins] = dpSolArr[units][coins - 1] + val;


                }
            }
            return dpSolArr[(int) n][c.length];


        }


    }

    public static void main(String[] args) {
        System.out.println(Solution.getWays(4, new long[]{1L, 2L, 3L}));
    }
}
