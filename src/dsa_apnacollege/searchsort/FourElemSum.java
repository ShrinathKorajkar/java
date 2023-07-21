package dsa_apnacollege.searchsort;

import java.util.HashMap;

/* 
    Q: Find 4 elements that sum to given value
    input: [10, 2, 3, 4, 5, 9, 7, 8]    k = 23
    ouput: [3, 5, 7, 8]
    O(N ^ 2)
*/
public class FourElemSum {

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static void findFourElem(int[] arr, int n, int k) {
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(arr[i] + arr[j], new Pair(i, j));
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(k - sum)) {
                    Pair p = map.get(k - sum);
                    if (p.first != i && p.first != j && p.second != i && p.second != j) {
                        System.out.println(arr[i] + ", " + arr[j] + ", " + arr[p.first] + ", " + arr[p.second]);
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, 3, 4, 5, 9, 7, 8 };
        findFourElem(arr, 8, 23);
    }
}
