package practice2018.coding.gfg.hashing;

import java.util.Arrays;
import java.util.HashMap;

// author -- hemantkumar
public class Intermediate {

    static class Solution {
        static int[] arr =
                {
                        15, -2, 2, -8, 1, 7, 10, 23
                };

        public static int[] execute(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int sum = 0;
            int a = -1;
            int b = -1;
            for (int i = 0; i < arr.length; i++) {
                sum = sum + arr[i];
                //Check if this sum already exists
                if (map.containsKey(sum)) {
                    a = map.get(sum) + 1;
                    b = i;
                    break;
                }
                map.put(sum, i);
            }
            if (a == -1 || b == -1) {
                System.out.println("No Array with zero sub array sum found");
                return null;
            } else {
                return new int[]{a, b};
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.execute(new int[]{15, -2, 2, -8, 1, 7, 10, 23})));

    }
}
