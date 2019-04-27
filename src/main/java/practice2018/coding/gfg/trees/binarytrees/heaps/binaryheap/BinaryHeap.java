package practice2018.coding.gfg.trees.binarytrees.heaps.binaryheap;

import java.util.Comparator;

// author -- hemantkumar
public class BinaryHeap<T> {
    private T[] heapArr;
    private int size;
    Comparator<T> comparator;

    public BinaryHeap(T[] heapArr, Comparator<T> comparator) {
        this.heapArr = heapArr;
        this.comparator = comparator;
        this.size = heapArr.length;
    }

    private void heapifyArr() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyAt(i);
        }

    }

    private void heapifyAt(int index) {
        if (index <= size / 2 - 1) {

            int leftIndex = index * 2 + 1;
            int rightIndex = index * 2 + 2;
            int minIndex;
            if (leftIndex >= size || rightIndex >= size) {
                minIndex = leftIndex >= size ? rightIndex : leftIndex;
            } else {
                T leftVal = heapArr[leftIndex];
                T rightVal = heapArr[rightIndex];
                minIndex = comparator.compare(leftVal, rightVal) < 0 ? leftIndex : rightIndex;
            }
            T currentVal = heapArr[index];
            if (comparator.compare(currentVal, heapArr[minIndex]) > 0) {
                T tmp = heapArr[index];
                heapArr[index] = heapArr[minIndex];
                heapArr[minIndex] = tmp;
                heapifyAt(minIndex);
            }

        }


    }


    public T removeTop() {
        T topVal = heapArr[0];
        heapArr[0] = heapArr[size - 1];
        size = size - 1;
        heapifyAt(0);
        return topVal;
    }

    public T showTop() {
        return heapArr[0];
    }


}
