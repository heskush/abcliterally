package practice.coding.self.trees;

// author -- hemantkumar
public class TestTrees {
  public static void main(String[] args) {
    TreeNode root = GenerateBinarySearchTree.generate(5);
    TreeTraversal.recursivePreorderTraversal(root, System.out::println);
    // TreeTraversal.recursiveInorderTraversal(root, x -> System.out.println(x));
    // TreeTraversal.iterativeInorderTraversal(root, System.out::println);
    TreeTraversal.iterativePreOrderTraversal(root, x -> System.out.println(x));

  }
}
