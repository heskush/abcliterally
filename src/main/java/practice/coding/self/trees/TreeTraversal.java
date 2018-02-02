package practice.coding.self.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

import practice.language.util.DemonstrationUtil;

// author -- hemantkumar

public class TreeTraversal {
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

  public static void iterativePostOrderTraversal(TreeNode treeNode, Consumer<TreeNode> consumer) {
    Stack<TreeNode> stack = new Stack<>();

  }

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

  // Works for both PreOrder and level order traversal.
  public static <T> TreeNode constructTreeFromInorderAndPreorderTraversal(List<T> inOrder, List<T> preOrder) {
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
    rootNode.left = constructTreeFromInorderAndPreorderTraversal(leftInOrder, leftPreOrder);
    rootNode.right = constructTreeFromInorderAndPreorderTraversal(rightInOrder, rightPreOrder);
    return rootNode;

  }

}
