package dsalgo.graphs;

import java.util.ArrayList;

public class CycleDetect {
    // O(v + e)
    // DIRECTED GRAPH
    boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean rec[]) {
        visited[v] = true;
        rec[v] = true;
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCycle(neighbor, adj, visited, rec))
                    return true;
            } else if (rec[neighbor]) {
                return true;
            }
            rec[v] = false;
            return false;
        }
        return false;
    }

    // UNDIRECTED GRAPH (dfs)
    boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[], int parent) { // v = vertex
        visited[v] = true;
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCycle(neighbor, adj, visited, v))
                    return true;
            } else if (parent != neighbor) {
                return true;
            }
        }
        return false;
    }
}
