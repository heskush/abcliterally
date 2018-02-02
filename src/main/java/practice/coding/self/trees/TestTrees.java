package practice.coding.self.trees;

import java.util.Arrays;

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
    // TreeTraversal.levelOrderTraversalReverse(sampleTreeRoot, System.out::println);
    TreeNode n = TreeTraversal.constructTreeFromInorderAndPreorderTraversal(Arrays.asList(4, 8, 10, 12, 14, 20, 22),
        Arrays.asList(20, 8, 22, 4, 12, 10, 14));
    TreeTraversal.levelOrderTraversal(n, System.out::println);
  }
}
