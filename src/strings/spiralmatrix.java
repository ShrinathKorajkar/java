package strings;

import java.util.Scanner;

public class spiralmatrix {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Spiral order of matrix");
        int rowStart = 0, colStart = 0;
        int rowEnd = m - 1, colEnd = n - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int col = colStart; col <= colEnd; col++) {
                System.out.println(matrix[rowStart][col] + " ");
            }
            rowStart++;
            for (int row = rowStart; row <= rowEnd; row++) {
                System.out.println(matrix[row][colEnd] + " ");
            }
            colEnd--;
            for (int col = colEnd; col >= colStart; col--) {
                System.out.println(matrix[rowEnd][col] + " ");
            }
            rowEnd--;
            for (int row = rowEnd; row >= rowStart; row--) {
                System.out.println(matrix[row][colStart] + " ");
            }
            colStart++;
        }
        sc.close();
    }
}