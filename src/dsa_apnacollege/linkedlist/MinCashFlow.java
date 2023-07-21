package dsa_apnacollege.linkedlist;

/* 
    HARD
    Q: Minimize Cash Flow among a given set of friends who have borrowed money from each other
    input: graph[][] = {{0, 1000, 2000},        output: graph[][] = {{0, 0, 3000},
                        {0,    0, 5000},                             {0, 0, 4000},
                        {0,    0,    0},                             {0, 0,    0},
                        };                                           };
    i.e -> p1 pays 4000 to p2
           p0 pays 3000 to p2
    O(N ^ 2)
*/
public class MinCashFlow {

    static final int N = 3;

    static int getMin(int arr[]) {
        int minInd = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] < arr[minInd]) {
                minInd = i;
            }
        }
        return minInd;
    }

    static int getMax(int arr[]) {
        int maxInd = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > arr[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }

    static int minOf2(int x, int y) {
        return (x < y) ? x : y;
    }

    static void minCashFlow(int amount[]) {
        int maxCredit = getMax(amount), maxDebit = getMin(amount);
        if (amount[maxCredit] == 0 && amount[maxDebit] == 0) {
            return;
        }
        int min = minOf2(-amount[maxDebit], amount[maxCredit]);
        amount[maxCredit] -= min;
        amount[maxDebit] += min;
        System.out.println("Person " + maxDebit + " pays " + min + " to Person " + maxCredit);
        minCashFlow(amount);
    }

    static void minCash(int graph[][]) {
        int amount[] = new int[N];
        for (int p = 0; p < N; p++) {
            for (int i = 0; i < N; i++) {
                amount[p] += graph[i][p] - graph[p][i];
            }
        }
        minCashFlow(amount);
    }

    public static void main(String[] args) {
        int graph[][] = {
                { 0, 1000, 2000 },
                { 0, 0, 5000 },
                { 0, 0, 0 },
        };
        minCash(graph);
    }
}
