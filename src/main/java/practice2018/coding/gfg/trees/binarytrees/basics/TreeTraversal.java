package practice2018.coding.gfg.trees.binarytrees.basics;

import practice2018.language.java.util.DemonstrationUtil;

import java.util.LinkedList;
import java.util.Stack;
import java.util.function.Consumer;

// author -- hemantkumar

public class TreeTraversal {
    /*
     * Tree Traversal methods are important in the sense that several problems involving binary search tree that have a counterpart
     * in arrays (e.g. finding pair with given sum) can be solved using the same methods in trees using the traversal methods. e.g.
     * see this https://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
     */

    private TreeTraversal() {

    }

    public static void recursiveInorderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        // Base Case:
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            consumer.accept(treeNode);
            return;
        }
        recursiveInorderTraversal(treeNode.left, consumer);
        consumer.accept(treeNode);
        recursiveInorderTraversal(treeNode.right, consumer);

    }

    public static void recursivePreorderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        // Base Case:
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            consumer.accept(treeNode);
            return;
        }
        consumer.accept(treeNode);
        recursivePreorderTraversal(treeNode.left, consumer);
        recursivePreorderTraversal(treeNode.right, consumer);

    }

    public static void recursivePostorderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        // Base Case:
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            consumer.accept(treeNode);
            return;
        }
        recursivePostorderTraversal(treeNode.left, consumer);
        recursivePostorderTraversal(treeNode.right, consumer);
        consumer.accept(treeNode);

    }

    public static void iterativeInorderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        Stack<TreeNode> stack = new Stack<>();
        if (treeNode != null) {
            TreeNode stackNode = treeNode;
            while (!stack.isEmpty() || stackNode != null) {
                if (stackNode != null) {
                    stack.push(stackNode);
                    stackNode = stackNode.left;
                    continue;
                }
                if (stackNode == null) {
                    TreeNode t = stack.pop();
                    consumer.accept(t);
                    stackNode = t.right;
                    continue;
                }
            }
        }

    }

    public static void iterativePreOrderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        Stack<TreeNode> stack = new Stack<>();
        if (treeNode != null) {
            TreeNode currentNode = treeNode;
            stack.push(currentNode);
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                consumer.accept(t);
                if (t.right != null) {
                    stack.push(t.right);
                }
                if (t.left != null) {
                    stack.push(t.left);
                }

            }
        }

    }

    /*
     * This is different and more difficult than the previous two because the corresponding recursion is not tail recursive because
     * we even need to print the node after the recursive call has been made to it's left and right nodes.
     */
    public static void iterativePostOrderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        Stack<TreeNode> stack = new Stack<>();

    }

    /*
     * https://www.geeksforgeeks.org/level-order-tree-traversal/
     *
     * In level order traversal one important thing to keep in mind is that one can keep track of all the nodes present at a certain
     * level.
     *
     * NOTE: There is an alternate version of the same algorithm where we can use two queues to practically do the same thing.
     *
     * https://www.geeksforgeeks.org/level-order-traversal-line-line-set-2-using-two-queues/
     */

    public static void levelOrderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
        if (treeNode == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            int currentLevelCount = queue.size();
            DemonstrationUtil.terminate();
            for (int i = 0; i <= currentLevelCount - 1; i++) {
                TreeNode first = queue.removeFirst();
                consumer.accept(first);
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
            }
        }

    }

    /*
     * https://www.geeksforgeeks.org/reverse-level-order-traversal/
     */
    public static void levelOrderTraversalReverse(TreeNode treeNode, Consumer<TreeNode> consumer) {
        if (treeNode == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.push(treeNode);
        while (!queue.isEmpty()) {
            int currentLevelCount = queue.size();
            for (int i = 0; i < currentLevelCount; i++) {
                TreeNode firstNode = queue.removeFirst();
                stack.push(firstNode);
                if (firstNode.right != null) {
                    queue.addLast(firstNode.right);
                }
                if (firstNode.left != null) {
                    queue.addLast(firstNode.left);

                }

            }

        }

        while (!stack.isEmpty()) {
            consumer.accept(stack.pop());
        }

    }

    /*
     *
     *
     * https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
     */

    public static void alternateLevelOrderTraversal(TreeNode root, Consumer<TreeNode> consumer) {
        if (root == null) {
            return;
        }
        consumer.accept(root);
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        LinkedList<TreeNode> source;
        LinkedList<TreeNode> target;
        list1.add(root.left);
        list1.add(root.right);
        while (!list1.isEmpty() || !list2.isEmpty()) {
            source = list1.isEmpty() ? list2 : list1;
            target = list1.isEmpty() ? list1 : list2;
            int n = source.size();
            LinkedList<TreeNode> right = new LinkedList<>();
            for (int i = 0; i < n / 2; i++) {
                TreeNode leftNode = source.get(i);
                TreeNode rightNode = source.get(n - i - 1);
                consumer.accept(leftNode);
                consumer.accept(rightNode);
                if (leftNode.left != null) {
                    target.add(leftNode.left);
                }
                if (leftNode.right != null) {
                    target.add(leftNode.right);
                }
                if (rightNode.right != null) {
                    right.addFirst(rightNode.right);
                }
                if (rightNode.left != null) {
                    right.addFirst(rightNode.left);
                }

            }
            target.addAll(right);
            source.clear();

        }

    }

    public static void main(String[] args) {

        alternateLevelOrderTraversal(TreeGenerator.generatePerfectBinaryTree(5), x -> System.out.println((Integer) x.data + 1));

        // levelOrderTraversal(TreeGenerator.generatePerfectBinaryTree(5), System.out::println);

    }

}
