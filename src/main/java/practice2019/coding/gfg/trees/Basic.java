package practice2019.coding.gfg.trees;

import practice2019.coding.gfg.helper.Tree;
import practice2019.coding.gfg.helper.TreeNode;

import java.util.HashMap;
import java.util.Stack;

public class Basic {

    public static void main(String[] args) {
//        recursiveInorderTraversal(Tree.getUnmutableTreeRoot());
//        recursivePreorderTraversal(Tree.getUnmutableTreeRoot());
//        recursivePostorderTraversal(Tree.getUnmutableTreeRoot());
//        iterativeInorderTraversal(Tree.getUnmutableTreeRoot());
//        iterativePreOrderTraversal(Tree.getUnmutableTreeRoot());
//        System.out.println();
        iterativePostOrderTraversal(Tree.getUnmutableTreeRoot());
//        iterativePreorder(Tree.getUnmutableTreeRoot());

    }

    public static void recursiveInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveInorderTraversal(root.left);
        System.out.println(root.data);
        recursiveInorderTraversal(root.right);
    }

    public static void recursivePostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        recursivePostorderTraversal(root.left);
        recursivePostorderTraversal(root.right);
        System.out.println(root.data);
    }

    public static void recursivePreorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        recursivePreorderTraversal(root.left);
        recursivePreorderTraversal(root.right);
    }


    public static void iterativeInorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
                continue;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }

    public static void iterativePreorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (stack.size() != 0 || current != null) {
            if (current != null) {
                System.out.println(current.data);
                stack.push(current.right);
                current = current.left;
                continue;
            }
            current = stack.pop();
        }
    }

    public static void iterativePostOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastPrinted = null;
        TreeNode lastElement;
        while (stack.size() != 0 || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
                continue;
            }
            lastElement = stack.peek();
            if (lastElement.right != null && lastElement.right != lastPrinted) {
                current = lastElement.right;
                continue;
            }
            System.out.println(lastElement.data);
            lastPrinted = lastElement;
            current = null;
            stack.pop();
        }
    }
}


