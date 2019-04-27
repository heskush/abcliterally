package practice2018.coding.gfg.trees.binarytrees.basics;

import practice2018.language.java.util.DemonstrationUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// author -- hemantkumar
public class Miscellaneous {

    /*
     * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
     *
     * --------------------------RED--------------------------------
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

    public static void testLowestCommonAncestor() {
        System.out.println("Miscellaneous.testLowestCommonAncestor");
        TreeNode root = TreeGenerator.giveSampleBST();
        TreeTraversal.levelOrderTraversal(root, System.out::println);
        TreeNode lowestCommonAncestor = getLowestCommonAncestor(root, root.left.left, root.left.right);
        System.out.println(lowestCommonAncestor);
        DemonstrationUtil.terminate();

    }

    /*
     * https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
     *
     *
     * -------------------------RED--------------------------------
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

    public static void testBinaryToCircularLinkedList() {
        System.out.println("Miscellaneous.testBinaryToCircularLinkedList");
        Map<Integer, TreeNode> nodeMap = Arrays.stream(new Integer[]{10, 12, 15, 25, 30, 36})
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

    /*
     * https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
     *
     * ------------------------RED------------------------------
     */

    public static int findMaxPathSumBetweenTwoLeaves(TreeNode root) {

        RecursiveVal ans = new RecursiveVal();
        int maxRootToLeafPath = recurMaxPathBetweenTwoLeaves(root, ans);
        return ans.val;

    }

    public static int recurMaxPathBetweenTwoLeaves(TreeNode root, RecursiveVal ans) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return (int) root.data;
        }
        int leftChildMaxPath = recurMaxPathBetweenTwoLeaves(root.left, ans);
        int rightChildMaxPath = recurMaxPathBetweenTwoLeaves(root.right, ans);
        if (root.left != null && root.right != null) {
            ans.val = Math.max(ans.val, leftChildMaxPath + rightChildMaxPath + (int) root.data);
            return Math.max(leftChildMaxPath + (int) root.data, rightChildMaxPath + (int) root.data);

        }

        return root.left == null ? rightChildMaxPath + (int) root.data : leftChildMaxPath + (int) root.data;

    }

    public static void testfindMaxPathSumBetweenTwoLeaves() {
        TreeNode root =
                new TreeNode(
                        new TreeNode(new TreeNode(new TreeNode(null, null, 2), new TreeNode(null, null, 6), -8), new TreeNode(null, null, 1),
                                5),
                        new TreeNode(new TreeNode(null, null, 3),
                                new TreeNode(null,
                                        new TreeNode(new TreeNode(null, null, 4), new TreeNode(new TreeNode(null, null, 10), null, -1), 0), 9),
                                6),
                        -15);

        int maxPathSumBetweenTwoLeaves = findMaxPathSumBetweenTwoLeaves(root);
        // Should be 27
        System.out.println(maxPathSumBetweenTwoLeaves);
    }

    /*
     * TODO https://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
     *
     */

    public static TreeNode reverseAlternateLevelsOfPerfectBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        int level = 0;
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<TreeNode> children = new LinkedList<>();
        LinkedList<TreeNode> grandChildren = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            if (level % 2 == 0) { // The children of this level need to be reversed.
                for (TreeNode treeNode : nodeQueue) {
                    // A perfect would have either zero or 2 children
                    children.addLast(treeNode.left);
                    children.addLast(treeNode.right);
                    if (treeNode.left.left != null) {
                        grandChildren.addLast(treeNode.left.left);
                        grandChildren.addLast(treeNode.left.right);
                        grandChildren.addLast(treeNode.right.left);
                        grandChildren.addLast(treeNode.right.right);
                    }

                }

                Iterator<TreeNode> iteratorParent = nodeQueue.iterator();

            }

        }

        return null;
    }

    /*
     * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
     *
     * ------------------------RED--------------------------------------------
     */

    public static void printAllNodesAtKDistance(TreeNode root, Object targetNodeVal, int distance, Consumer<TreeNode> action) {
        RecursiveVal upwardDistance = new RecursiveVal();
        upwardDistance.val = -1;
        recurPrintAllNodesAtKDistance(root, targetNodeVal, -1, distance, action, upwardDistance);

    }

    private static boolean recurPrintAllNodesAtKDistance(TreeNode root, Object targetNodeVal, int distanceCovered,
                                                         int distanceNeeded, Consumer<TreeNode> action, RecursiveVal upwardDistance) {
        if (root == null) {
            return false;
        }
        // Target has been found in the ancestors
        if (distanceCovered != -1) {
            if (distanceCovered == distanceNeeded) {
                action.accept(root);
                return true;
            }
            if (distanceNeeded > distanceCovered) {
                recurPrintAllNodesAtKDistance(root.left, targetNodeVal, distanceCovered + 1, distanceNeeded, action, upwardDistance);
                recurPrintAllNodesAtKDistance(root.right, targetNodeVal, distanceCovered + 1, distanceNeeded, action, upwardDistance);
                return true;

            }

        }
        // Target hasn't been found in the ancestors
        if (distanceCovered == -1) {
            // Current node is the target node
            if (root.data.equals(targetNodeVal)) {
                upwardDistance.val = 0;
                recurPrintAllNodesAtKDistance(root.left, targetNodeVal, 1, distanceNeeded, action, upwardDistance);
                recurPrintAllNodesAtKDistance(root.right, targetNodeVal, 1, distanceNeeded, action, upwardDistance);
                return true;
            }
            // Find if the node is present in the left or the right subtree
            boolean presentInLeft = recurPrintAllNodesAtKDistance(root.left, targetNodeVal, -1, distanceNeeded, action, upwardDistance);
            boolean presentInRight =
                    recurPrintAllNodesAtKDistance(root.right, targetNodeVal, -1, distanceNeeded, action, upwardDistance);
            if (presentInLeft || presentInRight) {
                RecursiveVal reverseDistance = upwardDistance;
                // If the reverse distance is still less then the recursion should travel upwards
                if (reverseDistance.val < distanceNeeded) {
                    reverseDistance.val = reverseDistance.val + 1;
                    if (presentInLeft) {
                        recurPrintAllNodesAtKDistance(root.right, targetNodeVal, reverseDistance.val + 1, distanceNeeded, action,
                                reverseDistance);
                    }
                    if (presentInRight) {
                        recurPrintAllNodesAtKDistance(root.left, targetNodeVal, reverseDistance.val + 1, distanceNeeded, action,
                                reverseDistance);
                    }
                    return true;
                }
                if (reverseDistance.val == distanceNeeded) {
                    action.accept(root);
                    return false;
                }
            }
            return presentInLeft || presentInRight;
        }
        return false;

    }

    public static void testPrintAllNodesAtKDistance() {
        System.out.println("Miscellaneous.testPrintAllNodesAtKDistance");
        TreeNode root =
                new TreeNode(new TreeNode(TreeNode.leafNode(4), new TreeNode(TreeNode.leafNode(10), TreeNode.leafNode(14), 12), 8),
                        TreeNode.leafNode(22), 20);

        printAllNodesAtKDistance(root, 8, 2, System.out::println);
        DemonstrationUtil.terminate();
    }


    public static void main(String[] args) {

        // testLowestCommonAncestor();
        // testBinaryToCircularLinkedList();
        // testremoveCompletePathWithSumLess();
        // testfindMaxPathSumBetweenTwoLeaves();
        testPrintAllNodesAtKDistance();
    }

}

class RecursiveVal {
    int val = 0;

}
