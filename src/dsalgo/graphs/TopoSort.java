package dsalgo.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/*
    TOPOLOGICAL SORTING :- DAG
    dfs:- find dependencies
    bfs:- find indegree (KAHAN'S ALGO)
*/
public class TopoSort {

    static void dfs(int v, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean visited[]) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, stack, visited);
            }
        }
        stack.push(v);
    }

    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, adj, stack, vis);
            }
        }
        int ans[] = new int[v];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    // USING BFS
    static void bfs(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[], ArrayList<Integer> ans,
            int inDeg[]) {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0) {
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            ans.add(cur);
            for (int neighbor : adj.get(cur)) {
                if (--inDeg[neighbor] == 0) {
                    deque.add(neighbor);
                }
            }
        }
    }

    static ArrayList<Integer> topoSort2(int v, ArrayList<ArrayList<Integer>> adj) {
        int inDeg[] = new int[v];
        for (ArrayList<Integer> list : adj) { // travel edge
            for (Integer e : list) {
                inDeg[e]++;
            }
        }
        boolean vis[] = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        bfs(adj, v, vis, ans, inDeg);
        return ans;
    }
}
