package practice.coding.gfg.trees.binarytrees.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// author -- hemantkumar
public class TreeConstruction {

    /*
     * TODO: COMPLETE IT
     *
     * https://www.geeksforgeeks.org/construct-tree-from-ancestor-matrix/
     */
    public static TreeNode fromAncestorMatrix(ArrayList<BitSet> bitMatrix) {
        Map<Integer, BitSet> bitSetMap =
                IntStream.rangeClosed(1, 10).mapToObj(x -> x).collect(Collectors.toMap(Function.identity(), x -> bitMatrix.get(x)));
        List<Integer> descendantCount =
                IntStream.rangeClosed(0, bitMatrix.size() - 1).mapToObj(x -> bitMatrix.get(x).cardinality()).collect(Collectors.toList());

        // Bottom Up Approach:
        Map<Integer, List<TreeNode>> descendantCountToNodes =
                IntStream.rangeClosed(0, bitMatrix.size() - 1).mapToObj(x -> new TreeNode(null, null, x))
                        .collect(Collectors.groupingBy(x -> descendantCount.get(((Integer) ((TreeNode) x).data))));

        for (int i = 0; i < bitMatrix.size() - 1; i = i + 2) {
            List<TreeNode> childNodes = descendantCountToNodes.get(i);
            List<TreeNode> parentNodes = descendantCountToNodes.get(i + 1);

        }

        return null;
    }

    /*
     * TREE CONSTRUCTION FROM TRAVERSAL ORDERS: For tree construction from the traversal the main issue is to find the root, and
     * split the remaining traversal into the traversal for left and right tree. For a binary tree, inorder traversal complimented
     * with (preorder,postorder or level order)is the only way to construct a generic binary tree. For any other combination one has
     * to have some other information to remove ambiguity.
     *
     * The combination of inorder and preorder(or postorder) is also usueful when trying to determine if one tree is a subtree of
     * another tree. Then the inorder and preorder(or postorder) would be a substring of the parent tree's traversal.
     */

    // Works for both PreOrder and level order traversal.
    public static <T> TreeNode constructFromInAndPreTraversal(List<T> inOrder, List<T> preOrder) {
        // Assume that the first element of the preOrder is the root.
        // BASE CASE: only one element left.
        if (inOrder.size() == 0) {
            return null;
        }
        if (inOrder.size() == 1) {
            return new TreeNode(null, null, inOrder.get(0));
        }
        int n = inOrder.size();
        T subtreeRoot = preOrder.get(0);
        int rootIndex = inOrder.indexOf(subtreeRoot);

        ArrayList<T> leftInOrder = rootIndex != 0 ? new ArrayList<>(inOrder.subList(0, rootIndex)) : new ArrayList<>();
        ArrayList<T> rightInOrder = rootIndex != n - 1 ? new ArrayList<>(inOrder.subList(rootIndex + 1, n)) : new ArrayList<>();

        ArrayList<T> leftPreOrder = new ArrayList<>(preOrder);
        ArrayList<T> rightPreOrder = new ArrayList<>(preOrder);
        leftPreOrder.retainAll(leftInOrder);
        rightPreOrder.retainAll(rightInOrder);
        TreeNode rootNode = new TreeNode(null, null, subtreeRoot);
        rootNode.left = constructFromInAndPreTraversal(leftInOrder, leftPreOrder);
        rootNode.right = constructFromInAndPreTraversal(rightInOrder, rightPreOrder);
        return rootNode;

    }

    // https://www.geeksforgeeks.org/full-and-complete-binary-tree-from-given-preorder-and-postorder-traversals/
    // The traversal combinations is pre and post: but we also have one more information i.e. the tree is a full binary tree.

    public static <T> TreeNode constructFullTreeFromPreAndPost(List<T> preOrder, List<T> postOrder) {

        if (preOrder.size() == 1) {
            return new TreeNode(null, null, preOrder.get(0));
        }

        T root = preOrder.get(0);
        int n = preOrder.size();

        T leftChild = preOrder.get(1);
        int leftChildPostIndex = postOrder.indexOf(leftChild);
        List<T> leftPostOrder = postOrder.subList(0, leftChildPostIndex + 1);
        List<T> rightPostOrder = postOrder.subList(leftChildPostIndex + 1, n); // Exclude the root

        T rightChild = postOrder.get(n - 2);
        int rightChildPreIndex = preOrder.indexOf(rightChild);
        List<T> leftPreOrder = preOrder.subList(1, rightChildPreIndex);// Exclude the root.
        List<T> rightPreOrder = preOrder.subList(rightChildPreIndex, n);

        return new TreeNode(constructFullTreeFromPreAndPost(leftPreOrder, leftPostOrder),
                constructFullTreeFromPreAndPost(rightPreOrder, rightPostOrder), root);

    }

    public static void testConstructFullTreeFromPreAndPost() {
        TreeNode root =
                constructFullTreeFromPreAndPost(Arrays.stream(new Integer[]{1, 2, 4, 8, 9, 5, 3, 6, 7}).collect(Collectors.toList()),
                        Arrays.stream(new Integer[]{8, 9, 4, 5, 2, 6, 7, 3, 1}).collect(Collectors.toList()));

        TreeTraversal.levelOrderTraversal(root, System.out::println);

    }

    /*
     * https://www.geeksforgeeks.org/construct-a-binary-tree-from-parent-array-representation/
     */

    public static TreeNode constructTreeFromLinkedListRepresentation(List<Integer> linkedListrepresentation) {
        // Construct unrelated tree nodes
        int n = linkedListrepresentation.size();
        Map<Integer, TreeNode> treeNodeMap = IntStream.rangeClosed(0, n - 1).mapToObj(x -> x)
                .collect(Collectors.toMap(Function.identity(), x -> new TreeNode(null, null, x)));

        // Set the left and right nodes accordingly
        IntStream.rangeClosed(0, n - 1).forEach(x -> {
            int parentVal = linkedListrepresentation.get(x);
            if (parentVal == -1) {
                return;
            }
            TreeNode parentNode = treeNodeMap.get(parentVal);
            if (parentNode.left == null) {
                parentNode.left = treeNodeMap.get(x);
            } else {
                parentNode.right = treeNodeMap.get(x);
            }

        });
        return treeNodeMap.get(0);

    }

    public static void main(String[] args) {

        TreeNode treeNode = constructTreeFromLinkedListRepresentation(
                Arrays.stream(new Integer[]{-1, 0, 0, 1, 1, 3, 5}).collect(Collectors.toList()));

        TreeNode treeNode1 =
                constructFullTreeFromPreAndPost(Arrays.stream(new Integer[]{1, 2, 4, 8, 9, 5, 3, 6, 7}).collect(Collectors.toList()),
                        Arrays.stream(new Integer[]{8, 9, 4, 5, 2, 6, 7, 3, 1}).collect(Collectors.toList()));

        TreeTraversal.levelOrderTraversal(treeNode, System.out::println);

    }

}
