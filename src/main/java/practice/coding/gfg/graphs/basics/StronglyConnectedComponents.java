package practice.coding.gfg.graphs.basics;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.stream.Collectors;

// author -- hemantkumar
public class StronglyConnectedComponents {


    public static ArrayList<ArrayList<Integer>> usingKosaraju(Graph graph) {

        ArrayList<Integer> finishingTimeStack = new ArrayList<Integer>(graph.v);
        graph.depthFirstTraversal(x -> {
        }, finishingTimeStack::add);
        graph.reverseGraphInPlace();
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<ArrayList<Integer>>();
        BitSet visitedNodes = new BitSet(graph.v);
        for (int i = finishingTimeStack.size() - 1; i >= 0; i--) {
            if (!visitedNodes.get(finishingTimeStack.get(i))) {
                ArrayList<Integer> connectedNodes = new ArrayList<>();
                graph.depthFirstFromVertex(finishingTimeStack.get(i), connectedNodes::add, visitedNodes, null);
                connectedComponents.add(connectedNodes);
            }
        }
        return connectedComponents;

    }

    public static void printConnectedComponents(ArrayList<ArrayList<Integer>> connectedComponents) {
        connectedComponents.stream().map(x -> x.stream().map(y -> y.toString()).collect(Collectors.joining("|"))).forEach(System.out::println);

    }


    public static void main(String[] args) {
        Graph graph = Graph.createDirectedGraph(5).addEdge(1, 0).addEdge(0, 2).addEdge(2, 1).addEdge(0, 3).addEdge(3, 4);
        ArrayList<ArrayList<Integer>> connectedComponents = StronglyConnectedComponents.usingKosaraju(graph);
        System.out.println("yolo");
        printConnectedComponents(connectedComponents);
    }


}



