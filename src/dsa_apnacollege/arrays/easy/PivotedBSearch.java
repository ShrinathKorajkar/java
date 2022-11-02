package dsa_apnacollege.arrays.easy;

public class PivotedBSearch {

    static int search(int[] arr, int start, int end, int key) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (arr[mid] == key)
            return mid;

        // if left array is sorted
        if (arr[start] <= arr[mid]) {
            if (key >= arr[start] && key <= arr[mid])
                return search(arr, start, mid - 1, key);

            return search(arr, mid + 1, end, key);
        }

        // else if right array is sorted
        if (key >= arr[mid] && key <= arr[end])
            return search(arr, mid + 1, end, key);

        return search(arr, start, mid - 1, key);
    }

    public static void main(String[] args) {

        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int key = 3;
        int idx = search(arr, 0, arr.length - 1, key);
        System.out.println(idx);
    }
}
