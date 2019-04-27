package practice2018.coding.gfg.dp.hard;

// author -- hemantkumar
public class Classics {

    /*
     * https://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
     * */

    static class PalindromePartitioning {


        public static int execute(String s) {
            int n = s.length();
            int[][] dpSolArr = new int[n][n];

            //For a string with one element there is no cut needed/
            for (int i = 0; i < n; i++) {
                dpSolArr[i][i] = 0;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j - 1) {
                        dpSolArr[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
                    } else {
                        int globalMinCuts = Integer.MAX_VALUE;
                        int currentMinCuts;
                        for (int k = i; k < j; k++) {
                            currentMinCuts = dpSolArr[i][k] + 1 + dpSolArr[k + 1][j];
                            globalMinCuts = currentMinCuts < globalMinCuts ? currentMinCuts : globalMinCuts;
                        }
                    }
                }
            }


            return 1;
        }


    }
}
