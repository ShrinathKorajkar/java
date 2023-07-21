package dsa_apnacollege.backtracking;

/* 
    Q: Given graph and integer M. Determine if it can be colored with M colors such that no 2 adjacent nodes have same color
    input: {(0,1), (1,2), (2,3), (3,0), (0,2)}      M = 3
    ouput: 1
    O(M ^ N)
*/
public class MColorGraph {

    static boolean isSafe(int source, boolean[][] graph, int color[], int c, int n) {
        for (int i = 0; i < n; i++) {
            if (graph[source][i] && c == color[i])
                return false;
        }
        return true;
    }

    static boolean graphColorUtil(boolean[][] graph, int m, int color[], int source, int n) {
        if (source == n)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(source, graph, color, c, n)) {
                color[source] = c;
                if (graphColorUtil(graph, m, color, source + 1, n))
                    return true;
                color[source] = 0;
            }
        }
        return false;
    }

    static boolean graphColor(boolean graph[][], int m, int n) {
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = 0;
        }
        if (graphColorUtil(graph, m, color, 0, n) == false) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean graph[][] = {
                { false, true, true, false },
                { false, false, true, false },
                { false, false, false, true },
                { true, false, false, false } };
        System.out.println(graphColor(graph, 3, 4));
    }
}
