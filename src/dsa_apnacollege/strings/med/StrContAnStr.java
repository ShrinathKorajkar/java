package dsa_apnacollege.strings.med;

/* 
    SMALLEST WINDOW IN STR CONTAINING ALL CHAR OF ANOTHER STR
    input: "timetopractice"     "toc"
    ouput: "toprac"
    O(n)
*/
public class StrContAnStr {

    static String minWindow(char[] s, char[] t) {
        int m[] = new int[256];
        int ans = Integer.MAX_VALUE;
        int start = 0, count = 0;
        for (int i = 0; i < t.length; i++) {
            if (m[t[i]] == 0)
                count++;
            m[t[i]]++;
        }

        int left = 0, right = 0;
        while (right < s.length) {

            m[s[right]]--;
            if (m[s[right]] == 0)
                count--;

            while (count == 0) {
                if (ans > right - left + 1) {
                    ans = right - left + 1;
                    start = left;
                }
                m[s[left]]++;
                if (m[s[left]] > 0)
                    count++;
                left++;
            }
            right++;
        }
        if (ans != Integer.MAX_VALUE)
            return String.valueOf(s).substring(start, ans + start);
        else
            return "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s.toCharArray(), t.toCharArray()));
    }
}
