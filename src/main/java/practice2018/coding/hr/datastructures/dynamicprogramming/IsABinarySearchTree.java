package practice2018.coding.hr.datastructures.dynamicprogramming;

// author -- hemantkumar

public class IsABinarySearchTree {
    boolean checkBST(Node root) {
        return chectBstWithRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean chectBstWithRange(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (min < root.data && root.data < max) {
            return chectBstWithRange(root.left, min, root.data) && chectBstWithRange(root.right, root.data, max);
        }
        return false;
    }

}

class Node {
    int data;
    Node left;
    Node right;
}
