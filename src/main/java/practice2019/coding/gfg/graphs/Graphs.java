package practice2019.coding.gfg.graphs;

import practice2019.coding.gfg.helper.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graphs {

    public static void main(String[] args) {
        BFSTraversal(Graph.sampleConnectedGraphWithCycle);
        BFSTraversal(Graph.sampleDisconnectedGraphWithCycle);
        DFSTraversal(Graph.sampleConnectedGraphWithCycle);
        DFSTraversal(Graph.sampleDisconnectedGraphWithCycle);
        isUndirectedGraphCyclic(Graph.sampleConnectedGraphWithCycle);
        isUndirectedGraphCyclic(Graph.sampleGraphWithoutCycle);
        isDirectedGraphCyclic(Graph.sampleDirectedGraphWithCycle);
        isDirectedGraphCyclic(Graph.sampleDirectedGraphWithoutCycle);
        topologicalSortUsingDFS(Graph.sampleDirectedGraphWithoutCycle);
    }

    public static void BFSTraversal(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.vertices - 1; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                BFSUtil(graph, queue, visited);
            }

        }
        System.out.println();
    }

    private static void BFSUtil(Graph graph, LinkedList<Integer> queue, boolean[] visited) {
        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            System.out.printf("%s,", vertex);
            Iterator<Integer> iterator = graph.adjacencyList.get(vertex).iterator();
            while (iterator.hasNext()) {
                int neighbour = iterator.next();
                if (!visited[neighbour]) {
                    queue.addLast(neighbour);
                    visited[neighbour] = true;
                }
            }

        }
    }

    public static void DFSTraversal(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                DFSUtil(graph, i, visited);
            }
        }
        System.out.println();
    }

    private static void DFSUtil(Graph graph, int vertex, boolean[] visited) {
        System.out.printf("%s,", vertex);
        visited[vertex] = true;
        Iterator<Integer> iterator = graph.adjacencyList.get(vertex).iterator();
        while (iterator.hasNext()) {
            int neighbour = iterator.next();
            if (!visited[neighbour]) {
                DFSUtil(graph, neighbour, visited);
            }
        }
    }

    public static void isUndirectedGraphCyclic(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        boolean isCyclic = isUndirectedGraphCyclicHelper(graph, 0, -1, visited);
        System.out.printf("Is Graph Cyclic? %b%n", isCyclic);
    }

    private static boolean isUndirectedGraphCyclicHelper(Graph graph, int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;
        Iterator<Integer> iterator = graph.adjacencyList.get(vertex).iterator();
        while (iterator.hasNext()) {
            int neighbour = iterator.next();
            if (visited[neighbour] && neighbour != parent) {
                return true;
            } else if (!visited[neighbour]) {
                if (isUndirectedGraphCyclicHelper(graph, neighbour, vertex, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void isDirectedGraphCyclic(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        boolean[] inStack = new boolean[graph.vertices];
        boolean isCyclic = false;
        for (int i = 0; i < graph.vertices; i++) {
            if (isDirectedGraphCyclicHelper(graph, i, visited, inStack)) {
                isCyclic = true;
                break;
            }
        }
        System.out.printf("The Graph is cyclic? %b%n", isCyclic);

    }

    private static boolean isDirectedGraphCyclicHelper(Graph graph, int vertex, boolean[] visited, boolean[] inStack) {
        if (inStack[vertex]) {
            return true;
        }
        inStack[vertex] = true;
        if (visited[vertex]) {
            return false;
        }
        for (Integer integer : graph.adjacencyList.get(vertex)) {
            if (isDirectedGraphCyclicHelper(graph, integer, visited, inStack)) {
                return true;
            }
        }
        inStack[vertex] = false;
        return false;
    }

    public static void topologicalSortUsingDFS(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.vertices; i++) {
            topologicalSortUsingDFSHelper(graph, visited, stack, i);
        }
        while (stack.size() > 0) {
            System.out.printf("%d,", stack.pop());
        }
        System.out.println();
    }

    private static void topologicalSortUsingDFSHelper(Graph graph, boolean[] visited, Stack<Integer> stack, int vertex) {
        if (visited[vertex]) {
            return;
        }
        for (Integer integer : graph.adjacencyList.get(vertex)) {
            topologicalSortUsingDFSHelper(graph, visited, stack, integer);
        }
        visited[vertex] = true;
        stack.push(vertex);
    }
}
