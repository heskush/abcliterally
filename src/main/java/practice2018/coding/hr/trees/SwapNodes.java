package practice2018.coding.hr.trees;

// author -- hemantkumar

/*
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem
 */

import practice2018.coding.gfg.trees.binarytrees.basics.TreeNode;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SwapNodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        Map<Integer, TreeNode> valToNodeMap = IntStream.rangeClosed(1, nodes).mapToObj(x -> x)
                .collect(Collectors.toMap(Function.identity(), x -> TreeNode.leafNode(x)));
        for (int i = 0; i < nodes; i++) {
            String[] nodeIndex = scanner.nextLine().split(" ");
            TreeNode treeNode = valToNodeMap.get(i + 1);
            int left = Integer.parseInt(nodeIndex[0]);
            int right = Integer.parseInt(nodeIndex[1]);
            treeNode.left = left == -1 ? null : valToNodeMap.get(left);
            treeNode.right = right == -1 ? null : valToNodeMap.get(right);
        }

    }
}
