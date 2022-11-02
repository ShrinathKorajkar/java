package dsa_apnacollege.searchsort;

/* 
    Q: Check if reversing any subarray make the array sorted
    input: [1, 2, 5, 4, 3, 6]
    output: yes
    O(N)
*/
public class SortByRevSubArr {

    static void reverse(int[] a, int x, int y) {
        while (x < y) {
            int temp = a[x];
            a[x] = a[y];
            a[y] = temp;
            x++;
            y--;
        }
    }

    static boolean sortArr(int[] arr, int n) {

        int i, j;
        for (i = 1; arr[i - 1] < arr[i] && i < n; i++) {
        }
        if (i == n) {
            return true;
        }
        for (j = i; arr[j] < arr[j - 1] && j < n; j++) {
        }

        reverse(arr, i - 1, j - 1);
        for (i = 0; i < n; i++) {
            if (arr[i] > arr[j])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 5, 4, 3, 6 };
        System.out.println(sortArr(arr, arr.length));
    }
}
