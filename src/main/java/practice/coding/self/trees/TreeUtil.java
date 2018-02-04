package practice.coding.self.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import practice.coding.gfg.trees.TreeNode;

// author -- hemantkumar
public class TreeUtil {

  // TODO: COMPLETE THE METHOD
  public static void prettyPrintBinaryTree(TreeNode root) {
    if (root == null) {
      return;
    }
    HashMap<Integer, LinkedList<TreeNode>> levelToTreeNodesMap = new HashMap<>();

    levelToTreeNodesMap.put(0, new LinkedList<TreeNode>());
    levelToTreeNodesMap.get(0).add(root);
    boolean moreLevels = root.left != null || root.right != null ? true : false;
    int lastLevel = 0;
    while (moreLevels) {
      moreLevels = false;
      LinkedList<TreeNode> treeNodes = levelToTreeNodesMap.get(lastLevel);
      levelToTreeNodesMap.put(lastLevel + 1, new LinkedList<TreeNode>());
      for (TreeNode node : treeNodes) {
        if (node.left != null) {
          moreLevels = true;
          levelToTreeNodesMap.get(lastLevel + 1).add(node.left);
        }
        if (node.right != null) {
          moreLevels = true;
          levelToTreeNodesMap.get(lastLevel + 1).add(node.right);
        }
      }
      lastLevel++;
      if (!moreLevels) {
        levelToTreeNodesMap.remove(lastLevel + 1);
      }
    }

    HashMap<TreeNode, Integer> nodeToDescendantsCount = new HashMap<>();
    Iterator<Integer> levelIterator = levelToTreeNodesMap.keySet().iterator();
    while (levelIterator.hasNext()) {
      Integer level = levelIterator.next();
      LinkedList<TreeNode> treeNodes = levelToTreeNodesMap.get(level);

    }

  }

  public static int findNodeCount(TreeNode root, HashMap<TreeNode, Integer> nodeDescendantsCount) {

    if (root == null) {
      return 0;
    }
    if (nodeDescendantsCount.get(root) != null) {
      return nodeDescendantsCount.get(root);
    }
    int nodeCount = findNodeCount(root.left, nodeDescendantsCount) + findNodeCount(root.right, nodeDescendantsCount) + 1;
    nodeDescendantsCount.put(root, nodeCount);
    return nodeCount;

  }

}
