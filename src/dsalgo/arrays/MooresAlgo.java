package dsalgo.arrays;

/*
    MOORE'S ALGORITHM
    majority element : element present more than n/2 times in array.
    it finds majority element in given array.
    input : [1, 1, 2, 3, 1]
    output : 1
    O(N)

    boyre-moore
*/

public class MooresAlgo {

    private static void majorityElem(int[] arr) {
        int majElem = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (majElem == arr[i])
                count++;
            else
                count--;

            if (count == 0) {
                count++;
                majElem = arr[i];
            }
        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (majElem == arr[i])
                count++;
        }

        if (count > arr.length / 2) {
            System.out.println("Majority element : " + majElem);
            return;
        }

        System.out.println("no majority element");
    }

    public static void main(String[] args) {

        int arr[] = { 1, 1, 3, 4, 1 };

        majorityElem(arr);

    }
}
