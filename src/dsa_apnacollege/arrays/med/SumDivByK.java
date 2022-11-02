package dsa_apnacollege.arrays.med;

import java.util.HashMap;

/* 
    Q: Longest Subarray with sum divisible by k
    input: [2, 7, 6, 1, 4, 5]   k = 3
    output: 4 [7, 6, 1, 4] = 18 % 3 == 0
    O(n)    O(k)
*/
public class SumDivByK {

    static int longestSubArrDivByK(int arr[], int k, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // to handle negative values
            int mod = ((sum % k) + k) % k;
            if (mod == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(mod)) {
                int sz = i - map.get(mod);
                maxLen = Math.max(maxLen, sz);
            } else {
                map.put(mod, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int arr[] = { 2, 7, 6, 1, 4, 5 };
        int k = 3;

        System.out.println(longestSubArrDivByK(arr, k, arr.length));
    }
}
