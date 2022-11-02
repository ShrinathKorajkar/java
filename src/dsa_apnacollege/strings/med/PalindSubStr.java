package dsa_apnacollege.strings.med;

/* 
    PALINDROMIC SUBSTRING
    also largest palindromic substring
    input: "aaa"
    ouput: 6 ->(a, a, a, aa, aa,  aaa)
*/
public class PalindSubStr {

    static int countSubs(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += extendPalind(str, i, i); // odd length aba
            count += extendPalind(str, i, i + 1); // even length aa
        }
        return count;
    }

    static int extendPalind(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    static public void main(String[] args) {

        String str = "aaa";
        System.out.println(countSubs(str));
    }
}
