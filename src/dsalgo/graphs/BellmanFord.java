package dsalgo.graphs;

import java.util.Arrays;

/* 
    BELLMAN-FORD ALGO
    Single source shortest path (-ve edges)
    increase the edges taken in every iteration
    O(EV)
*/
public class BellmanFord {

    static int negativeWeightCycle(int n, int[][] edges) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int count = 1; count < n; count++) {
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];
                if (dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                    dist[dest] = dist[src] + weight;
                }
            }
        }

        for (int j = 0; j < edges.length; j++) { // if value changes we have neagative weight cycle
            int src = edges[j][0];
            int dest = edges[j][1];
            int weight = edges[j][2];
            if (dist[src] != Integer.MAX_VALUE && dist[dest] > dist[src] + weight) {
                return 1;
            }
        }

        return 0;
    }
}
