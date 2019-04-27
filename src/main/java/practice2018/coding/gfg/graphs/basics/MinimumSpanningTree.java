package practice2018.coding.gfg.graphs.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// author -- hemantkumar
public class MinimumSpanningTree {

    /*The time complexity of this is O(V^2). A careless calaculation might give one O(V^3) complexity.
     Explanation: 1. For each vertex ,: O(V)
                    2. find the minimum cost vertex from a minimum cost array :O(V)
                            3.For the minimum vertex found update the minimum cost to all it's vertices. : O(V)
     This gives O(V^3).
But the last two iteration are not nested inside each other they are in sequence. So their combined complexity is O(2V)
and this gives the total complexity to be O(2V^2)

The step 2 can be reduced in complexity by using a binary heap to store the minimum cost vertex but the overall complexity would still be O(V^2)
     * */
    static class PrimUsingMatrix {
        private static int[][] adjacencyMatrix = {
                {-1, 2, -1, 6, -1},
                {2, -1, 3, 8, 5},
                {-1, 3, -1, -1, 7},
                {6, 8, -1, -1, 9},
                {-1, 5, 7, 9, -1},
        };

        public static int[] execute() {
            int vertices = adjacencyMatrix.length;
            int[] keyVal = new int[vertices];
            Arrays.fill(keyVal, Integer.MAX_VALUE);
            keyVal[0] = 0;
            BitSet bitSet = new BitSet(vertices);
            int[] parentArr = IntStream.range(0, vertices).toArray();

            for (int i = 0; i < vertices; i++) {
                int nextVertex = findMin(bitSet, keyVal);
                updateWeightsAndParentArr(keyVal, nextVertex, parentArr);
                bitSet.set(nextVertex);
            }
            return parentArr;

        }

        private static void updateWeightsAndParentArr(int[] keyVal, int nextVertex, int[] parentArr) {
            int vertices = adjacencyMatrix.length;
            for (int i = 0; i < vertices; i++) {
                if (i != nextVertex && adjacencyMatrix[nextVertex][i] != -1) {
                    int oldCost = keyVal[i];
                    int newCost = adjacencyMatrix[nextVertex][i];
                    if (oldCost > newCost) {
                        keyVal[i] = newCost;
                        parentArr[i] = nextVertex;

                    }
                }
            }
        }

        private static int findMin(BitSet bitSet, int[] keyVal) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < keyVal.length; i++) {
                if (keyVal[i] < min && !bitSet.get(i)) {
                    min = keyVal[i];
                    minIndex = i;
                }
            }

            return minIndex;


        }

        public static void demonstrate() {
            int[] parentArr = execute();
            for (int i = 0; i < parentArr.length; i++) {
                System.out.println(String.format("%d -- %d : %d", parentArr[i], i, adjacencyMatrix[i][parentArr[i]]));
            }
            System.out.println("PrimUsingMatrix.demonstrate");


        }

    }


    static class PrimUsingAdjacencyList {
        static Graph graph = Graph.createUndirectedGraph(10);

        static class CostNode {
            int cost;
            int vertex;

            public CostNode(int vertex) {
                this.vertex = vertex;
                this.cost = Integer.MAX_VALUE;
            }
        }

        public static int[] execute() {
            int vertices = graph.getVertices();
            PriorityQueue<CostNode> heap = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
            heap.addAll(IntStream.range(0, vertices).mapToObj(x -> new CostNode(x)).collect(Collectors.toList()));
            heap.peek().cost = 0;
            BitSet bitSet = new BitSet(vertices);
            int[] parentArr = IntStream.range(0, vertices).toArray();
            for (int i = 0; i < vertices; i++) {
                CostNode minVal = heap.poll();
                updateCostandParentArr(minVal.vertex);

            }


            return null;

        }

        public static void updateCostandParentArr(int vertex) {
            ArrayList<Integer> attachedNodes = graph.adjacencyList.get(vertex);
            for (int i = 0; i < attachedNodes.size(); i++) {
                int oldWeight = 0;
            }

        }


    }

    public static void main(String[] args) {
        PrimUsingMatrix.demonstrate();

    }
}
