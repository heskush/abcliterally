package practice2019.coding.gfg.sorting;

import practice2019.coding.gfg.helper.CompositeData;
import practice2019.coding.gfg.helper.LinkedList;
import practice2019.coding.gfg.helper.ListNode;

import java.util.Arrays;
import java.util.BitSet;

public class Basic {
    public static void main(String[] args) {
        int[] unsortedData = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(Arrays.copyOf(unsortedData, unsortedData.length));
        recursiveBubbleSort(Arrays.copyOf(unsortedData, unsortedData.length));
        selectionSort(Arrays.copyOf(unsortedData, unsortedData.length));
        stableSelectionSort(CompositeData.generateList());
        insertionSort(Arrays.copyOf(unsortedData, unsortedData.length));
        mergeSort(unsortedData);
        mergeSortForLinkedList(LinkedList.createDescendingList().head);
        mergeSortInPlace(Arrays.copyOf(unsortedData, unsortedData.length));
        mergeSortIterative(Arrays.copyOf(unsortedData, unsortedData.length));
        quickSort(Arrays.copyOf(unsortedData, unsortedData.length));
        iterativeQuickSort(Arrays.copyOf(unsortedData, unsortedData.length));
        LinkedList list = LinkedList.createDescendingList();
        quickSortForLinkedList(list.head);

    }

