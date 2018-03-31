package practice.coding.gfg.dp.intermediate;

import practice.language.java.util.DemonstrationUtil;

import java.util.HashSet;

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


    public static void main(String[] args) {
        LongestSubstringWithoutRepetition.demonstrate("ABDEFGABEF");
        int a = 'a';
        int b = 'b';
        int z = "z".charAt(0);
        System.out.println(a);
        System.out.println(b);
        System.out.println(z);
        System.out.println();
        B be = new C();


    }
}

class A {
    int a;

}

class B extends A {
    int a;

}

class C extends A {
    int a;

}
