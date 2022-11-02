package dsa_apnacollege.strings.med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
    GROUP ANAGRAM
    input: ["eat", "tea", "tan", "ate", "nat", "bat"]
    output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
    O(n logn)
*/
public class GrpAnagram {

    static List<List<String>> groupAnagrams(String[] str) {
        if (str == null || str.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = new ArrayList<>();
        list = groupAnagrams(str);
        for (List<String> li : list) {
            for (String s : li) {
                System.out.print(s + " ");
            }
        }
    }
}
