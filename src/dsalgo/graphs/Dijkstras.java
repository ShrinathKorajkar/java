package dsalgo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/* 
    DIKSTRAS ALGO
    single source shortest path (+ve edges)
    O(E logV)
*/
public class Dijkstras {
    static int[] dijkstras(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        q.add(new Pair(S, 0));
        int ans[] = new int[v];
        Arrays.fill(ans, 1000000);
        ans[S] = 0;
        while (q.isEmpty()) {
            Pair cur = q.remove();
            int u = cur.v;
            if (vis[u]) {
                continue;
            }
            vis[u] = true;
            ArrayList<ArrayList<Integer>> neighbors = adj.get(u);
            for (ArrayList<Integer> list : neighbors) {
                int vertex = list.get(0);
                int weight = list.get(1);
                if (ans[vertex] > ans[u] + weight) {
                    ans[vertex] = ans[u] + weight;
                    q.add(new Pair(vertex, ans[vertex]));
                }
            }
        }
        return ans;
    }
}
