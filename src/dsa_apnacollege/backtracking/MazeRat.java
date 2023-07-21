package dsa_apnacollege.backtracking;

/* 
    RAT IN MAZE
    Q: given matrix 0 -> no path, 1 -> path, given source find path to destination.
       rat can only move forward or downwards
    input: [1, 0, 0, 0          output: [1, 0, 0, 0
            1, 1, 0, 1                   1, 1, 0, 0
            0, 1, 0, 0                   0, 1, 0, 0  
            1, 1, 1, 1]                  0, 1, 1, 1]
    
    O(2^(n*n))      O(n^2)
*/
public class MazeRat {

    static void printSol(int sol[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int maze[][], int x, int y, int n) {
        return (x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1);
    }

    static void solveMaze(int maze[][], int x, int y, int n, int sol[][]) {
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            printSol(sol, n);
            return;
        }
        if (isSafe(maze, x, y, n)) {
            if (sol[x][y] == 1) {
                return;
            }
            sol[x][y] = 1;
            solveMaze(maze, x + 1, y, n, sol);
            solveMaze(maze, x, y + 1, n, sol);
            sol[x][y] = 0; // if commented we get only one path
        }
    }

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int sol[][] = new int[maze.length][maze.length];
        solveMaze(maze, 0, 0, maze.length, sol);
    }
}
