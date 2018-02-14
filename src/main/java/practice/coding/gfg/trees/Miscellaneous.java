package practice.coding.gfg.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import practice.language.java.util.DemonstrationUtil;

// author -- hemantkumar
public class Miscellaneous {

  /*
   * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
   *
   * SHOULD BE DONE IN SINGLE TRAVERSAL
   */

  public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

    if (root == null) {
      return null;
    }

    if (root.equals(node1) || root.equals(node2)) {
      return root;
    }
    TreeNode leftLCA = getLowestCommonAncestor(root.left, node1, node2);
    TreeNode rightLCA = getLowestCommonAncestor(root.right, node1, node2);
    if (leftLCA != null && rightLCA != null) {
      return root;
    }
    if (leftLCA != null || rightLCA != null) {
      return leftLCA != null ? leftLCA : rightLCA;
    }
    return null;
  }

  /*
   * https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
   */
  public static LinkedList<TreeNode> binaryToCircularLinkedList(TreeNode root) {
    LinkedList<TreeNode> circularList = new LinkedList<>();
    recurBinaryToCircular(root, circularList);
    return circularList;

  }

  private static void recurBinaryToCircular(TreeNode root, LinkedList<TreeNode> circularList) {
    if (root == null) {
      return;
    }
    recurBinaryToCircular(root.left, circularList);
    circularList.addLast(root);
    recurBinaryToCircular(root.right, circularList);
  }

  /*
   * https://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/
   */
  public static TreeNode removeCompletePathWithSumLess(TreeNode root, int sumExpected) {

    boolean onePathPresent = recurRemoveCompletePathWithSumLess(root, sumExpected, 0);
    if (!onePathPresent) {
      root = null;
    }

    return root;
  }

  public static boolean recurRemoveCompletePathWithSumLess(TreeNode root, int sumExpected, int sumCalculated) {
    if (root == null) {
      if (sumExpected <= sumCalculated) {
        return true;
      }
      return false;
    }
    int nodeVal = (int) root.data;
    sumCalculated += nodeVal;

    boolean leftSide = recurRemoveCompletePathWithSumLess(root.left, sumExpected, sumCalculated);
    boolean rightSide = recurRemoveCompletePathWithSumLess(root.right, sumExpected, sumCalculated);
    if (!leftSide) {
      root.left = null;
    }
    if (!rightSide) {
      root.right = null;
    }
    return leftSide || rightSide;

  }

  /*
   * TODO: SOLVE THIS https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
   */
  public static int findMaxPathSumBetweenTwoLeaves(TreeNode root) {
    return 1;
  }

  /*
   * TODO https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
   * 
   */
  public static TreeNode reverseAlternateLevelsOfPerfectBinaryTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    Stack<TreeNode> treeStack = new Stack<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addLast(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int nodes = queue.size();
      if (level % 2 == 0) {
        for (int i = 0; i < nodes; i++) {

        }
      } else {
      }

    }
    return null;
  }

  public static void testLowestCommonAncestor() {
    System.out.println("Miscellaneous.testLowestCommonAncestor");
    TreeNode root = TreeGenerator.giveSampleBST();
    TreeTraversal.levelOrderTraversal(root, System.out::println);
    TreeNode lowestCommonAncestor = getLowestCommonAncestor(root, root.left.left, root.left.right);
    System.out.println(lowestCommonAncestor);
    DemonstrationUtil.terminate();

  }

  public static void testBinaryToCircularLinkedList() {
    System.out.println("Miscellaneous.testBinaryToCircularLinkedList");
    Map<Integer, TreeNode> nodeMap = Arrays.stream(new Integer[] { 10, 12, 15, 25, 30, 36 })
        .collect(Collectors.toMap(Function.identity(), x -> new TreeNode(null, null, x)));
    nodeMap.get(10).left = nodeMap.get(12);
    nodeMap.get(10).right = nodeMap.get(15);
    nodeMap.get(12).left = nodeMap.get(25);
    nodeMap.get(12).right = nodeMap.get(30);
    nodeMap.get(15).left = nodeMap.get(36);
    LinkedList<TreeNode> convertedList = binaryToCircularLinkedList(nodeMap.get(10));
    /* SHOULD BE : 25 12 30 10 36 15 */
    convertedList.stream().forEach(System.out::println);
    DemonstrationUtil.terminate();

  }

  public static void testremoveCompletePathWithSumLess() {
    System.out.println("Miscellaneous.testremoveCompletePathWithSumLess");
    Map<Integer, TreeNode> nodesMap = IntStream.rangeClosed(1, 15).mapToObj(x -> x)
        .collect(Collectors.toMap(Function.identity(), x -> new TreeNode(null, null, x)));
    nodesMap.get(1).left = nodesMap.get(2);
    nodesMap.get(1).right = nodesMap.get(3);
    nodesMap.get(2).left = nodesMap.get(4);
    nodesMap.get(2).right = nodesMap.get(5);
    nodesMap.get(3).left = nodesMap.get(6);
    nodesMap.get(3).right = nodesMap.get(7);
    nodesMap.get(4).left = nodesMap.get(8);
    nodesMap.get(4).right = nodesMap.get(9);
    nodesMap.get(5).left = nodesMap.get(12);
    nodesMap.get(7).left = nodesMap.get(10);
    nodesMap.get(9).left = nodesMap.get(13);
    nodesMap.get(9).right = nodesMap.get(14);
    nodesMap.get(10).right = nodesMap.get(11);
    nodesMap.get(14).left = nodesMap.get(15);
    TreeNode treeNodePruned = removeCompletePathWithSumLess(nodesMap.get(1), 45);
    TreeTraversal.levelOrderTraversal(treeNodePruned, System.out::println);
    DemonstrationUtil.terminate();

  }

  public static void main(String[] args) {

    // testLowestCommonAncestor();
    // testBinaryToCircularLinkedList();
    // testremoveCompletePathWithSumLess();

  }

}
