package practice2018.coding.gfg.dp;

import practice2018.language.java.util.DemonstrationUtil;

import java.io.IOException;
import java.util.Arrays;

// author -- hemantkumar
public class Basics {


    static class LongestCommonSubSequence {
        static String s1 = "AGGTAB";
        static String s2 = "GXTXAYB";
        static int[][] table = new int[s1.length() + 1][s2.length() + 1];

        static {
            for (int i = 0; i < s1.length() + 1; i++) {
                for (int j = 0; j < s2.length() + 1; j++) {
                    if (i == 0 || j == 0) {
                        table[i][j] = 0;
                    } else {
                        table[i][j] = -1;
                    }
                }

            }

        }


        public static int execute() {
            return getLcs(s1.length(), s2.length());
        }

        private static int getLcs(int m, int n) {
            if (table[m][n] != -1) {
                return table[m][n];
            } else {
                if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                    return 1 + getLcs(m - 1, n - 1);
                } else {
                    return Math.max(getLcs(m, n - 1), getLcs(m - 1, n));
                }
            }
        }

    }


    static class LongestRepeatingSubSequence {


    }

    /*
     * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
     *-----------------------------RED-------------------------------------------
     * KADANE's ALOGORITHM : This is unique in the sense that it belongs to the DP paradigm but it still has a complexity
     * of just O(N)
     * */
    public static void MaximumSumContiguousArray(int[] arr) {
        int maxSum = 0;
        int sumCurrent = 0;
        for (int i : arr) {
            sumCurrent = sumCurrent + i;
            if (sumCurrent < 0) {
                sumCurrent = 0;
            }
            if (maxSum < sumCurrent) {
                maxSum = sumCurrent;
            }

        }
        System.out.println("Basics.MaximumSumContiguousArray");
        System.out.println(" Maximum Sum Contiguous Array is " + maxSum);
        DemonstrationUtil.terminate();
    }

    /*
     * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
     *
     * ------------------------------------RED----------------------------------------
     *
     * */


    public static void maximumSizeSquareSubMatrixWithOnes() {
        int[][] arr = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] auxArr = new int[rows][cols];
        int maxRow = 0;
        int maxCol = 0;
        int maxVal = 0;
        for (int i = 0; i < cols; i++) {
            auxArr[0][i] = arr[0][i];
        }
        for (int i = 0; i < rows; i++) {
            auxArr[i][0] = arr[i][0];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] == 0) {
                    auxArr[i][j] = 0;
                } else {
                    auxArr[i][j] = Math.min(Math.min(auxArr[i - 1][j - 1], auxArr[i - 1][j]), auxArr[i][j - 1]) + 1;
                    if (maxVal < auxArr[i][j]) {
                        maxVal = auxArr[i][j];
                        maxRow = i;
                        maxCol = j;
                    }
                }
            }
        }

        System.out.println("Basics.maximumSizeSquareSubMatrixWithOnes");
        System.out.println("The max size of square sub-matrix is ");

        int topRow = maxRow - maxVal + 1;
        int leftCol = maxCol - maxVal + 1;
        for (int i = topRow; i <= maxRow; i++) {
            for (int j = leftCol; j <= maxCol; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        DemonstrationUtil.terminate();


    }

//    TODO: Implement the O(NlogN) solutions that makes use of patience sort

    public static void longestIncreasingSubsequence() {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int[] dynamicSolArr = new int[arr.length];
        Arrays.fill(dynamicSolArr, 1);
        for (int i = 1; i < arr.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dynamicSolArr[j] > maxVal) {
                    maxVal = dynamicSolArr[j];
                }
            }
            dynamicSolArr[i] = maxVal + 1;
        }
        System.out.println("Basics.longestIncreasingSubsequence");
        System.out.println("The maximum increaisng subsequence length is " + Arrays.stream(dynamicSolArr).max().getAsInt());
        DemonstrationUtil.terminate();

    }

    public static void minimumCostPath() {
        int[][] costArr =
                {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};
        int[][] dpSolArr = new int[costArr.length][costArr[0].length];
        for (int i = 0; i < costArr[0].length; i++) {
            dpSolArr[0][i] = costArr[0][i] + ((i != 0) ? dpSolArr[0][i - 1] : 0);
        }
        for (int i = 0; i < costArr.length; i++) {
            dpSolArr[i][0] = costArr[i][0] + (i != 0 ? dpSolArr[i - 1][0] : 0);
        }
        for (int i = 1; i < costArr.length; i++) {
            for (int j = 1; j < costArr[0].length; j++) {
                dpSolArr[i][j] = Math.min(Math.min(dpSolArr[i - 1][j - 1], dpSolArr[i - 1][j]), dpSolArr[i][j - 1]) + costArr[i][j];
            }

        }

        System.out.println("Basics.minimumCostPath");
        System.out.println(String.format("Minimum cost path for position (%d,%d) is %d", 2, 2, dpSolArr[2][2]));
        DemonstrationUtil.terminate();
    }


    static class CoinChangeProblem {
        static int[] coinsArr = {1, 2, 3};
        static int sumWanted = 12;
        //Assuming all coins are of denomination less than the total sum wanted.
        static int[][] dpSolArr = new int[sumWanted + 1][coinsArr.length];

        public static void fillSolArr() {
            for (int i = 0; i < coinsArr.length; i++) {
                for (int j = 0; j < sumWanted + 1; j++) {
                    int coinVal = coinsArr[i];
                    if (j == 0) {
                        dpSolArr[i][j] = 1;
                    } else {
                        if (coinVal > j) {
                            dpSolArr[i][j] = dpSolArr[i - 1][j];
                        } else {

                        }
                    }

                }

            }


        }


    }


    public static void main(String[] args) throws IOException {
//        maximumSizeSquareSubMatrixWithOnes();
//        longestIncreasingSubsequence();
        minimumCostPath();

    }
}