    public static void bubbleSort(int[] data) {
        System.out.println("Basic.bubbleSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        boolean swapped = false;
        int current, next;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                current = data[j];
                next = data[j + 1];
                if (current > next) {
                    data[j] = next;
                    data[j + 1] = current;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        System.out.printf("The sorted array is %s%n", Arrays.toString(data));
    }

    public static void recursiveBubbleSort(int[] data) {
        System.out.println("Basic.recursiveBubbleSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        bubbleSortRecur(data, data.length - 1);
        System.out.printf("The sorted array is %s%n", Arrays.toString(data));
    }

    private static void bubbleSortRecur(int[] data, int lastIndex) {
        if (lastIndex == 0) {
            return;
        }
        boolean swapped = false;
        int current, next;
        for (int i = 0; i < lastIndex; i++) {
            current = data[i];
            next = data[i + 1];
            if (current > next) {
                data[i + 1] = current;
                data[i] = next;
                swapped = true;
            }
        }
        if (swapped == false) {
            return;
        }
        bubbleSortRecur(data, lastIndex - 1);
    }

    public static void selectionSort(int[] data) {
        System.out.println("Basic.selectionSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        int minimumElement, currentElement, minimumElementIndex, tmp;
        for (int boundaryIndex = 0; boundaryIndex < data.length - 1; boundaryIndex++) {
            minimumElement = data[boundaryIndex];
            minimumElementIndex = boundaryIndex;
            for (int i = boundaryIndex + 1; i < data.length; i++) {
                currentElement = data[i];
                if (minimumElement > currentElement) {
                    minimumElement = currentElement;
                    minimumElementIndex = i;
                }
            }
            tmp = data[boundaryIndex];
            data[boundaryIndex] = minimumElement;
            data[minimumElementIndex] = tmp;
        }
        System.out.printf("The sorted array is %s%n", Arrays.toString(data));
    }

    public static void stableSelectionSort(CompositeData[] data) {
        System.out.println("Basic.stableSelectionSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        int current, minimum, minimumIndex;
        for (int boundaryIndex = 0; boundaryIndex < data.length - 1; boundaryIndex++) {
            minimum = data[boundaryIndex].primary;
            minimumIndex = boundaryIndex;
            for (int i = boundaryIndex + 1; i < data.length; i++) {
                current = data[i].primary;
                if (current < minimum) {
                    minimum = current;
                    minimumIndex = i;
                }
            }
            stableSelectionSortHelper(data, boundaryIndex, minimumIndex);
        }
        System.out.printf("The sorted arrays is %s%n", Arrays.toString(data));
    }

    private static void stableSelectionSortHelper(CompositeData[] data, int leftBoundary, int rightBoundary) {
        CompositeData previousElement = data[rightBoundary], tmp;
        for (int i = leftBoundary; i <= rightBoundary; i++) {
            tmp = data[i];
            data[i] = previousElement;
            previousElement = tmp;
        }
    }

    public static void insertionSort(int[] data) {
        System.out.println("Basic.insertionSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));

        for (int i = 0; i < data.length; i++) {
            insertionSortHelper(data, i - 1, data[i]);
        }
        System.out.printf("The sorted arrays is %s%n", Arrays.toString(data));
    }

    private static void insertionSortHelper(int[] data, int sortedRegionRightBoundary, int newElement) {
        if (sortedRegionRightBoundary == -1) {
            data[sortedRegionRightBoundary + 1] = newElement;
            return;
        }
        while (sortedRegionRightBoundary >= 0 && data[sortedRegionRightBoundary] > newElement) {
            data[sortedRegionRightBoundary + 1] = data[sortedRegionRightBoundary];
            sortedRegionRightBoundary--;
        }
        data[sortedRegionRightBoundary + 1] = newElement;
    }

    public static void mergeSort(int[] data) {
        System.out.println("Basic.mergeSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        System.out.printf("The sorted arrays is %s%n", Arrays.toString(mergeSortRecur(data, 0, data.length - 1)));
    }

    private static int[] mergeSortRecur(int[] data, int left, int right) {
        if (left == right) {
            System.out.println();
            return Arrays.copyOfRange(data, left, right + 1);
        }
        if (right == left + 1) {
            int first = data[left];
            int second = data[right];
            return new int[]{Math.min(first, second), Math.max(first, second)};
        }
        int m = (right - left) / 2;
        int[] sortedLeft = mergeSortRecur(data, left, left + m);
        int[] sortedRight = mergeSortRecur(data, left + m + 1, right);
        return mergeSortHelper(sortedLeft, sortedRight);
    }

    private static int[] mergeSortHelper(int[] sortedLeft, int[] sortedRight) {
        int[] merged = new int[sortedLeft.length + sortedRight.length];
        int leftArrayIndex = 0, rightArrayIndex = 0, mergedIndex = 0;
        while (leftArrayIndex < sortedLeft.length && rightArrayIndex < sortedRight.length) {
            if (sortedLeft[leftArrayIndex] < sortedRight[rightArrayIndex]) {
                merged[mergedIndex] = sortedLeft[leftArrayIndex];
                leftArrayIndex++;
            } else {
                merged[mergedIndex] = sortedRight[rightArrayIndex];
                rightArrayIndex++;
            }
            mergedIndex++;
        }
        while (leftArrayIndex < sortedLeft.length) {
            merged[mergedIndex] = sortedLeft[leftArrayIndex];
            mergedIndex++;
            leftArrayIndex++;
        }
        while (rightArrayIndex < sortedRight.length) {
            merged[mergedIndex] = sortedRight[rightArrayIndex];
            mergedIndex++;
            rightArrayIndex++;
        }
        return merged;
    }

    public static void mergeSortForLinkedList(ListNode head) {
        System.out.println("Basic.mergeSortForLinkedListRecur");
        System.out.printf("The source data is %s%n", head.toString());
        System.out.printf("The sorted array is %s%n", mergeSortForLinkedListRecur(head));

    }

    public static ListNode mergeSortForLinkedListRecur(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode middleNode = getMiddle(head);
        ListNode rightList = middleNode.next;
        middleNode.next = null;
        ListNode sortedLeft = mergeSortForLinkedListRecur(head);
        ListNode sortedRight = mergeSortForLinkedListRecur(rightList);
        return mergeList(sortedLeft, sortedRight);
    }

    private static ListNode mergeList(ListNode sortedLeft, ListNode sortedRight) {
        if (sortedLeft == null) {
            return sortedRight;
        }
        if (sortedRight == null) {
            return sortedLeft;
        }
        ListNode head;
        if (sortedLeft.data < sortedRight.data) {
            head = sortedLeft;
            head.next = mergeList(sortedLeft.next, sortedRight);
        } else {
            head = sortedRight;
            head.next = mergeList(sortedLeft, sortedRight.next);
        }
        return head;


    }

    private static ListNode getMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head;

        }
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (fastNode != null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
        }
        return slowNode;
    }

    public static void mergeSortInPlace(int[] data) {
        System.out.println("Basic.mergeSortInPlace");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        mergeSortInPlaceRecur(data, 0, data.length - 1);
        System.out.printf("The sorted data is %s%n", Arrays.toString(data));
    }

    private static void mergeSortInPlaceRecur(int[] data, int left, int right) {
        if (left == right) {
            return;
        }
        if (left == right - 1) {
            int min = Math.min(data[left], data[right]);
            int max = Math.max(data[left], data[right]);
            data[left] = min;
            data[right] = max;
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSortInPlaceRecur(data, left, middle);
        mergeSortInPlaceRecur(data, middle + 1, right);
        mergeInPlace(data, left, middle + 1, right);
    }

    private static void mergeInPlace(int[] data, int left, int middle, int right) {
        if (left == middle || middle == right + 1) {
            return;
        }
        if (data[left] <= data[middle]) {
            mergeInPlace(data, left + 1, middle, right);
        } else {
            int previous = data[middle], tmp, i = left;
            while (i <= middle) {
                tmp = data[i];
                data[i] = previous;
                previous = tmp;
                i++;
            }
            mergeInPlace(data, left + 1, middle + 1, right);
        }
    }

    public static void mergeSortIterative(int[] data) {
        System.out.println("Basic.mergeSortIterative");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        int min, max;
        for (int i = 0; i < data.length - 1; i = i + 2) {
            if (i == data.length - 1) {
                break;
            }
            min = Math.min(data[i], data[i + 1]);
            max = Math.max(data[i], data[i + 1]);
            data[i] = min;
            data[i + 1] = max;
        }
        int chunkSize = 2;
        int middle, right;
        while (chunkSize <= Math.pow(2, Math.log(data.length) / Math.log(2) + 1)) {
            for (int i = 0; i < data.length; i = i + 2 * chunkSize) {
                middle = i + chunkSize < data.length ? i + chunkSize : data.length - 1;
                right = i + 2 * chunkSize - 1 < data.length ? i + 2 * chunkSize - 1 : data.length - 1;
                mergeInPlace(data, i, middle, right);
            }
            chunkSize = chunkSize * 2;
        }
        System.out.printf("The sorted data is %s %n", Arrays.toString(data));
    }

    public static void quickSort(int[] data) {
        System.out.println("Basic.quickSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        quickSortRecur(data, 0, data.length - 1);
        System.out.printf("The sorted data is %s%n", Arrays.toString(data));
    }

    private static void quickSortRecur(int[] data, int left, int right) {
        if (left == right) {
            return;
        }
        if (left == right - 1) {
            int min = Math.min(data[left], data[right]);
            int max = Math.max(data[left], data[right]);
            data[left] = min;
            data[right] = max;
        }
        int partition = partition(data, left, right, right);
        if (partition == left) {
            quickSortRecur(data, partition + 1, right);
            return;
        }
        if (partition == right) {
            quickSortRecur(data, left, partition - 1);
            return;
        }
        quickSortRecur(data, left, partition - 1);
        quickSortRecur(data, partition + 1, right);

    }

    private static int partition(int[] data, int left, int right, int pivotIndex) {
        int pivot = data[pivotIndex];
        int boundary = left - 1, tmp;
        for (int i = left; i <= right; i++) {
            if (data[i] <= pivot) {
                boundary++;
                tmp = data[i];
                data[i] = data[boundary];
                data[boundary] = tmp;
            }
        }
        return boundary;

    }

    public static void iterativeQuickSort(int[] data) {
        System.out.println("Basic.iterativeQuickSort");
        System.out.printf("The source data is %s%n", Arrays.toString(data));
        BitSet correctPositionIndex = new BitSet(data.length);
        while (correctPositionIndex.cardinality() != data.length) {
            // Get the rightmost element which is not at its correct position
            int pivotIndex = correctPositionIndex.previousClearBit(data.length - 1);
            int leftBoundary = correctPositionIndex.previousSetBit(pivotIndex) == -1 ? 0 : correctPositionIndex.previousSetBit(pivotIndex) + 1;
            int rightBoundary = correctPositionIndex.nextSetBit(pivotIndex) == -1 ? data.length - 1 : correctPositionIndex.nextSetBit(pivotIndex) - 1;
            if (leftBoundary == rightBoundary) {
                correctPositionIndex.set(pivotIndex);
                continue;
            }
            if (leftBoundary == rightBoundary - 1) {
                int min = Math.min(data[leftBoundary], data[rightBoundary]);
                int max = Math.max(data[leftBoundary], data[rightBoundary]);
                data[leftBoundary] = min;
                data[rightBoundary] = max;
                correctPositionIndex.set(leftBoundary);
                correctPositionIndex.set(rightBoundary);
                continue;
            }
            int partitionIndex = partition(data, leftBoundary, rightBoundary, pivotIndex);
            correctPositionIndex.set(partitionIndex);
        }
        System.out.printf("The sorted data is %s%n", Arrays.toString(data));
    }

    // TODO
    public static void quickSortStable(int[] data) {


    }

    public static void quickSortForLinkedList(ListNode head) {
        System.out.println("Basic.quickSortForLinkedList");
        System.out.printf("The source data is %s%n", new LinkedList(null,head,null).toString());
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        ListNode newHead = quickSortForLinkedListRecur(head, tail);
        System.out.printf("The sorted data is %s%n", new LinkedList(null, newHead,null).toString());

    }

    // TODO: Fix it
    private static ListNode quickSortForLinkedListRecur(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        if (head.next == tail) {
            ListNode min = head.data < head.next.data ? head : tail;
            ListNode max = head.data < head.next.data ? tail : head;
            min.next = max;
            max.next = null;
            return min;
        }
        ListNode[] newMarkers = partition(head, tail);
        ListNode newHead, pivotPreviousNode, pivotNode, newTail;
        newHead = newMarkers[0];
        pivotPreviousNode = newMarkers[1];
        pivotNode = newMarkers[2];
        newTail = newMarkers[3];
        if (newHead == pivotNode) {
            return quickSortForLinkedListRecur(pivotNode.next, tail);
        }
        if (pivotNode == newTail) {
            return quickSortForLinkedListRecur(newHead, pivotPreviousNode);
        }
        quickSortForLinkedListRecur(pivotNode.next, newTail);
        return quickSortForLinkedListRecur(head, pivotPreviousNode);

    }

    private static ListNode[] partition(ListNode head, ListNode tail) {
        ListNode[] partitionNodes = new ListNode[2];
        ListNode boundary = null, current = head, previous = null, currentNext, boundaryNext;
        ListNode pivotNode = tail, pivotPreviousNode = null;
        int pivotValue = tail.data;
        while (current != null) {
            if (current.data <= pivotValue) {
                if (boundary == null && previous == null) {
                    currentNext = current.next;
                    current.next = head;
                    boundary = current;
                    previous.next = currentNext;
                    current = currentNext;
                    continue;
                }
                if (boundary == null) {
                    previous.next = current.next;
                    current.next = head;
                    boundary = current;
                    head = current;
                    current = previous.next;
                    if (current == pivotNode) {
                        pivotPreviousNode = null;
                    }
                    if (previous.next == null) {
                        tail = previous;
                    }
                    continue;
                }
                currentNext = current.next;
                boundaryNext = boundary.next;
                if (current == pivotNode) {
                    pivotPreviousNode = boundary;
                }
                previous.next = currentNext;
                boundary.next = current;
                current.next = boundaryNext;
                current = currentNext;
                if (previous.next == null) {
                    tail = previous;
                }
            } else {
                current = current.next;
                previous = previous == null ? head : previous.next;
            }
        }

        return new ListNode[]{head, pivotPreviousNode, pivotNode, tail};
    }
}

