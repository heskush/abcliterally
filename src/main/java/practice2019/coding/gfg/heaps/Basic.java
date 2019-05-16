package practice2019.coding.gfg.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basic {
    public static void main(String[] args) {
        int[] data = {10, 8, 9, 7, 6, 5, 4};
        int[] data2 = {1, 2, 3, 4, 5, 6, 7};
        createMinHeap(data);
        System.out.println(Arrays.toString(data));
        createMaxHeap(data2);
        System.out.println(Arrays.toString(data2));
        int[] data3= IntStream.rangeClosed(0,10).toArray();
        ascendingHeapSort(data3);
        System.out.println(Arrays.toString(data3));
    }


    public static void createMinHeap(int[] data) {
        int i = (data.length / 2) - 1;
        while (i >= 0) {
            minHeapify(data, i);
            i--;
        }
    }

    private static void minHeapify(int[] data, int i) {
        int minIndex = i;
        if (2 * i + 1 < data.length && data[2 * i + 1] < data[minIndex]) {
            minIndex = 2 * i + 1;
        }
        if (2 * i + 2 < data.length && data[2 * i + 2] < data[minIndex]) {
            minIndex = 2 * i + 2;
        }
        if (minIndex != i) {
            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
            minHeapify(data, minIndex);
        }
    }

    public static void createMaxHeap(int[] data){
        int i = (data.length / 2) - 1;
        while (i >= 0) {
            maxHeapify(data, i);
            i--;
        }
    }

    private static void maxHeapify(int[] data, int i) {
        int maxIndx = i;
        if (2 * i + 1 < data.length && data[2 * i + 1] > data[maxIndx]) {
            maxIndx = 2 * i + 1;
        }
        if (2 * i + 2 < data.length && data[2 * i + 2] > data[maxIndx]) {
            maxIndx = 2 * i + 2;
        }
        if (maxIndx != i) {
            int tmp = data[i];
            data[i] = data[maxIndx];
            data[maxIndx] = tmp;
            maxHeapify(data, maxIndx);
        }

    }

    public static void ascendingHeapSort(int[] data) {
        int tmp;
        createMaxHeap(data);
        int heapSize = data.length;
        while (heapSize > 1) {
            tmp = data[heapSize - 1];
            data[heapSize - 1] = data[0];
            data[0] = tmp;
            heapSize--;
            ascendingHeapSortHelper(data, 0, heapSize);

        }
    }

    private static void ascendingHeapSortHelper(int[] data, int i ,int heapSize) {
        int maxIndx = i;
        if (2 * i + 1 < heapSize  && data[2 * i + 1] > data[maxIndx]) {
            maxIndx = 2 * i + 1;
        }
        if(2*i +2 < heapSize  && data[2*i +2] > data[maxIndx]){
            maxIndx = 2 * i + 2;
        }
        if (maxIndx != i) {
            int tmp = data[i];
            data[i] = data[maxIndx];
            data[maxIndx] = tmp;
            ascendingHeapSortHelper(data, maxIndx, heapSize);
        }


    }
}
