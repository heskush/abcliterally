package practice.coding.gfg.trees;

// author -- hemantkumar
public class TreeNode {
  TreeNode left;
  TreeNode right;
  Object data;

  public TreeNode(TreeNode left, TreeNode right, Object data) {
    this.left = left;
    this.right = right;
    this.data = data;
  }

  @Override
  public String toString() {
    return "TreeNode{" + "data=" + data + '}';
  }
}
