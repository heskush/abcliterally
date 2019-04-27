package practice2018.coding.gfg.Arrays;

import java.util.Arrays;

// author -- hemantkumar
public class Miscellaneous {

    /*--------------RED-----------------------
     * https://www.geeksforgeeks.org/array-rotation/
     * Time : O(N); Space=Constant
     *
     * */

    public static void rotateArray(int[] arr, int d) {
        int size = arr.length;
        int totalSwaps = 0;
        int previousIndx = 0;
        int previousVal = arr[0];
        int shiftedIndx = -1;
        while (totalSwaps <= size) {
            if (previousIndx >= d) {
                shiftedIndx = previousIndx - d;
            } else {
                shiftedIndx = previousIndx - d + (size);
            }
            int tmp = previousVal;
            previousVal = arr[shiftedIndx];
            arr[shiftedIndx] = tmp;
            previousIndx = shiftedIndx;
            totalSwaps++;

        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotateArray(arr, 2);
        System.out.println(Arrays.toString(arr));

    }
}
