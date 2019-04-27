package practice2018.coding.gfg.trees.binarytrees.binarysearchtrees;

import practice2018.coding.gfg.trees.binarytrees.basics.TreeNode;

// author -- hemantkumar
public class SmallestLartgestInBST {

    /*
     *
     * https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
     */

    static class FindKthSmallestElement {
        static TreeNode root =
                new TreeNode(new TreeNode(TreeNode.leafNode(4), new TreeNode(TreeNode.leafNode(10), TreeNode.leafNode(14), 12), 8),
                        TreeNode.leafNode(22), 20);

        static class RecursiveVal {
            TreeNode node;

            public RecursiveVal(TreeNode node) {
                this.node = node;
            }
        }

        public static TreeNode execute() {
            RecursiveVal kthNodeHolder = new RecursiveVal(null);
            recur(root, 3, kthNodeHolder);
            return kthNodeHolder.node;

        }

        static int recur(TreeNode node, int k, RecursiveVal kthNode) {
            // BASE CASE
            if (node == null) {
                return 0;
            }
            int fromLeft = recur(node.left, k, kthNode);
            if (fromLeft == -1) {
                return -1;
            }
            if (fromLeft == k - 1) {
                kthNode.node = node;
                return -1;
            }
            int fromRight = recur(node.right, k - (fromLeft + 1), kthNode);
            if (fromRight == -1) {
                return -1;
            } else {
                return fromLeft + fromRight + 1;
            }

        }

        static void demonstrate() {
            TreeNode kthNode = execute();
            System.out.println(kthNode.data);
        }

    }

    // TODO :https://www.geeksforgeeks.org/check-for-identical-bsts-without-building-the-trees/

    public static void main(String[] args) {

        FindKthSmallestElement.demonstrate();
    }
}
