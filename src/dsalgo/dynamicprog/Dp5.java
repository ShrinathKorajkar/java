package dsalgo.dynamicprog;

import java.util.Arrays;

/* 
    Q: find maximum sum subarray in matrix
    using kadens algo
*/
public class Dp5 {

    static int maxSumRectangle(int r, int c, int a[][]) {
        int sum[] = new int[r];
        int maxSum = Integer.MIN_VALUE;
        for (int cStart = 0; cStart < c; cStart++) {
            Arrays.fill(sum, 0);
            for (int cEnd = cStart; cEnd < c; cEnd++) {
                for (int row = 0; row < r; row++) {
                    sum[row] += a[row][cEnd];
                }
                int curMaxSum = kadens(sum, sum.length);
                maxSum = Math.max(maxSum, curMaxSum);
            }
        }
        return maxSum;
    }

    static int kadens(int[] array, int size) {
        int sum = 0;
        int large = array[0];

        for (int i = 0; i < size; i++) {
            sum += array[i];
            if (sum > large) // Math.max(large, sum);
                large = sum;
            if (sum < 0)
                sum = 0;
        }
        return large;
    }
}
