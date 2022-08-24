package dsalgo.arrays;

/*                    
    given blocks height find amount of blocks rainWaterTrap
    array preprocessing
*/
public class rainWaterTrap {

    private static int rainWater(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 4, 1, 2, 3, 4 };
        System.out.println(rainWater(arr));
    }
}
