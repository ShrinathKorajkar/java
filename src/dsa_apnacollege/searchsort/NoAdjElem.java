package dsa_apnacollege.searchsort;

/* 
    Q: Maximum sum such that no two elements are adjacent
    input: [5, 5, 10, 100, 10, 5]
    output: 110 -> (5, 100, 5)
    O(N)
*/
public class NoAdjElem {

    // incl contains sum if previous included, excl if not included
    // thus current incl = previous excl + arr[i]
    // current excl = Max(previous incl, previous excl)
    static int findMaxSum(int[] arr, int n) {
        int incl = arr[0]; // sum if current element is included
        int excl = 0; // sum if current element is excluded
        int i, exclNew;
        for (i = 1; i < n; i++) {
            exclNew = Math.max(incl, excl);
            incl = excl + arr[i];
            excl = exclNew;
        }
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {

        int arr[] = { 5, 5, 10, 100, 10, 5 };
        System.out.println(findMaxSum(arr, arr.length));
    }
}
