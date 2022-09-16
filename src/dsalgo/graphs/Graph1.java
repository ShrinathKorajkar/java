package dsalgo.graphs;

import java.util.ArrayList;

public class Graph1 {

    static int v = 5, e = 10;

    // adjacency matrix form
    static void addEdge(int a[][], int source, int dest) {
        a[source][dest] = 1;
        a[dest][source] = 1;
    }

    // adjacency List
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int dest) {
        adj.get(source).add(dest);
        adj.get(dest).add(source);
    }

    public static void main(String[] args) {
        int a[][] = new int[v + 1][v + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(a, 1, 2);
    }

}
