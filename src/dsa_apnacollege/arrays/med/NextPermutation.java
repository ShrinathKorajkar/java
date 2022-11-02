package dsa_apnacollege.arrays.med;

/* 
    Q: Given int[] nums, find the next permutation.
    next permutation is that follows it in the sorted container
    arr = [1,2,3]
    permutations = [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]
    Input: nums = [1,2,3]
    Output: [1,3,2]
*/
public class NextPermutation {

    static void nextPerm(int[] arr) {
        int n = arr.length, k, l;
        for (k = n - 2; k >= 0; k--) {
            if (arr[k] < arr[k + 1]) {
                break;
            }
        }
        if (k >= 0) {
            for (l = n - 1; l > k; l--) {
                if (arr[l] > arr[k]) {
                    break;
                }
            }
            int temp = arr[k];
            arr[k] = arr[l];
            arr[l] = temp;
        }
        reverse(arr, k + 1, n);
    }

    private static void reverse(int[] arr, int start, int end) {
        for (int i = start, j = end; i < (end / 2); i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j - 1];
            arr[j - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        nextPerm(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
