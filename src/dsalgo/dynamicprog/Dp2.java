package dsalgo.dynamicprog;

/* 
    Q: 0/1 KnapSack
    given weight and profit we need to fill sack of given weight with max profit
    Top Down Approach
*/
public class Dp2 {

    static int knapSack(int weight[], int profit[], int sack) {
        int n = weight.length;
        int dp[][] = new int[n + 1][sack + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sack + 1; j++) {
                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return dp[n][sack];
    }

    public static void main(String[] args) {

        int weight[] = { 1, 3, 4, 6 };
        int profit[] = { 20, 30, 10, 50 };
        int sack = 10;
        System.out.println(knapSack(weight, profit, sack));
    }

}
