package dsa_apnacollege.searchsort;

/* 
    Q: given arr, we have to replace all elements with a single element, such that cost is minimum
    here cost = sum(replace - original)
    input: [1, 100, 101]
    output: 100 -> {99 + 0 + 1}
    O(N logN)
*/
public class MkEqWMinCost {

    static int computeCost(int arr[], int n, int x) {
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs(arr[i] - x);
        }
        return cost;
    }

    static int minCost(int arr[], int n) {
        int low, high;
        low = high = arr[0];
        for (int i = 0; i < n; i++) {
            if (low > arr[i])
                low = arr[i];
            else if (high < arr[i])
                high = arr[i];
        }

        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 2;
            int mid2 = high - (high - low) / 2;

            int cost1 = computeCost(arr, n, mid1);
            int cost2 = computeCost(arr, n, mid2);

            if (cost1 < cost2)
                high = mid2;
            else
                low = mid1;
        }
        return computeCost(arr, n, (low + high) / 2);
    }

    public static void main(String[] args) {

        int[] arr = { 1, 100, 101 };
        System.out.println(minCost(arr, arr.length));
    }
}
