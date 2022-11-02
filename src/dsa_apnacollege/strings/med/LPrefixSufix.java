package dsa_apnacollege.strings.med;

/* 
    LONGEST PREFIX SUFFIX
    input: "aaaa"
    ouput: 3 -> "aaa"
    O(n)
*/
public class LPrefixSufix {

    static int longestPrefixSuffix(String str) {
        int a[] = new int[str.length()];
        int left = 0, right = 1;
        while (right < str.length()) {
            if (str.charAt(right) == str.charAt(left)) {
                a[right] = left + 1;
                left++;
                right++;
            } else {
                if (left == 0)
                    right++;
                else
                    left = a[left - 1];
            }
        }
        return a[str.length() - 1];
    }

    public static void main(String[] args) {

        String str = "aaaa";
        System.out.println(longestPrefixSuffix(str));
    }
}
