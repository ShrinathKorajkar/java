package dsalgo.dsques;

import java.util.HashMap;
import java.util.Map;

/*
    Q: find the subarray with given sum                           
    Q: find largest subarray with given sum
    Q: find largest subarray with equal 0 and 1 -> replace 0 by -1 and find sum = 0

    O(N)
*/

public class HashMap1 {

    private static void subArraySum(int a[], int sum) {

        int currSum = 0;
        int start = 0;
        int end = -1;
        // int len = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {

            currSum += a[i];
            if (currSum == sum) {
                start = 0;
                end = i;
                break;
            }

            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }

            // if(end - start > len){
            // len = end - start;
            // }

            map.put(currSum, i);
        }

        if (end != -1) {
            System.out.println("subArray : " + start + "," + end);
        }
    }

    public static void main(String[] args) {

        int array[] = { 10, 15, -10, 15, -15 };
        subArraySum(array, 5);
    }
}
