package practice2019.coding.gfg.helper;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    public ArrayList<LinkedList<Integer>> adjacencyList;
    public int vertices;
    public static Graph sampleConnectedGraphWithCycle, sampleDisconnectedGraphWithCycle,
            sampleGraphWithoutCycle, sampleDirectedGraphWithCycle, sampleDirectedGraphWithoutCycle;
    boolean isDirected;

    static {
        sampleConnectedGraphWithCycle = new Graph(5);
        sampleConnectedGraphWithCycle.addVertex(0, 1);
        sampleConnectedGraphWithCycle.addVertex(0, 2);
        sampleConnectedGraphWithCycle.addVertex(0, 3);
        sampleConnectedGraphWithCycle.addVertex(1, 2);
        sampleConnectedGraphWithCycle.addVertex(2, 3);
        sampleConnectedGraphWithCycle.addVertex(3, 4);
        sampleConnectedGraphWithCycle.addVertex(4, 1);

        sampleDisconnectedGraphWithCycle = new Graph(10);
        sampleDisconnectedGraphWithCycle.addVertex(0, 1);
        sampleDisconnectedGraphWithCycle.addVertex(0, 2);
        sampleDisconnectedGraphWithCycle.addVertex(0, 3);
        sampleDisconnectedGraphWithCycle.addVertex(1, 2);
        sampleDisconnectedGraphWithCycle.addVertex(2, 3);
        sampleDisconnectedGraphWithCycle.addVertex(3, 4);
        sampleDisconnectedGraphWithCycle.addVertex(4, 1);

        sampleDisconnectedGraphWithCycle.addVertex(5, 6);
        sampleDisconnectedGraphWithCycle.addVertex(5, 7);
        sampleDisconnectedGraphWithCycle.addVertex(5, 8);
        sampleDisconnectedGraphWithCycle.addVertex(6, 7);
        sampleDisconnectedGraphWithCycle.addVertex(7, 8);
        sampleDisconnectedGraphWithCycle.addVertex(8, 9);
        sampleDisconnectedGraphWithCycle.addVertex(9, 6);

        sampleGraphWithoutCycle = new Graph(10);
        sampleGraphWithoutCycle.addVertex(0,1);
        sampleGraphWithoutCycle.addVertex(0,2);
        sampleGraphWithoutCycle.addVertex(0,3);
        sampleGraphWithoutCycle.addVertex(3,6);
        sampleGraphWithoutCycle.addVertex(3,7);
        sampleGraphWithoutCycle.addVertex(4,7);
        sampleGraphWithoutCycle.addVertex(5,9);
        sampleGraphWithoutCycle.addVertex(6,5);
        sampleGraphWithoutCycle.addVertex(7,8);


        sampleDirectedGraphWithCycle = new Graph(6);
        sampleDirectedGraphWithCycle.isDirected = true;
        sampleDirectedGraphWithCycle.addVertex(0, 1);
        sampleDirectedGraphWithCycle.addVertex(0, 5);
        sampleDirectedGraphWithCycle.addVertex(1, 2);
        sampleDirectedGraphWithCycle.addVertex(2, 3);
        sampleDirectedGraphWithCycle.addVertex(2, 3);
        sampleDirectedGraphWithCycle.addVertex(3, 4);
        sampleDirectedGraphWithCycle.addVertex(3, 4);
        sampleDirectedGraphWithCycle.addVertex(4, 5);
        sampleDirectedGraphWithCycle.addVertex(5, 2);

        sampleDirectedGraphWithoutCycle = new Graph(6);
        sampleDirectedGraphWithoutCycle.isDirected = true;
        sampleDirectedGraphWithoutCycle.addVertex(0, 1);
        sampleDirectedGraphWithoutCycle.addVertex(0, 2);
        sampleDirectedGraphWithoutCycle.addVertex(2, 3);
        sampleDirectedGraphWithoutCycle.addVertex(2, 4);
        sampleDirectedGraphWithoutCycle.addVertex(3, 5);
        sampleDirectedGraphWithoutCycle.addVertex(4, 5);
        sampleDirectedGraphWithoutCycle.addVertex(5, 1);



    }

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.add(new LinkedList<Integer>());
        }
        this.isDirected = false;
    }

    public Graph(int vertices, ArrayList<LinkedList<Integer>> adjacencyList) {
        this.vertices = vertices;
        this.adjacencyList = adjacencyList;
        this.isDirected = false;
    }

    public void addVertex(int v1, int v2) {
        adjacencyList.get(v1).add(v2);
        if (!isDirected)
            adjacencyList.get(v2).add(v1);
    }

    public void removeVertex(int v1, int v2) {
        adjacencyList.get(v1).remove(new Integer(v2));
        if (!isDirected)
            adjacencyList.get(v2).remove(new Integer(v1));
    }

}
