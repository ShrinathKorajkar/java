package dsalgo.dynamicprog;

import java.util.Arrays;

/* 
    Q: Largest Common Subsequence
    input: s1 - ABCAB   s2 - AECB
    output: ACB
*/
public class Dp3 {

    static int lcs(int m, int n, String a, String b, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return dp[m][n] = 1 + lcs(m - 1, n - 1, a, b, dp);

        return dp[m][n] = Math.max(lcs(m, n - 1, a, b, dp), lcs(m - 1, n, a, b, dp));

    }

    static int bottomUplcs(int m, int n, String a, String b, int[][] dp) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int m = 5, n = 4;
        int dp[][] = new int[m + 1][n + 1];
        String s1 = "ABCAB", s2 = "AECB";
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1); // fill 0 in bottom up
        System.out.println(lcs(m, n, s1, s2, dp));
    }
}
/*
 * VARIATIONS OF LCS - l
 * 1. lcs space optimization - use two arrays
 * 2. minimum insertions and deletions to convert str1 to str2 - (m-l) + (n-l)
 * 3. lenght of supersequence of s1 and s2 - (m-l) + (n-l) + l
 * 4. longest repeating supersequence - a.charAt(i-1)==b.charAt(j-1) && i!=j
 * 5. longest palindrome subsequence - s2 = reverse s1 -> find lcs
 */
