package dsalgo.dsques;

/* 
    WHINE BUYING AND SELLING
    Q: given array where +ve -> require whine, -ve -> sell whine. 
    selling one bottle has cost = no of bottle * steps. find min cost
    set 2 pointers buy and sell
*/
public class Greedy2 {

    static int wineSell(int a[], int n) {

        int buy = 0, sell = 0;
        int ans = 0;
        while (buy < n || sell < n) {
            while (a[buy] <= 0) {
                buy++;
                if (buy == n)
                    return ans;
            }
            while (a[sell] >= 0) {
                sell++;
                if (sell == n)
                    return ans;
            }
            if (Math.abs(a[buy]) >= Math.abs(a[sell])) {
                ans += Math.abs(buy - sell) * Math.abs(a[sell]);
                a[buy] += a[sell];
                a[sell] = 0;
            } else {
                ans += Math.abs(buy - sell) * Math.abs(a[buy]);
                a[sell] += a[buy];
                a[buy] = 0;
            }
        }
        return ans;
    }
}
