package practice2018.coding.gfg.dp.intermediate;

import practice2018.language.java.util.DemonstrationUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// author -- hemantkumar
public class Miscellaneous {
    /*------------------YELLOW------------------------------
     *https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
     * */
    static class LongestSubstringWithoutRepetition {
        private String stringData;

        public LongestSubstringWithoutRepetition(String stringData) {
            this.stringData = stringData;
        }

        public static LongestSubstringWithoutRepetition initialize(String strData) {
            return new LongestSubstringWithoutRepetition(strData);
        }

        public int solve() {
            int[] dpSolArr = new int[stringData.length()];
            HashSet<Character> visited = new HashSet<>();
            dpSolArr[0] = 1;
            visited.add(stringData.charAt(0));
            int maxLength = 1;
            for (int i = 1; i < stringData.length(); i++) {
                if (visited.contains(stringData.charAt(i))) {
                    visited.clear();
                    dpSolArr[i] = 1;
                } else {
                    visited.add(stringData.charAt(i));
                    dpSolArr[i] = dpSolArr[i - 1] + 1;
                }
                if (maxLength < dpSolArr[i]) {
                    maxLength = dpSolArr[i];
                }
            }
            return maxLength;
        }


        public static void demonstrate(String str) {
            System.out.println("LongestSubstringWithoutRepetition.demonstrate");
            System.out.println(String.format("Solution for string %s is %d", str, LongestSubstringWithoutRepetition.initialize(str).solve()));
            DemonstrationUtil.terminate();


        }

    }

    /* ------------------------YELLOW----------------------------------------------------
     * https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
     *
     * */

    static class PartitionSetIntoTwoWithMinimumSumDifference {
        static int[] setArr = {3, 1, 4, 2, 2, 1};

        private static int execute(int[] setArr) {
            SumSet set1 = new SumSet(setArr[0]);
            SumSet set2 = new SumSet(setArr[1]);
            for (int i = 2; i < setArr.length; i++) {
                SumSet s;
                s = set1.sum < set2.sum ? set1 : set2;
                s.set.add(setArr[i]);
                s.sum = s.sum + setArr[i];
            }
            return Math.abs(set1.sum - set2.sum);

        }

        public static void demonstrate() {
            System.out.println("PartitionSetIntoTwoWithMinimumSumDifference.demonstrate");
            System.out.println(String.format("Minimum sum difference sets for set %s  have sum %d", Arrays.toString(setArr), execute(setArr)));
            DemonstrationUtil.terminate();
        }

        static class SumSet {
            int sum;
            Set<Integer> set;

            public SumSet(int sum) {
                this.sum = sum;
                this.set = new HashSet<>();
                set.add(sum);
            }
        }


    }


    public static int longestPalindromicSubsequence(String str) {
        int n = str.length();
        int[][] dpSolArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dpSolArr[i][j] = 1;
                    continue;
                }
                if (Math.abs(i - j) == 1) {
                    dpSolArr[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 0;
                    continue;
                }
                dpSolArr[i][j] = 0;
            }
        }


        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 2; j < n; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dpSolArr[i][j] = 2 + dpSolArr[i + 1][j - 1];
                    continue;
                }
                dpSolArr[i][j] = Math.max(dpSolArr[i + 1][j], dpSolArr[i][j - 1]);

            }

        }

        return dpSolArr[0][n - 1];

    }


    public static void main(String[] args) {

        System.out.println(String.format("Longest palidromic sub sequence for string %s is %d", "GEEKSFORGEEKS", longestPalindromicSubsequence("GEEKSFORGEEKS")));
        PartitionSetIntoTwoWithMinimumSumDifference.demonstrate();


    }
}

