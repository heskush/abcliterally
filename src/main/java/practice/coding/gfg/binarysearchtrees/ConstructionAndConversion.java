package practice.coding.gfg.binarysearchtrees;

import java.util.ArrayList;
import java.util.Collections;

import practice.coding.gfg.trees.TreeNode;
import practice.coding.gfg.trees.TreeTraversal;
import practice.language.java.util.DemonstrationUtil;

// author -- hemantkumar
public class ConstructionAndConversion {

  /*
   * -----------RED-----------------
   *
   * https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
   *
   * Here the absence of the critical inorder traversal is compensated by the fact that its a Binary Search Tree. The O(n^2)
   * algorithm is inefficient and there is an O(n) solution to the problem.
   */

  static class constructBSTFromPreOrderTraversal {
    static int[] preTraversal = new int[] { 10, 5, 1, 7, 40, 50 };

    constructBSTFromPreOrderTraversal(int[] preTraversal) {
      this.preTraversal = preTraversal;
    }

    static class RecursiveVal {
      int val;
    }

    private static TreeNode recur(int[] preTraversal, RecursiveVal elementIndex, int min, int max) {
      // Base Case
      if (elementIndex.val > preTraversal.length - 1) {
        return null;
      }
      int element = preTraversal[elementIndex.val];
      if (element > min && element < max) {
        elementIndex.val = elementIndex.val + 1;
        TreeNode treeNode = TreeNode.leafNode(element);
        treeNode.left = recur(preTraversal, elementIndex, min, element);
        treeNode.right = recur(preTraversal, elementIndex, element, max);
        return treeNode;

      }
      return null;

    }

    public static TreeNode execute() {

      RecursiveVal elementIndex = new RecursiveVal();
      elementIndex.val = 0;
      TreeNode root = recur(preTraversal, elementIndex, Integer.MIN_VALUE, Integer.MAX_VALUE);
      return root;

    }

    public static void demonstrate() {
      System.out.println();
      RecursiveVal elementIndex = new RecursiveVal();
      elementIndex.val = 0;
      TreeNode root = recur(preTraversal, elementIndex, Integer.MIN_VALUE, Integer.MAX_VALUE);
      TreeTraversal.levelOrderTraversal(root, System.out::println);
      DemonstrationUtil.terminate();

    }

  }

  /*------------------RED----------------------
   *
   * https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
   *
   * It's interesting to think whether if it's even possible to convert every binary tree to a BST while preserving the structure.
   */

  /*
   * --------------RED---------- https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
   *
   * This would have been easily implemented if it were an array. Because then accessing elements would have been O(1). But for
   * doing this for linked list in O(1) time, a different approach needs to be used.
   * 
   */

  static class constructBSTFromSortedLinkedList {
    public static TreeNode root = new TreeNode(null, null, 1);

    public static class IncrementalVal {
      static int val = 0;

      public static void increase() {
        val = val + 1;

      }

    }

    public static TreeNode execute() {
      TreeNode right = root.right;
      TreeTraversal.recursiveInorderTraversal(root, x -> IncrementalVal.increase());
      int nElements = IncrementalVal.val;

    }

  }

  static class convertBinaryTreeToBST {
    static TreeNode root = new TreeNode(new TreeNode(TreeNode.leafNode(8), TreeNode.leafNode(4), 2), TreeNode.leafNode(7), 10);

    convertBinaryTreeToBST(TreeNode root) {
      this.root = root;
    }

    public static TreeNode recur(ArrayList<Integer> inorderTraversal, ArrayList<Integer> sorted, TreeNode root) {
      if (root == null) {
        return null;
      }
      int val = (int) root.data;
      int originalIndex = inorderTraversal.indexOf(val);
      int desiredVal = sorted.get(originalIndex);
      TreeNode newRoot = new TreeNode(null, null, desiredVal);
      newRoot.left = recur(inorderTraversal, sorted, root.left);
      newRoot.right = recur(inorderTraversal, sorted, root.right);
      return newRoot;

    }

    public static TreeNode execute() {
      ArrayList<Integer> inorderTraversal = new ArrayList<>();
      TreeTraversal.recursiveInorderTraversal(root, x -> inorderTraversal.add((int) x.data));
      ArrayList<Integer> sortedList = new ArrayList<>(inorderTraversal);
      Collections.sort(sortedList);
      TreeNode newRoot = recur(inorderTraversal, sortedList, root);
      return newRoot;

    }

    public static void demonstrate() {
      System.out.println("convertBinaryTreeToBST.demonstrate");
      TreeNode newRoot = execute();
      TreeTraversal.levelOrderTraversal(newRoot, System.out::println);
      DemonstrationUtil.terminate();

    }

  }

  public static void main(String[] args) {
    constructBSTFromPreOrderTraversal.demonstrate();
    convertBinaryTreeToBST.demonstrate();

  }

}
