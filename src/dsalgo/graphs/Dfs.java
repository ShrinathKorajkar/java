package dsalgo.graphs;

import java.util.ArrayList;

public class Dfs {

    // O(v + e)
    void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean visited[], ArrayList<Integer> ans) {
        visited[v] = true;
        ans.add(v);
        for (Integer neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, ans);
            }
        }
    }
}
