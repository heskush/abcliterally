package practice.coding.gfg.binarysearchtrees;

import practice.coding.gfg.trees.TreeNode;
import practice.coding.gfg.trees.TreeTraversal;

// author -- hemantkumar
public class Miscellaneous {

  /*
   * 
   *
   * -----------------------RED-------------------------------
   * https://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
   *
   * There are two recurisve ways to solve this, one takes O(n^2) and another one takes O(n). For the first one go from top to
   * bottom multiple times and in the second one we go from bottom to top just once.
   *
   *
   * 
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

    static Object[] recur_type1(TreeNode node, int max, int min, RecursiveVal maxBSTData) {
      // BASE CASE
      if (node == null) {
        return new Object[] { true, 0 };
      }
      int data = (int) node.data;
      if (min < data && data < max) {
        Object[] fromLeft = recur_type1(node.left, data, min, maxBSTData);
        Object[] fromRight = recur_type1(node.right, max, data, maxBSTData);
        boolean isLeft = (boolean) fromLeft[0];
        int elementsInLeft = (int) fromLeft[1];
        boolean isRight = (boolean) fromRight[0];
        int elementsInRight = (int) fromRight[1];
        if (isLeft && isRight) {
          return new Object[] { true, elementsInLeft + elementsInRight + 1 };

        } else {
          fromLeft = recur_type1(node.left, data, Integer.MIN_VALUE, maxBSTData);
          fromRight = recur_type1(node.right, Integer.MAX_VALUE, data, maxBSTData);
          isLeft = (boolean) fromLeft[0];
          elementsInLeft = (int) fromLeft[1];
          isRight = (boolean) fromRight[0];
          elementsInRight = (int) fromRight[1];
          if (isLeft && isRight) {
            int totalElements = elementsInLeft + elementsInRight + 1;
            if (totalElements > maxBSTData.nElements) {
              maxBSTData.root = node;
              maxBSTData.nElements = totalElements;
            }
            return new Object[] { false, 0 };

          }
          return new Object[] { false, 0 };

        }

      }

      return new Object[] { false, 0 };

    }

    public static TreeNode execute_type1() {
      RecursiveVal maxBSTData = new RecursiveVal(null, 0);
      recur_type1(root, Integer.MAX_VALUE, Integer.MIN_VALUE, maxBSTData);
      return maxBSTData.root;

    }

    public static void demonstrate_type1() {
      System.out.println("MaxBSTinBinaryTree.demonstrate");
      TreeNode maxBSTRoot = execute_type1();
      TreeTraversal.levelOrderTraversal(maxBSTRoot, System.out::println);

    }

    static Object[] recur_type2(TreeNode node, RecursiveVal maxBstData) {
      // BASE CASE
      if (node == null) {
        return new Object[] { true, null, null, 0 };
      }
      Object[] fromLeft = recur_type2(node.left, maxBstData);
      Object[] fromRight = recur_type2(node.right, maxBstData);
      boolean isleft = (boolean) fromLeft[0];
      boolean isRight = (boolean) fromRight[0];
      if (isleft && isRight) {
        int leftMin = fromLeft[1] != null ? (int) fromLeft[1] : -1;
        int leftMax = fromLeft[2] != null ? (int) fromLeft[2] : -1;
        int rightMin = fromRight[1] != null ? (int) fromRight[1] : -1;
        int rightMax = fromRight[2] != null ? (int) fromRight[2] : -1;
        int data = (int) node.data;
        if ((leftMax == -1 || data > leftMax) && (data == -1 || data < rightMin)) {
          int totalElements = (int) fromLeft[3] + (int) fromRight[3] + 1;
          if (maxBstData.nElements < totalElements) {
            maxBstData.root = node;
            maxBstData.nElements = totalElements;
          }
          return new Object[] { true, leftMin, rightMax, totalElements };
        }
      }
      return new Object[] { false, null, null, -1 };

    }

    public static TreeNode execute_type2() {
      RecursiveVal maxBSTData = new RecursiveVal(null, 0);
      recur_type1(root, Integer.MAX_VALUE, Integer.MIN_VALUE, maxBSTData);
      return maxBSTData.root;

    }

    public static void demonstrate_type2() {
      System.out.println("MaxBSTinBinaryTree.demonstrate_type2");
      TreeNode maxBSTRoot = execute_type2();
      TreeTraversal.levelOrderTraversal(maxBSTRoot, System.out::println);

    }

  }

  public static void main(String[] args) {
    MaxBSTinBinaryTree.demonstrate_type2();

  }

}
