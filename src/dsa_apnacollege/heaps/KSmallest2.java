package dsa_apnacollege.heaps;

import java.util.Arrays;

/*           
    Q: K th Smallest element after removing some integers from natural numbers
    input: arr[] = {1, 3}       k = 4
    output: natural no - 1, 2, 3, 4, .....
            after removing arr - 2, 4, 5, 6, .....
            => k th smallest = 6

    O(N logN)
*/
public class KSmallest2 {

    static int kSmallest(int arr[], int n, int k) {
        Arrays.sort(arr);
        if (k < arr[0])
            return k;
        if (k == arr[0])
            return arr[0] + 1;
        if (k > arr[n - 1])
            return k + n;
        if (arr[0] == 1)
            k--;
        else
            k -= (arr[0] - 1);

        for (int i = 1; i < n; i++) {
            int c = arr[i] - arr[i - 1] - 1;
            if (k <= c)
                return arr[i - 1] + k;
            else
                k -= c;
        }
        return arr[n - 1] + k;
    }

    public static void main(String[] args) {

        int k = 4;
        int arr[] = { 1, 3 };
        System.out.println(kSmallest(arr, arr.length, k));
    }
}
