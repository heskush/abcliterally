package practice2018.coding.plaintext.sorting;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, -9, 34, 1, 1, 34};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minVal = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minIndex = j;
                }

            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;

        }

    }
}
