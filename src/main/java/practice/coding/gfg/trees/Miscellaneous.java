package practice.coding.gfg.trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import practice.language.java.util.DemonstrationUtil;

// author -- hemantkumar
public class Miscellaneous {

  /*
   * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
   *
   * Should be done in single traversal
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

  public static void main(String[] args) {
    testLowestCommonAncestor();
    testBinaryToCircularLinkedList();

  }

}
