package dsa_apnacollege.greedy;

/* 
    Q: Given array, find lexicographically smallest arr that can be obtained after atmost k consicutive swaps
    input: [7, 6, 9, 2, 1]      k = 3
    output: [2, 7, 6, 9, 1]
    O(N ^ 2)
*/
public class SmArrAfterKSwp {

    static void arrKSwaps(int arr[], int n, int k) {
        for (int i = 0; i < n - 1 && k > 0; i++) {
            int pos = i;
            int j;
            for (j = i + 1; j < n; j++) {
                if (j - i > k)
                    break;
                if (arr[j] < arr[pos])
                    pos = j;
            }
            int temp = arr[pos];
            for (j = pos; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            k -= pos - i;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 6, 9, 2, 1 };
        int n = arr.length;
        int k = 3;
        arrKSwaps(arr, n, k);
    }
}
