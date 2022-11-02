package dsa_apnacollege.strings.med;

/* 
    WILDCARD STRING MATCHING (? *)
    input: "ge?ks*"     "geeksforgeeks"
    ouput: true
    O(m * n) - both
*/
public class WildCardMatch {

    static boolean wildCardMatch(char[] wild, int i, int len1, char[] pattern, int j, int len2) {
        if (i == len1 && j == len2)
            return true;

        if (i == len1)
            return false;

        if (wild[i] == '*') {
            while (i + 1 < len1 && wild[i + 1] == '*')
                i++;

            if (j == len2) {
                if (i + 1 == len1)
                    return true;
                else
                    return false;
            }
            return wildCardMatch(wild, i + 1, len1, pattern, j, len2) ||
                    wildCardMatch(wild, i, len1, pattern, j + 1, len2);
        }

        if (wild[i] == '?' || wild[i] == pattern[j])
            return wildCardMatch(wild, i + 1, len1, pattern, j + 1, len2);

        return false;
    }

    static boolean match(String wild, String pattern) {
        int len1 = wild.length();
        int len2 = pattern.length();
        return wildCardMatch(wild.toCharArray(), 0, len1, pattern.toCharArray(), 0, len2);
    }

    static public void main(String[] args) {
        String wild = "ge?ks*";
        String pattern = "geeksforgeeks";
        System.out.println(match(wild, pattern));
    }
}
