package practice.coding.self.trees;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// author -- hemantkumar
public class GenerateBinarySearchTree {
  private static TreeNode sampleTree;
  static {
    List<TreeNode> treeNodeList =
        IntStream.rangeClosed(0, 10).mapToObj(x -> new TreeNode(null, null, x)).collect(Collectors.toList());
    // Left Subtree
    treeNodeList.get(5).left = treeNodeList.get(3);
    treeNodeList.get(3).left = treeNodeList.get(1);
    treeNodeList.get(3).right = treeNodeList.get(4);
    treeNodeList.get(1).right = treeNodeList.get(2);

    // Right Subtree
    treeNodeList.get(5).right = treeNodeList.get(7);
    treeNodeList.get(7).left = treeNodeList.get(6);
    treeNodeList.get(7).right = treeNodeList.get(9);
    treeNodeList.get(9).left = treeNodeList.get(8);
    treeNodeList.get(9).right = treeNodeList.get(10);
    sampleTree = treeNodeList.get(5);
  }

  private GenerateBinarySearchTree() {

  }

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

  public static TreeNode giveSampleTreeTenNodes() {
    return sampleTree;
  }

}
