package dsalgo.graphs;

import java.util.ArrayList;
import java.util.Collections;

/* 
    KRUSKAL ALGO
    minimum spanning tree
    uses union find, disjoint setss
    O(E logE)
*/
class Edge implements Comparable<Edge> {
    int src, dest, wt;

    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
        return this.wt - o.wt;
    }
}

public class Kruskal {

    static int parent[];
    static int rank[];

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot)
            return;
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] > rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }

    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean added[][] = new boolean[v][v];
        ArrayList<Edge> edges = new ArrayList<Edge>();
        // create edges
        for (int i = 0; i < adj.size(); i++) {
            for (ArrayList<Integer> cur : adj.get(i)) {
                if (!added[i][cur.get(0)]) {
                    added[i][cur.get(0)] = true;
                    added[cur.get(0)][i] = true;
                    edges.add(new Edge(i, cur.get(0), cur.get(1)));
                }
            }
        }
        initialize(v);
        Collections.sort(edges);
        int count = 1, ans = 0;
        for (int i = 0; count < v; i++) {
            Edge edge = edges.get(i);
            int rx = find(edge.src);
            int ry = find(edge.dest);
            if (rx != ry) {
                union(rx, ry);
                count++;
                ans += edge.wt;
            }
        }
        return ans;
    }

    static void initialize(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static void print() {
        for (int i : rank) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : parent) {
            System.out.print(i);
        }
    }

    public static void main(String[] args) {
        initialize(6);
        union(1, 2);
        union(3, 4);
        union(2, 4);
        print();
    }

}
