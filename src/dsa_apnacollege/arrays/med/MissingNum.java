package dsa_apnacollege.arrays.med;

import java.util.Arrays;

/* 
    Q: given array of n integers from 1 to n.
    Each integer appears exactly once except A which appears twice and B which is missing.
    Return A and B.
    Input:[3 1 2 5 3] 
    Output:[3, 4]     A = 3, B = 4
*/
public class MissingNum {

    public void missingRepeatedNo(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int rep = -1, miss = -1;
        long sum = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                rep = arr[i];
            }
            sum += arr[i];
        }
        miss = (int) (n * (n + 1) / 2 - sum + rep);
        System.out.println(rep);
        System.out.println(miss);
    }
}
