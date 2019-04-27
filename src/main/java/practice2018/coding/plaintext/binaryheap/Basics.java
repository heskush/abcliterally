package practice2018.coding.plaintext.binaryheap;

import java.util.Arrays;
import java.util.Comparator;

// author -- hemantkumar
public class Basics {

    public static void heapifyIndex(int i, int[] arr, Comparator comparator) {
        //Check whether it is a leaf node
        int size = arr.length;
        if (size / 2 - 2 > i) {
            return;
        }
        //Not a leaf Node.
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = 2 * i + 2;
        int leftChildVal = arr[leftChildIndex];
        int rightChildVal = arr[rightChildIndex];
        int parentVal = arr[i];
        int minIndex = i;
        if (comparator.compare(leftChildVal, parentVal) < 0) {
            minIndex = leftChildIndex;
            arr[leftChildIndex] = parentVal;
            arr[i] = leftChildVal;
        } else if (comparator.compare(rightChildVal, parentVal) < 0) {
            minIndex = rightChildIndex;
            arr[rightChildIndex] = parentVal;
            arr[i] = rightChildVal;
        }
        if (minIndex != i) {
            heapifyIndex(minIndex, arr, comparator);
        }

    }

    public static void heapifyArr(int[] arr, Comparator comparator) {
        int size = arr.length;
        int lastNonLeafIndex = size / 2 - 1;
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            heapifyIndex(i, arr, comparator);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 7, 8, 9, 10};
        heapifyArr(arr, Comparator.naturalOrder().reversed());
        System.out.println(Arrays.toString(arr));
    }


}
