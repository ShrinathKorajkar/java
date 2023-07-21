package dsa_apnacollege.stacknqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 
    Q: Given a binary grid of n*m. Find distance of the nearest 1 in the grid for each cell
       distance is calculated at every direction
    input: grid - {{0, 1, 1, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}}
    output:       {{1, 0, 0, 1}, {0, 0, 1, 1}, {1, 1, 0, 0}}
    O(n*m)
*/
public class NrstCellwithOne {

    static boolean isValid(int x, int y, int n, int m) {
        if (x >= 0 && y >= 0 && x < n && y < m)
            return true;
        return false;
    }

    static int[][] nearest(int[][] grid) {
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = 10000000;

        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    q.add(temp);
                }
            }
        }
        while (!q.isEmpty()) {
            ArrayList<Integer> curr = q.poll();
            int x = curr.get(0);
            int y = curr.get(1);
            for (int i = 0; i < 4; i++) {
                int n_x = x + dx[i];
                int n_y = y + dy[i];
                if (isValid(n_x, n_y, n, m) && dp[n_x][n_y] > dp[x][y] + 1) {
                    dp[n_x][n_y] = dp[x][y] + 1;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(n_x);
                    temp.add(n_y);
                    q.add(temp);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 0, 1, 1 }
        };
        int[][] ans = nearest(grid);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
