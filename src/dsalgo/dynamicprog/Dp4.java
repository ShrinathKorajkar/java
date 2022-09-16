package dsalgo.dynamicprog;

/* 
    Q: Given insert, delete, replace - min op to convert s1 to s2
*/
public class Dp4 {

    static int editDistance(String a, String b) {
        int m = a.length();
        int n = b.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ABCAB";
        String s2 = "EACB";
        System.out.println(editDistance(s1, s2));
    }
}
