package dsa_apnacollege.searchsort;

import java.util.Arrays;
import java.util.HashMap;

/* 
    Q: Minimum no of swaps required to sort an array
    input: [4, 3, 2, 1]
    output: 2 -> {4-1, 3-2}
    O(N log N)
*/
public class SwapTosort {

    static int minSwap(int[] arr, int n) {
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, n);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];
                swap(arr, i, map.get(temp[i]));
                map.put(init, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 1 };
        System.out.println(minSwap(arr, arr.length));
    }
}
