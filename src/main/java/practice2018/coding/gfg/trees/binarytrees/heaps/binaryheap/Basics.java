package practice2018.coding.gfg.trees.binarytrees.heaps.binaryheap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

// author -- hemantkumar
public class Basics {
    public static int[] heapifyArr(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyElement(arr, i, size);
        }
        return arr;
    }

    public static void heapifyElement(int[] arr, int index, int size) {
        if (index <= (size / 2 - 1)) { // A parent node
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int leftNodeVal = leftChildIndex < size ? arr[leftChildIndex] : Integer.MIN_VALUE;
            int rightNodeVal = rightChildIndex < size ? arr[rightChildIndex] : Integer.MIN_VALUE;
            int maxIndex = leftNodeVal > rightNodeVal ? leftChildIndex : rightChildIndex;
            if (arr[maxIndex] > arr[index]) {
                int temp = arr[index];
                arr[index] = arr[maxIndex];
                arr[maxIndex] = temp;
                heapifyElement(arr, maxIndex, size);
            }


        }
    }


    public static int[] heapSort(int[] arr) {
        heapifyArr(arr, arr.length);

        for (int size = arr.length; size > 1; size--) {
            heapifyElement(arr, 0, size);
            int lastElement = arr[size - 1];
            arr[size - 1] = arr[0];
            arr[0] = lastElement;
        }


        return arr;

    }


    public static void main(String[] args) {
//        int[] ints = heapifyArr(new int[]{1, 4, 3, 7, 8, 9, 10}, 7);
//        System.out.println(Arrays.toString(ints));
//        int[] ints = heapSort(new int[]{8, 4, 7, 1, 3, 5});


        List<Integer> collect = ThreadLocalRandom.current().ints().limit(10).mapToObj(x -> x).collect(Collectors.toList());
        PriorityQueue<Integer> heaps = new PriorityQueue<Integer>(Comparator.reverseOrder());
        heaps.addAll(collect);
        System.out.println(collect.stream().map(x -> x.toString()).collect(Collectors.joining(" | ")));
        System.out.println(heaps.stream().map(Object::toString).collect(Collectors.joining("|")));

    }


}
