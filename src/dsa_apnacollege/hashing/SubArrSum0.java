package dsa_apnacollege.hashing;

import java.util.HashMap;

/*
    Q: Find the length of largest subarray with sum 0
    input: {15, -2, 2, -8, 1, 7, 10, 23}
    output: 5 - {-2, 2, -8, 1, 7}
    O(N)
*/

public class SubArrSum0 {

    static int maxLen(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0)
                maxlen = i + 1;
            Integer prev = map.get(sum);
            if (prev == null)
                map.put(sum, i);
            else
                maxlen = Math.max(maxlen, i - prev);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(arr));
    }
}
