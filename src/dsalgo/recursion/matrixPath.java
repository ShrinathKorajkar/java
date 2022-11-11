package dsalgo.recursion;

/* 
    given matrix, starting point print available paths to reach end box
    O(2^(m + n))
*/

public class matrixPath {

    public static int countPath(int i, int j, int m, int n) {
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        int rightpaths = countPath(i, j + 1, m, n);
        int downpaths = countPath(i + 1, j, m, n);

        return rightpaths + downpaths;
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(countPath(0, 0, m, n));
    }
}
