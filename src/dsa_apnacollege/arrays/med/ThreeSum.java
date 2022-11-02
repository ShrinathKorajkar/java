package dsa_apnacollege.arrays.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
    Q: Given array, return triplet such that sum = 0
    input : [-1, 0, 1, 2, -1, -4]
    output: [[-1, -1, 2], [-1, 0, -1]]
    O(n ^ 2)
*/
public class ThreeSum {

    static List<List<Integer>> threeSum(int[] num) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if (num.length == 0)
            return new ArrayList<>(set);
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int j = i + 1;
            int k = num.length - 1;
            // twoSum
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0)
                    set.add(Arrays.asList(num[i], num[j++], num[k--]));
                else if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {

        int arr[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> num = new ArrayList<>();
        num = threeSum(arr);
        for (List<Integer> i : num) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
