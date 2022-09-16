package dsalgo.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/* 
    PRIM ALGORITHM :- Minimum Spanning Tree 
    O(E logE)
*/
class Pair implements Comparable<Pair> {
    int weight;
    int v;

    Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}

public class Prim {

    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean vis[] = new boolean[v];
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        q.add(new Pair(0, 0));
        int ans = 0;
        while (q.isEmpty()) {
            Pair cur = q.remove();
            int u = cur.v;
            if (vis[u]) {
                continue;
            }
            ans += cur.weight;
            vis[u] = true;
            ArrayList<ArrayList<Integer>> neighbors = adj.get(u);
            for (ArrayList<Integer> list : neighbors) {
                int vertex = list.get(0);
                int weight = list.get(1);
                if (!vis[vertex]) {
                    q.add(new Pair(vertex, weight));
                }
            }
        }
        return ans;
    }
}
