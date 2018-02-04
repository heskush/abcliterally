package practice.coding.gfg.trees;

import java.util.Arrays;
import java.util.stream.Collectors;

// author -- hemantkumar
public class TestTrees {
  public static void main(String[] args) {
    TreeNode root = TreeGenerator.generateBST(10);
    TreeNode sampleTreeRoot = TreeGenerator.giveSampleBST();
    // TreeTraversal.recursivePreorderTraversal(sampleTreeRoot, System.out::println);
    // TreeTraversal.recursiveInorderTraversal(root, x -> System.out.println(x));
    // TreeTraversal.iterativeInorderTraversal(root, System.out::println);
    // TreeTraversal.iterativePreOrderTraversal(sampleTreeRoot, x -> System.out.println(x));
    // TreeTraversal.levelOrderTraversal(sampleTreeRoot, System.out::println);
    // TreeTraversal.levelOrderTraversalReverse(sampleTreeRoot, System.out::println);
    // TreeNode n = TreeTraversal.constructFromInAndPreTraversal(Arrays.asList(4, 8, 10, 12, 14, 20, 22),
    // Arrays.asList(20, 8, 22, 4, 12, 10, 14));

    TreeNode n = TreeConstruction.constructFullTreeFromPreAndPost(
        Arrays.stream(new Integer[] { 1, 2, 4, 8, 9, 5, 3, 6, 7 }).collect(Collectors.toList()),
        Arrays.stream(new Integer[] { 8, 9, 4, 5, 2, 6, 7, 3, 1 }).collect(Collectors.toList()));

    TreeTraversal.levelOrderTraversal(n, System.out::println);
  }
}
