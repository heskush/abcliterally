package practice.coding.gfg.trees;

// author -- hemantkumar
public class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public Object data;

  public TreeNode(TreeNode left, TreeNode right, Object data) {
    this.left = left;
    this.right = right;
    this.data = data;
  }

  public static TreeNode leafNode(Object val) {
    return new TreeNode(null, null, val);

  }

  @Override
  public String toString() {
    return "TreeNode{" + "data=" + data + '}';
  }
}
