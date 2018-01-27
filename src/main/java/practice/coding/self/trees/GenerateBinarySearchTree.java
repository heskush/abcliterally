package practice.coding.self.trees;

import java.util.stream.IntStream;

// author -- hemantkumar
public class GenerateBinarySearchTree {
  public static TreeNode generate(int size) {
    int[] intArr = IntStream.rangeClosed(1, size).toArray();
    return giveRoot(intArr, 0, intArr.length - 1);
  }

  public static TreeNode giveRoot(int[] arr, int start, int end) {
    // BaseCase #1: Array has single element
    if (start == end) {
      return new TreeNode(null, null, arr[start]);
    }
    if (start == end - 1) {
      // Bigger one becomes the parent.
      return new TreeNode(new TreeNode(null, null, arr[start]), null, arr[end]);
    }
    if (start == end - 2) {
      return new TreeNode(new TreeNode(null, null, arr[start]), new TreeNode(null, null, arr[start + 2]), arr[start + 1]);
    }

    int midIndx = start + (end - start) / 2;
    return new TreeNode(giveRoot(arr, start, midIndx - 1), giveRoot(arr, midIndx + 1, end), arr[midIndx]);

  }
}
