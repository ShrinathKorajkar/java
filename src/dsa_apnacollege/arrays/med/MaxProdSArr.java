package dsa_apnacollege.arrays.med;

/* 
    MAXIMUM PRODUCT SUBARRAY
    Q: find contigous subarray with max prod.
    input: [-2, 1, -1]
    output: 2
    O(n)
*/
public class MaxProdSArr {

    // multiplication of max with -ve no makes it min, and min to max
    // thus we swap min, max if we encounter -ve
    static int maxProdSubArray(int[] arr) {
        int ans = arr[0];
        int max = arr[0], min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(arr[i], max * arr[i]);
            min = Math.min(arr[i], min * arr[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = { -2, 1, -1 };
        System.out.println(maxProdSubArray(arr));
    }
}
