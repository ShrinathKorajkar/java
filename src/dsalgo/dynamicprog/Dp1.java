package dsalgo.dynamicprog;

import java.util.Arrays;

/* 
    DYNAMIC PROGRAMMING :- Top down, bottom up
    O(m^n) -> O(m * n) using space
    where m*n is matrix space, uses recursion

    Q1 : Coin Changing Problem, given denominations find min coins to get money
    Q2 : Cutting rod- given rod length, price for cutted rod length
*/
public class Dp1 {

    static int minCoins(int n, int a[], int dp[]) {
        if (n == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (n - a[i] >= 0) {
                int subAns = 0;
                if (dp[n - a[i]] != -1) {
                    subAns = dp[n - a[i]];
                } else {
                    subAns = minCoins(n - a[i], a, dp);
                }
                if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        return dp[n] = ans;
    }

    static int cutRod(int price[], int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], price[j] + dp[i - j - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int change = 18;
        int coins[] = { 7, 5, 1 };
        int dp[] = new int[change + 1];
        Arrays.fill(dp, -1);
        int ans = minCoins(change, coins, dp);
        System.out.println(ans);

        int price[] = { 1, 5, 6, 9, 11, 12, 14, 16 };
        System.out.println(cutRod(price, 8));
    }

}