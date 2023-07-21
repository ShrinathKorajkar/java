package dsa_apnacollege.linkedlist;

import java.util.Arrays;

/* 
    HARD    
    Q: Rearrange the characters in a string such that no two adjacent characters are same
    input: aaabc
    output: abaca
    O(N)    O(N + 26)
*/
public class AdjCharNoSame {

    static char getMaxCountChar(int[] count) {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char) ((int) 'a' + i);
            }
        }
        return ch;
    }

    static String rearrangeString(String str) {
        int N = str.length();
        if (N == 1)
            return "Not Possible";

        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (char ch : str.toCharArray()) {
            count[(int) ch - (int) 'a']++;
        }

        char chMax = getMaxCountChar(count);
        int maxCount = count[(int) chMax - (int) 'a'];
        if (maxCount > (N + 1) / 2)
            return "Not Possible";

        char[] res = new char[N];
        int ind = 0;
        while (maxCount > 0) {
            res[ind] = chMax;
            ind += 2;
            maxCount--;
        }
        count[(int) chMax - (int) 'a'] = 0;

        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= N) ? 1 : ind;
                res[ind] = (char) ((int) 'a' + i);
                ind += 2;
                count[i]--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aaaabc"));
    }
}
