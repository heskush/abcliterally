package practice.coding.self.trees;

// author -- hemantkumar
public class TestTrees {
  public static void main(String[] args) {
    TreeNode root = GenerateBinarySearchTree.generate(10);
    TreeNode sampleTreeRoot = GenerateBinarySearchTree.giveSampleTreeTenNodes();
    // TreeTraversal.recursivePreorderTraversal(sampleTreeRoot, System.out::println);
    // TreeTraversal.recursiveInorderTraversal(root, x -> System.out.println(x));
    // TreeTraversal.iterativeInorderTraversal(root, System.out::println);
    // TreeTraversal.iterativePreOrderTraversal(sampleTreeRoot, x -> System.out.println(x));
    // TreeTraversal.levelOrderTraversal(sampleTreeRoot, System.out::println);
    TreeTraversal.levelOrderTraversalReverse(sampleTreeRoot, System.out::println);

  }
}
