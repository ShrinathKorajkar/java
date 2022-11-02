package dsa_apnacollege.strings.med;

import java.util.HashMap;

/* 
    LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
    input: "abcabcbb"
    output: 3 (abc)
    O(n)
*/
public class LStrWoReChar {

    static int longestSubstring(String str) {
        if (str.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                j = Math.max(j, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {

        String str = "pwwkew";
        System.out.println(longestSubstring(str)); // kew = 3
    }
}