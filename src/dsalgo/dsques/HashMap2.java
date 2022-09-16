package dsalgo.dsques;

import java.util.HashMap;

/* 
    Q: find distinct elments in every window of size k             
    input : [1, 2, 2, 1, 3, 1, 1, 3]    k = 4
    output : 2  3   3   2   2
    O(N)
*/
public class HashMap2 {

    private static void distinctSubArr(int a[], int k) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int n = a.length;
        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        System.out.println(map.size());

        for (int i = k; i < n; i++) {
            if (map.get(a[i - k]) == 1) {
                map.remove(a[i - k]);
            } else {
                map.put(a[i - k], map.get(a[i - k]) - 1);
            }
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            System.out.println(map.size());
        }
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 2, 1, 3, 1, 1, 3 };
        distinctSubArr(arr, 4);
    }
}
