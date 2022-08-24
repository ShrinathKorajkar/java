package dsalgo.arrays;

public class stocksBnS {

    // if we buy and sell only once
    private static int maxProfit(int arr[]) {

        int maxProf = 0;
        int minSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            int profit = arr[i] - minSoFar;
            maxProf = Math.max(maxProf, profit);
        }

        return maxProf;
    }

    // else maxProfit += a[i]-a[i-1] if a[i] > a[i-1]

    public static void main(String[] args) {

        int[] arr = { 5, 2, 6, 1, 4 };
        System.out.println(maxProfit(arr));
    }
}
