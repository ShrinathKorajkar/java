package dsa_apnacollege.searchsort;

/* 
    Q: Searching in array where adjacent differ by atmost k
    input: [20, 40, 50, 70, 60]     k = 20      x = 60
    output: 4
    O(N)
*/
public class AdjDiffbyK {

    // x must be atleast diff/k away, diff = x - arr[i]
    static int search(int arr[], int n, int k, int x) {
        int i = 0;
        while (i < n) {
            if (arr[i] == x)
                return i;
            i = i + Math.max(1, Math.abs(arr[i] - x) / k);
        }
        System.out.println("number is not present");
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = { 20, 40, 50, 70, 60 };
        int k = 20, x = 60;
        System.out.println(search(arr, arr.length, k, x));
    }
}
