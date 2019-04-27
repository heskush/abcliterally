package practice2018.coding.gfg.trees.binarytrees.augmented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BinaryOperator;
import java.util.function.Function;

// author -- hemantkumar
public class SegmentTrees {


    public static void main(String[] args) {

//        SumOfGivenRange.execute_findRangeSum();

        SegmentTreeGeneric<Integer, Integer> rangeMinSegmentTree = new SegmentTreeGeneric<Integer, Integer>(new Integer[]{1, 3, 5, 7, 9, 11}, Function.identity(), Math::addExact);
        System.out.println("yolo");

    }
}


class SegmentTreeGeneric<A, B> {
    final A[] dataArr;
    private ArrayList<B> segmentTreeArr;
    final Function<A, B> function; //Maps a single data value to a query value
    final BinaryOperator<B> rangeQueryCombiner; // Combines two query values.

    public SegmentTreeGeneric(A[] dataArr, Function<A, B> dataToQueryMapper, BinaryOperator<B> rangeQueryCombiner) {
        this.dataArr = dataArr;
        this.function = dataToQueryMapper;
        this.rangeQueryCombiner = rangeQueryCombiner;
        int height = (int) Math.ceil(Math.log(dataArr.length) / Math.log(2));
        segmentTreeArr = new ArrayList<>(Collections.nCopies((2 * (int) Math.pow(2, height)) - 1, null));
        generateSegmentTree(0, dataArr.length - 1, 0);


    }

    private static int getMid(int low, int high) {
        return low + (high - low) / 2;
    }

    private void generateSegmentTree(int low, int high, int pos) {
        if (low == high) {
            segmentTreeArr.set(pos, function.apply(dataArr[low]));
            return;
        }
        int mid = getMid(low, high);

        generateSegmentTree(low, mid, 2 * pos + 1);
        generateSegmentTree(mid + 1, high, 2 * pos + 2);
        B valLeft = segmentTreeArr.get(2 * pos + 1);
        B valRight = segmentTreeArr.get(2 * pos + 2);
        B parentVal = rangeQueryCombiner.apply(valLeft, valRight);

        segmentTreeArr.set(pos, parentVal);
        return;


    }

    public B rangeQuery(int qLeft, int qRight) {
        return rangeQueryRecur(qLeft, qRight, 0, 0, dataArr.length - 1);
    }

    private B rangeQueryRecur(int qLeft, int qRight, int segmentTreeIndex, int segmentLeft, int segmentRight) {
//        Complete Overlap
        if (qLeft <= segmentLeft && segmentRight <= qRight) {
            return segmentTreeArr.get(segmentTreeIndex);
        }
//        No Overlap
        if (segmentRight < qLeft || segmentLeft > qRight) {
            return null;
        }
//        Partial Overlap
        int mid = getMid(segmentLeft, segmentRight);
        B fromLeftChild = rangeQueryRecur(qLeft, qRight, 2 * segmentTreeIndex + 1, segmentLeft, mid);
        B fromRightChild = rangeQueryRecur(qLeft, qRight, 2 * segmentTreeIndex + 2, mid + 1, segmentRight);
        B finalVal;
        if (fromLeftChild == null || fromRightChild == null) {
            finalVal = fromLeftChild == null ? fromRightChild : fromLeftChild;
        } else {
            finalVal = rangeQueryCombiner.apply(fromLeftChild, fromRightChild);
        }
        return finalVal;
    }

    public void updatePointData(int index, int val) {


    }

    private void updatePointDataRecur(int index, int val, int segmentTreeIndex, int segmentLeft, int segmentRight) {
        if (completeOverlap(index, index, segmentLeft, segmentRight)) {

        }

    }

    private static boolean noOverlap(int qLeft, int qRight, int segmentLeft, int segmentRight) {
        return segmentRight < qLeft || segmentLeft > qRight;
    }

    private static boolean completeOverlap(int qLeft, int qRight, int segmentLeft, int segmentRight) {
        return qLeft <= segmentLeft && segmentRight <= qRight;

    }

}

