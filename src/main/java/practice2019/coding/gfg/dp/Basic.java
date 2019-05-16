package practice2019.coding.gfg.dp;

public class Basic {
    public static void main(String[] args) {
        LongestCommonSubsequence("ABCDGH", "AEDFHR");
        LongestCommonSubsequence("AGGTAB", "GXTXAYB");
    }


    public static void LongestCommonSubsequence(String s1, String s2) {
        int[][] solution = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                boolean tailSame = s1.charAt(i) == s2.charAt(j);
                if (i == 0 && j == 0) {
                    solution[i][j] = tailSame ? 1 : 0;
                    continue;
                }
                if (i == 0) {
                    solution[i][j] = tailSame ? 1 : solution[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    solution[i][j] = tailSame ? 1 : solution[i - 1][j];
                    continue;
                }

                if (tailSame) {
                    solution[i][j] = solution[i - 1][j - 1] + 1;
                    continue;
                }
                solution[i][j] = Math.max(solution[i - 1][j], solution[i][j - 1]);
            }
        }
        System.out.printf("The LCS for %s and %s is %d%n", s1, s2, solution[s1.length() - 1][s2.length() - 1]);
        return;


    }
}
