package dsa_apnacollege.searchsort;

/* 
    INVERSION COUNT
    Q: inversion count indicates how far array is close from being sorted. already sorted
       has a inversion count 0. sorted in reverse then inv count is max.
    input: [2, 4, 1, 3, 5]
    output: 3 -> [(2,1),(4,1),(4,3)]
    O(N logN)   O(N)
*/
public class InversionCnt {

    static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int count = 0;
        int i = left, j = mid, k = left;
        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                count += mid - i;
            }
        }
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j < mid) {
            temp[k++] = arr[j++];
        }
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        return count;
    }

    static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, count = 0;
        if (right > left) {
            mid = (left + right) / 2;
            count = mergeSort(arr, temp, left, mid);
            count += mergeSort(arr, temp, mid + 1, right);
            count += merge(arr, temp, left, mid + 1, right);
        }
        return count;
    }

    static int invCount(int[] arr, int n) {
        int temp[] = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    public static void main(String[] args) {

        int arr[] = { 2, 4, 1, 3, 5 };
        System.out.println(invCount(arr, arr.length));

    }
}
