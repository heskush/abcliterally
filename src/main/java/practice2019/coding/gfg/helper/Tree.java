package practice2019.coding.gfg.helper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tree {
   static private TreeNode unmutableTreeRoot;


    static {
        List<TreeNode> treeNodeList =
                IntStream.rangeClosed(0, 10).mapToObj(x -> new TreeNode(x, null, null)).collect(Collectors.toList());
        // Left Subtree
        treeNodeList.get(5).left = treeNodeList.get(3);
        treeNodeList.get(3).left = treeNodeList.get(1);
        treeNodeList.get(3).right = treeNodeList.get(4);
        treeNodeList.get(1).right = treeNodeList.get(2);

        // Right Subtree
        treeNodeList.get(5).right = treeNodeList.get(7);
        treeNodeList.get(7).left = treeNodeList.get(6);
        treeNodeList.get(7).right = treeNodeList.get(9);
        treeNodeList.get(9).left = treeNodeList.get(8);
        treeNodeList.get(9).right = treeNodeList.get(10);
        unmutableTreeRoot = treeNodeList.get(5);
    }

    public static TreeNode getUnmutableTreeRoot() {
        return unmutableTreeRoot;
    }
}
