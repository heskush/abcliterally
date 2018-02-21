package practice.coding.gfg.binarysearchtrees;

import practice.coding.gfg.trees.TreeNode;
import practice.coding.gfg.trees.TreeTraversal;

// author -- hemantkumar
public class Miscellaneous {

  /*
   * TODO
   *
   * -----------------------RED-------------------------------
   * https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
   */

  static class MaxBSTinBinaryTree {
    static TreeNode root = new TreeNode(new TreeNode(TreeNode.leafNode(5), TreeNode.leafNode(20), 10), new TreeNode(
        new TreeNode(TreeNode.leafNode(45), null, 55), new TreeNode(TreeNode.leafNode(65), TreeNode.leafNode(80), 70), 60), 50);

    static class RecursiveVal {
      TreeNode root;
      int nElements;

      public RecursiveVal(TreeNode root, int nElements) {
        this.root = root;
        this.nElements = nElements;
      }
    }

    static Object[] recur(TreeNode node, int max, int min, RecursiveVal maxBSTData) {
      // BASE CASE
      if (node == null) {
        return new Object[] { true, 0 };
      }
      int data = (int) node.data;
      Object[] fromLeft = recur(node.left, data, min, maxBSTData);
      Object[] fromRight = recur(node.right, max, data, maxBSTData);
      boolean isLeft = (boolean) fromLeft[0];
      int elementsInLeft = (int) fromLeft[1];
      boolean isRight = (boolean) fromRight[0];
      int elementsInRight = (int) fromRight[1];
      if (isLeft && isRight) {
        int totalElements = elementsInLeft + elementsInRight + 1;
        if (maxBSTData.root == null || maxBSTData.nElements < totalElements) {
          maxBSTData.root = node;
          maxBSTData.nElements = totalElements;
        }
        return new Object[] { true, totalElements };

      }

    }

    public static TreeNode execute() {
      RecursiveVal maxBSTData = new RecursiveVal(null, 0);
      recur(root, Integer.MAX_VALUE, Integer.MIN_VALUE, maxBSTData);
      return maxBSTData.root;

    }

    public static void demonstrate() {
      System.out.println("MaxBSTinBinaryTree.demonstrate");
      TreeNode maxBSTRoot = execute();
      TreeTraversal.levelOrderTraversal(maxBSTRoot, System.out::println);

    }

  }

  public static void main(String[] args) {
    MaxBSTinBinaryTree.demonstrate();

  }

}
