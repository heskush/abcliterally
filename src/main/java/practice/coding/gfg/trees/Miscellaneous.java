package practice.coding.gfg.trees;

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

  public static void main(String[] args) {
    TreeNode root = TreeGenerator.giveSampleBST();
    TreeTraversal.levelOrderTraversal(root, System.out::println);
    TreeNode lowestCommonAncestor = getLowestCommonAncestor(root, root.left.left, root.left.right);
    System.out.println(lowestCommonAncestor);

  }

}
