package dsa_apnacollege.hashing;

import java.util.ArrayList;
import java.util.HashMap;

/*
    Q: Find Next Greater Element for every element
    input: {4, 5, 2, 25}
    output: 4 -> 5          5 -> 25
            2 -> 25         25 -> -1
    approach - stack, Map(hash)
    O(N)
*/
public class NextGreaterElem {

    static void nextGreaterElement(int[] arr, int n) {
        ArrayList<HashMap<String, Integer>> stack = new ArrayList<HashMap<String, Integer>>();
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && stack.get(stack.size() - 1).get("value") < arr[i]) {
                HashMap<String, Integer> map = stack.get(stack.size() - 1);
                arr[map.get("ind")] = arr[i];
                stack.remove(stack.size() - 1);
            }
            HashMap<String, Integer> newMap = new HashMap<String, Integer>();
            newMap.put("ind", i);
            newMap.put("value", arr[i]);
            stack.add(newMap);
        }
        while (stack.size() > 0) {
            HashMap<String, Integer> map = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            arr[map.get("ind")] = -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        int[] res = arr.clone();
        nextGreaterElement(res, res.length);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%2d -> %2d\n", arr[i], res[i]);
        }
    }
}
