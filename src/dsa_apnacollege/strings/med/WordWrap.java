package dsa_apnacollege.strings.med;

/* 
    WORD WRAP
    O(n ^ 2)
*/
public class WordWrap {

    static void solveWordWrap(int[] arr, int n, int k) {
        int i, j;
        int currlen, cost;
        int dp[] = new int[n];
        int ans[] = new int[n];
        dp[n - 1] = 0;
        ans[n - 1] = n - 1;

        for (i = n - 2; i >= 0; i--) {
            currlen = -1;
            dp[i] = Integer.MAX_VALUE;
            for (j = i; j < n; j++) {

                currlen = arr[j] + 1;
                if (currlen > k)
                    break;

                if (j == n - 1)
                    cost = 0;
                else
                    cost = (k - currlen) * (k - currlen) + dp[j + 1];

                if (cost < dp[i]) {
                    dp[i] = cost;
                    ans[i] = j;
                }
            }
        }
        i = 0;
        while (i < n) {
            System.out.println((i + 1) + " " + (ans[i] + 1) + " ");
            i = ans[i] + 1;
        }
    }

    public static void main(String[] args) {

        int[] arr = { 3, 2, 2, 5 };
        int n = arr.length;
        int M = 6;
        solveWordWrap(arr, n, M);
    }
}
