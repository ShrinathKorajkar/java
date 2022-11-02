package dsa_apnacollege.arrays.med;

/* 
    Q : Given Rotated Sorted Array, find if sum of 2 nos = given sum
    input : [11, 15, 6, 8, 9, 10]   X = 16
    output: True (10 + 6)
    O(n)
*/
public class RotatedArrSum {

    static boolean pairInSortedRotated(int arr[], int sum) {
        int n = arr.length;
        int i = 0;
        for (i = 0; arr[i] < arr[i + 1] && i < n - 1; i++) {
        }
        int largest = i;
        int smallest = (i + 1) % n;
        while (largest != smallest) {
            int mySum = arr[largest] + arr[smallest];
            if (mySum == sum) {
                return true;
            }
            if (mySum < sum) {
                smallest = (smallest + 1) % n; // increment smaller
            } else {
                largest = (largest + n - 1) % n; // decrement larger
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = { 11, 15, 6, 8, 10 };
        System.out.println(pairInSortedRotated(arr, 16));
    }
}
