package practice.coding.gfg.binarysearchtrees;

import java.util.ArrayList;
import java.util.Stack;

import practice.coding.gfg.trees.TreeNode;
import practice.coding.gfg.trees.TreeTraversal;
import practice.language.java.util.DemonstrationUtil;

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

  /*
   * TODO:
   *
   * -------------------------RED--------------------------------------
   * https://www.geeksforgeeks.org/check-for-identical-bsts-without-building-the-trees/
   *
   */
  static class CheckIdenticalBSTFromSequence {

  }

  /*
   * TODO: https://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/
   */

  static class MergeTwoBSTWithLimitedExtraSpace {
    static TreeNode root1 = new TreeNode(TreeNode.leafNode(1), TreeNode.leafNode(5), 3);
    static TreeNode root2 = new TreeNode(TreeNode.leafNode(2), TreeNode.leafNode(6), 4);

    public static void execute() {

      Stack<TreeNode> stack1 = new Stack<TreeNode>();
      Stack<TreeNode> stack2 = new Stack<>();
      TreeNode stack1NewNode = root1;
      TreeNode stack2NewNode = root2;

    }

    public static TreeNode[] nextElementFromStack(Stack<TreeNode> stack, TreeNode newNode) {
      while (newNode != null) {
        newNode.pus

      }

    }

    public static void demonstrate() {
      System.out.println("MergeTwoBSTWithLimitedExtraSpace.demonstrate");
      execute();
      DemonstrationUtil.terminate();
    }

  }

  /*
   * 
   *
   * ----------------------------YELLOW---------------------------------------
   * https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
   *
   * The straight-forward way would take O(nlogn) time and O(n) space complexity. A better approach is to do it in O(n) time and
   * O(n) space.
   */

  static class fixBstWithTwoNodesSwapped {
    // 10 and 2 are swapped
    static TreeNode root = new TreeNode(new TreeNode(TreeNode.leafNode(1), TreeNode.leafNode(3), 10),
        new TreeNode(TreeNode.leafNode(7), TreeNode.leafNode(12), 2), 6);

    public static void execute() {
      int[] swapped = findSwapped(root);
      swapNodes(root, swapped);
    }

    public static void demonstrate() {
      System.out.println("fixBstWithTwoNodesSwapped.demonstrate");
      execute();
      TreeTraversal.levelOrderTraversal(root, System.out::println);

    }

    /*
     * One may want to think about the fact that if two elements in a sorted array are swapped then, how to find the two swapped
     * elements. the bigger swapped element would be greater than the next element and the smaller swapped element would be
     * greater than the previous element. Because we are swapping a small value with a large value.
     */
    static int[] findSwapped(TreeNode root) {
      ArrayList<Integer> inOrderTraversal = new ArrayList<>();
      TreeTraversal.recursiveInorderTraversal(root, x -> inOrderTraversal.add((int) x.data));
      int maxSwapped = -1;
      int minSwapped = -1;
      boolean foundMax = false;
      boolean foundMin = false;
      int previous = inOrderTraversal.get(0);
      int current;

      for (int i = 1; i < inOrderTraversal.size() - 1; i++) {
        current = inOrderTraversal.get(i);

        if (current < previous) {
          if (maxSwapped == -1) {
            maxSwapped = previous;
            previous = current;
            continue;
          }
          minSwapped = current;
          previous = current;
          break;

        }
        previous = current;

      }

      return new int[] { minSwapped, maxSwapped };

    }

    static void swapNodes(TreeNode root, int[] swappedValues) {
      int rootData = (int) root.data;
      int minValue = swappedValues[0];
      int maxValue = swappedValues[1];
      TreeNode[] currentMinValNodeArr = new TreeNode[] { null };
      TreeNode[] currentMaxValNodeArr = new TreeNode[] { null };
      TreeTraversal.recursiveInorderTraversal(root, x -> {
        if ((int) x.data == minValue) {
          currentMinValNodeArr[0] = x;
        }
        if ((int) x.data == maxValue) {
          currentMaxValNodeArr[0] = x;
        }
      });
      TreeNode currentMinValNode = currentMinValNodeArr[0];
      TreeNode currentMaxValNode = currentMaxValNodeArr[0];
      int tmp = (int) currentMinValNode.data;
      currentMinValNode.data = currentMaxValNode.data;
      currentMaxValNode.data = tmp;

    }

  }

  /*
   * -----------------------------------RED---------RED-----------------------------------------
   *
   * https://www.geeksforgeeks.org/find-if-there-is-a-triplet-in-bst-that-adds-to-0/
   *
   * This needs to be done in O(n^2) time and O(LogN) space complexity. Modification of BST is allowed
   */

  static class findZeroSumTripletInBalancedBST {
    static TreeNode root = new TreeNode(new TreeNode(null, TreeNode.leafNode(-8), -13),
        new TreeNode(new TreeNode(TreeNode.leafNode(7), null, 13), TreeNode.leafNode(15), 14), 6);

    static TreeNode[] convertBSTToDLL(TreeNode node) {
      TreeNode[] finalMinMAx = recur_BstToDLL(node);

      return finalMinMAx;

    }

    static TreeNode[] recur_BstToDLL(TreeNode node) {
      if (node == null) {
        return null;
      }
      TreeNode[] fromLeft = recur_BstToDLL(node.left);
      TreeNode[] fromRight = recur_BstToDLL(node.right);
      TreeNode treeMinima = null;
      TreeNode treeMaxima = null;
      if (fromLeft != null && fromRight != null) {
        fromLeft[1].right = node;
        fromRight[0].left = node;
        node.left = fromLeft[1];
        node.right = fromRight[0];
        treeMaxima = fromRight[1];
        treeMinima = fromLeft[0];

      }
      if (fromLeft == null && fromRight != null) {
        fromRight[0].left = node;
        node.right = fromRight[0];
        treeMaxima = fromRight[1];
        treeMinima = node;
      }
      if (fromRight == null && fromLeft != null) {
        fromLeft[1].right = node;
        node.left = fromLeft[1];
        treeMaxima = node;
        treeMinima = fromLeft[0];

      }
      if (fromLeft == null && fromRight == null) {
        treeMaxima = node;
        treeMinima = node;
      }
      return new TreeNode[] { treeMinima, treeMaxima };

    }

    public static boolean execute() {
      TreeNode[] treeNodes = convertBSTToDLL(root);
      TreeNode head = treeNodes[0];
      TreeNode tail = treeNodes[1];
      TreeNode leftBoundary, rightBoundary;
      boolean isZeroSumTripletPresent = false;
      while (tail != null) {
        leftBoundary = head;
        rightBoundary = tail.left;
        int sumExpected = (int) tail.data;
        while (leftBoundary != rightBoundary && !isZeroSumTripletPresent) {
          int leftVal = (int) leftBoundary.data;
          int rightVal = (int) rightBoundary.data;
          int sumObtained = leftVal + rightVal;
          if (-sumObtained < sumExpected) {
            leftBoundary = leftBoundary.right;

          }
          if (-sumObtained > sumExpected) {
            rightBoundary = rightBoundary.left;
          }
          if (-sumObtained == sumExpected) {
            isZeroSumTripletPresent = true;
            System.out.printf(" The triplet is present for nodes : %s,%s,%s %n", leftBoundary.toString(),
                rightBoundary.toString(), tail.toString());
            break;
          }
        }
        tail = tail.left;
      }
      return isZeroSumTripletPresent;

    }

    public static void demonstrate() {
      System.out.println("findZeroSumTripletInBalancedBST.demonstrate");

      System.out.println("ZERO SUM TRIPLET IS PRESENT " + execute());
      DemonstrationUtil.terminate();

    }

  }

  /*
   * TODO:
   *
   * ------------------------------RED-------------------------------------------
   *
   * https://www.geeksforgeeks.org/leaf-nodes-preorder-binary-search-tree/
   */
  static class printLeafNodesFromPreOrderTraversalOfBST {

  }

  public static void main(String[] args) {
    // findZeroSumTripletInBalancedBST.demonstrate();
    fixBstWithTwoNodesSwapped.demonstrate();

  }

}
