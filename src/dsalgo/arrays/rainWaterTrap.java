package dsalgo.arrays;

/*                    
    given blocks height find amount of blocks rainWaterTrap
    array preprocessing
    O(n)
*/
public class rainWaterTrap {

    // USING SPACE
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

    // USING 2 POINTERS (constant space)
    private static int trapWater(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 3, 2, 4, 1, 2, 3, 4 };
        System.out.println(rainWater(arr));
        System.out.println(trapWater(arr));
    }
}
