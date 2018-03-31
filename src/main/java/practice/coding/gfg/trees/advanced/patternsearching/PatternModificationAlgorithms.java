package practice.coding.gfg.trees.advanced.patternsearching;

// author -- hemantkumar
public class PatternModificationAlgorithms {
}

class KMPAlgorithm {
    String pattern;
    int[] longestPrefixArr;

    public static KMPAlgorithm initialize(String pattern) {
        return new KMPAlgorithm(pattern);
    }

    public KMPAlgorithm(String pattern) {
        this.pattern = pattern;
        initializeLongestPrefixArr();
    }

    private void initializeLongestPrefixArr() {
        longestPrefixArr = new int[pattern.length()];
        int j = 0;
        longestPrefixArr[0] = 0;
        for (int i = 1; i < pattern.toCharArray().length; i++) {
            char currentChar = pattern.charAt(i);
            char prefixLastChar = pattern.charAt(j);
            if (currentChar == prefixLastChar) {

            }

        }

    }

}