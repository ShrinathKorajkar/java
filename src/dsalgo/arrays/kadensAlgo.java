package dsalgo.arrays;

/* 
    KADENE'S ALGORITHM
    find contagious subarray which has largest sum and return its sum 
    input : [-2, 1, -3, 4, -1, 2, 1, -5, 4]
    output : 6 ([4, -1, 2, 1])
    O(N)
*/
public class kadensAlgo {

    static int maxSubArray(int[] array, int size) {
        int sum = 0;
        int large = array[0];

        for (int i = 0; i < size; i++) {
            sum += array[i];
            if (sum > large) // Math.max(large, sum);
                large = sum;
            if (sum < 0)
                sum = 0;
        }
        return large;
    }

    public static void main(String[] args) {

        int[] myarr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int sum = maxSubArray(myarr, myarr.length);
        System.out.println(sum);
    }
}
