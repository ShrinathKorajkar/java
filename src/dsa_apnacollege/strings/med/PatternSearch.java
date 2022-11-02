package dsa_apnacollege.strings.med;

/* 
    RABIN KARP ALGORITHM (O(nm))
    -> store window hash -> next window of 345 in 3456 is (345 - 3*100)*10 + 6 = 45 * 10 + 6

    BYRE MOORE ALGORITHM (bad character heuristic)
    -> pattern move past mismatch character
    input: "this is a test"     "test"
    output: found at 10
    O(nm)
*/
public class PatternSearch {

    static void badCharHeuristic(char[] str, int size, int[] badChar) {
        for (int i = 0; i < 256; i++)
            badChar[i] = -1;

        for (int i = 0; i < size; i++)
            badChar[str[i]] = i;
    }

    static void search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;
        int badChar[] = new int[256];

        badCharHeuristic(pat, m, badChar);
        int s = 0;
        while (s <= (n - m)) {
            int j = m - 1;
            while (j >= 0 && pat[j] == txt[s + j])
                j--;

            if (j < 0) {
                System.out.println("Patterns occur aat shift = " + s);
                s += (s + m < n) ? m - badChar[txt[s + m]] : 1;
            } else {
                s += Math.max(1, j - badChar[txt[s + j]]);
            }
        }
    }

    public static void main(String[] args) {

        String str = "ABAAABCD";
        String pat = "ABC";
        search(str.toCharArray(), pat.toCharArray());
    }
}
