package dsa_apnacollege.arrays.med;

/* 
    PRODUCT EXCEPT SELF
    Q: Given arr, return arr -> arr[i] = prod of all execpt arr[i]
    input: [1, 2, 3, 4]
    output: [24, 12, 8, 6]
    O(n)
*/
public class ProdXcptSelf {
    static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] += curr; // plus
            curr *= arr[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int[] ans = productExceptSelf(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

}
