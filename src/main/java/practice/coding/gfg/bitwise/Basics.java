package practice.coding.gfg.bitwise;

import practice.language.java.util.DemonstrationUtil;

import java.util.Arrays;
import java.util.BitSet;

// author -- hemantkumar
public class Basics {
    /* -------------------------YELLOW---------------------------------
     * https://www.geeksforgeeks.org/find-the-element-that-appears-once/
     * */
    static class FindNumberThatAppearsOnce {
        static int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};

        public static int execute(int[] arr) {
            int[] bitCountArr = new int[32];
            for (int i = 0; i < arr.length; i++) {
                updateBitCount(arr[i], bitCountArr);
            }
            StringBuilder builder = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (bitCountArr[i] % 3 == 0) {
                    builder.append("0");
                } else {
                    builder.append("1");
                }
            }
            return Integer.parseInt(builder.toString(), 2);
        }

        private static void updateBitCount(int x, int[] bitCountArr) {
            BitSet bitset = BitSet.valueOf(new long[]{x});
            for (int i = 0; i < 32; i++) {
                if (bitset.get(i)) {
                    bitCountArr[i]++;
                }
            }
        }

        public static void demonstrate() {
            System.out.println("FindNumberThatAppearsOnce.demonstrate");
            System.out.println("The number that appears once in " + Arrays.toString(arr) + " is " + execute(arr));
            DemonstrationUtil.terminate();
        }


    }

    public static void main(String[] args) {
        FindNumberThatAppearsOnce.demonstrate();

    }

}
