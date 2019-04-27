package practice2018.coding.gfg.graphs.basics;

import practice2018.language.java.util.DemonstrationUtil;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;

// author -- hemantkumar
public class CycleDetection {


    static class CycleDetectionUsingDFSForDirected {
        static Graph graph = Graph.createDirectedGraph(4).addEdge(0, 1).addEdge(0, 2).addEdge(1, 2).addEdge(2, 0).addEdge(2, 3).addEdge(3, 3);

        static boolean execute() {
            int vertices = graph.getVertices();
            BitSet visitedNodes = new BitSet(vertices);
            for (int i = 0; i < graph.getVertices(); i++) {
                if (!visitedNodes.get(i)) {
                    boolean cycleFound = cyclicTestDFS(i, new HashSet<Integer>());
                    if (cycleFound) {
                        return cycleFound;
                    }

                }

            }

            return false;
        }

        static boolean cyclicTestDFS(int vertex, HashSet recursionStack) {
            if (recursionStack.contains(vertex)) {
                return true;
            }
            recursionStack.add(vertex);
            ArrayList<Integer> adjacentNodes = graph.adjacencyList.get(vertex);
            for (int i = 0; i < adjacentNodes.size(); i++) {
                boolean cycleFound = cyclicTestDFS(i, recursionStack);
                if (cycleFound) {
                    return cycleFound;
                }

            }
            return false;


        }

        static void demonstrate() {
            System.out.println("CycleDetectionUsingDFSForDirected.demonstrate");
            boolean cycleFound = execute();
            System.out.println("Cycle Found :" + cycleFound);
            DemonstrationUtil.terminate();
        }


    }


    static class CycleDetectionUsingUnionFindForUndirected {


    }

    static class CycleDetectionUsingDFSForUndirected {
        

    }

    public static void main(String[] args) {


        CycleDetectionUsingDFSForDirected.demonstrate();

    }


}
