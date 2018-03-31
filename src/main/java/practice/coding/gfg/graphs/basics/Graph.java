package practice.coding.gfg.graphs.basics;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// author -- hemantkumar
public class Graph {
    int v;
    public ArrayList<ArrayList<Integer>> adjacencyList;
    public boolean isDirected;


    public int getVertices() {
        return v;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public static Graph createUndirectedGraph(int vertices) {
        return new Graph(vertices, false);
    }

    public static Graph createDirectedGraph(int vertices) {
        return new Graph(vertices, true);
    }

    private Graph(int v, boolean isDirected) {
        this.v = v;
        adjacencyList = (ArrayList<ArrayList<Integer>>) IntStream.rangeClosed(0, v - 1).mapToObj(ArrayList<Integer>::new).collect(Collectors.toList());
        this.isDirected = isDirected;
    }

    public Graph addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        if (!isDirected) {
            adjacencyList.get(v).add(u);
        }
        return this;

    }


    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("adjacency list for vertex " + i + " is ");
            String s = adjacencyList.get(i).stream().map(Object::toString).collect(Collectors.joining("|"));
            System.out.println(s);
        }
    }

    public void reverseGraphInPlace() {
        ArrayList<ArrayList<Integer>> newAdjacency = new ArrayList<>();
        IntStream.rangeClosed(0, v - 1).forEach(x -> newAdjacency.add(x, new ArrayList<Integer>()));
        IntStream.rangeClosed(0, v - 1).forEach(x -> adjacencyList.get(x).stream().forEach(i -> newAdjacency.get(i).add(x)));
        adjacencyList = newAdjacency;
    }


    public BitSet breadthFirstTraversalFromVertex(Consumer<Integer> consumer, int startingVertex, BitSet visitedNodes) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(startingVertex);
        while (!queue.isEmpty()) {
            Integer integer = queue.removeFirst();
            if (!visitedNodes.get(integer)) {
                consumer.accept(integer);
                visitedNodes.set(integer);
                adjacencyList.get(integer).stream().forEach(queue::add);
            }

        }

        return visitedNodes;

    }


    public void breadthFirstTraversal(Consumer<Integer> consumer) {
        BitSet nodesVisited = new BitSet(v);
        for (int i = 0; i < v; i++) {
            if (!nodesVisited.get(i)) {
                breadthFirstTraversalFromVertex(consumer, i, nodesVisited);
                if (nodesVisited.cardinality() < v) {
                    continue;
                }
                break;
            }
        }
    }

    public void depthFirstTraversal(Consumer<Integer> consumer, Consumer<Integer> postProcessingChildren) {
        BitSet visitedNodes = new BitSet(v);
        for (int i = 0; i < v; i++) {
            if (!visitedNodes.get(i)) {
                depthFirstFromVertex(i, consumer, visitedNodes, postProcessingChildren);
                if (visitedNodes.cardinality() < v) {
                    continue;
                }
                break;
            }
        }
    }

    public BitSet depthFirstFromVertex(int parentVertex, Consumer<Integer> consumer, BitSet visitedNodes, Consumer<Integer> postProcesssingChildren) {
        consumer.accept(parentVertex);
        visitedNodes.set(parentVertex);
        ArrayList<Integer> adjacentNodes = adjacencyList.get(parentVertex);
        for (int i1 = 0; i1 < adjacentNodes.size(); i1++) {
            int vertex = adjacentNodes.get(i1);
            if (!visitedNodes.get(vertex)) {
                visitedNodes.set(vertex);
                depthFirstFromVertex(vertex, consumer, visitedNodes, postProcesssingChildren);
            }
        }
        if (postProcesssingChildren != null) {
            postProcesssingChildren.accept(parentVertex);
        }
        return visitedNodes;
    }

    public static void main(String[] args) {
        Graph graph = Graph.createUndirectedGraph(5).addEdge(0, 1).addEdge(0, 4).addEdge(1, 2).addEdge(1, 3).addEdge(1, 4).addEdge(2, 3).addEdge(2, 4);
        graph.printGraph();
        graph.breadthFirstTraversal(System.out::println);
        System.out.println("YOLO");
        graph.depthFirstTraversal(System.out::println, null);

    }


    public static void findMotherVertexInGraph() {
        int[] a;

    }


}

