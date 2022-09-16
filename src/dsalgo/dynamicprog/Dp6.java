package dsalgo.dynamicprog;

/* 
    Q: find min steps for matrix multiplication
    input - [2, 3, 4, 1, 3] - 2x3, 3x4, 4x1, 1x3 matrices
    output - 24
    steps reqd to multiply axb * bxc -> a * b * c

    Q: Palindrome patitioning - no of partitions to make string palindrome
*/
public class Dp6 {

    // DIAGNOL FILLING MATRIX
    static int stepsReqd(int n, int a[]) {
        int dp[][] = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int row = 0, col = len; row < n - len; row++, col++) {
                dp[row][col] = Integer.MAX_VALUE;
                for (int k = row + 1; k < col; k++) {
                    dp[row][col] = Math.min(dp[row][col], dp[row][k] + dp[k][col] + a[row] * a[k] * a[col]);
                }
            }
        }
        return dp[0][n - 1];
    }

    static int palindromePartition(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int row = 0, col = len; row < n - len; row++, col++) {
                if (isPalindrome(s, row, col)) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        dp[row][col] = Math.min(dp[row][col], 1 + dp[row][k] + dp[k + 1][col]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    static boolean isPalindrome(String s, int row, int col) {
        while (row < col) {
            if (s.charAt(row++) != s.charAt(col--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int a[] = { 2, 3, 4, 1, 3 };
        System.out.println(stepsReqd(a.length, a));

        String pal = "aabbabba";
        System.out.println(palindromePartition(pal));
    }
}
