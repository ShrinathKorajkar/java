package dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/* 
    Queue
    1. Find min dist from source to dest
    2. Find no of connected components
    O(V + E) / O(N^2)
*/
public class Bfs {

    // v = no of vertices
    // pred = store predecessor of current node
    // dist = store distance from source to dest
    boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]) {
        LinkedList<Integer> que = new LinkedList<Integer>();
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[src] = true;
        dist[src] = 0;
        que.add(src);

        while (!que.isEmpty()) {
            int cur = que.remove();
            for (Integer neighbor : adj.get(v)) {
                if (visited[neighbor] == false) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[cur] + 1;
                    pred[neighbor] = cur;
                    que.add(neighbor);
                    if (neighbor == dest)
                        return true;
                }
            }
        }
        return false;
    }
    /*
     * 1. components = 0;
     * for (int i = 0; i < v; i++)
     * if(!visited[i]){
     * components ++ ;
     * dfs();
     * }
     */
}
