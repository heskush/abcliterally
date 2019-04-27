package practice2018.coding.gfg.graphs.basics;

import java.util.ArrayList;

// author -- hemantkumar
public class ConnectedComponents {

    /*
     * In this version the array that stores the connectivity information is a root array. Find(a,b) is true if rootArr[a]==rootArr[b] */
    public static int[] connectedComponentsUnionFind1(Graph graph) {
        int vertices = graph.v;
        int[] arr = new int[vertices];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }


        return null;
    }
}


/*
 * Type 1: Each element stores the root of it's connected components. Find becomes O(1)*/

class ConnectedComponentsUnionFind_1 {
    int[] rootArr;


    public ConnectedComponentsUnionFind_1(Graph graph) {
        int vertices = graph.v;
        rootArr = new int[vertices];
        for (int i = 0; i < rootArr.length; i++) {
            rootArr[i] = i;
        }

        ArrayList<ArrayList<Integer>> adjacencyList = graph.adjacencyList;
        for (int i = 0; i < adjacencyList.size(); i++) {
            int vertex = i;
            ArrayList<Integer> edges = adjacencyList.get(i);
            for (int j = 0; j < edges.size(); j++) {
                union(vertex, edges.get(j));
            }
        }

    }

    private void union(int a, int b) {
        int sourceVal = rootArr[a];
        int targetVal = rootArr[b];
        for (int i = 0; i < rootArr.length; i++) {
            if (rootArr[i] == sourceVal) {
                rootArr[i] = targetVal;
            }
        }
    }

    public boolean find(int a, int b) {
        return rootArr[a] == rootArr[b];

    }


    public boolean isCyclic() {

        return true;

    }


}


class ConnectedComponentsUnionFind_2 {
    int[] parentArr;

    public ConnectedComponentsUnionFind_2(Graph graph) {
        int vertices = graph.v;
        parentArr = new int[vertices];
        for (int i = 0; i < parentArr.length; i++) {
            parentArr[i] = i;
        }

    }
}

