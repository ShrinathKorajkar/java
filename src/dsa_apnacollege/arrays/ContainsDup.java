package dsa_apnacollege.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    return true if any value appears at least twice, else false
    Input : nums = [1, 2, 3, 1]
    Output : true
*/
public class ContainsDup {

    // O(N) space - O(N)
    static boolean containsDuplicate2(int[] nums) {

        final Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    // O(n logn) space - O(1)
    static boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };

        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }
}
