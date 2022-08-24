package dsalgo.recursion;

import java.util.HashSet;

/*
we have a string we have to find all subsequences i.e "abc" -> 'abc', 'ab.', '.bc', 'a.c', 'a..', '.b.', '..c', '...'
time -> O(2^n)

also for subseq where duplicates not allowed
*/

public class subsequences {

    public static void subseq2(String str, int indx, String newStr, HashSet<String> set) {

        if (indx == str.length()) {
            if (set.contains(newStr)) {
                return;
            } else {
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }
        char currChar = str.charAt(indx);

        // to be
        subseq2(str, indx + 1, newStr + currChar, set);

        // not to be in substr
        subseq2(str, indx + 1, newStr, set);
    }

    public static void subseq(String str, int indx, String newStr) {
        if (indx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(indx);

        // to be
        subseq(str, indx + 1, newStr + currChar);

        // not to be in substr
        subseq(str, indx + 1, newStr);
    }

    public static void main(String[] args) {
        String str = "abc";
        HashSet<String> set = new HashSet<String>();
        subseq(str, 0, ""); // duplicates allowed
        str = "aaa";
        subseq2(str, 0, "", set); // duplicates not allowed
    }
}