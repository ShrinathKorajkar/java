package dsa_apnacollege.backtracking;

/* 
    Q: Given array of size N, check if it can be partitioned into 2 parts
       such that the sum of elements in both parts is same.
    input: [1, 5, 11, 5]
    output: YES -> [1, 5, 5] , [11]
    O(N * sum of elements)
*/
public class EqlSubsetSum {

    static int equalPartition(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 == 1)
            return 0;

        sum /= 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;
        for (int i = 0; i < dp.length; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }
        return (dp[n][sum] ? 1 : 0);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 11, 5 };
        if (equalPartition(arr, arr.length) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
