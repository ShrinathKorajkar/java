package dsa_apnacollege.stacknqueues;

/* 
    Q: Given a string consisting of opening and closing paranthesis, find length of
       longest valid paranthesis substring
    input: ()(()))))
    output: 6 -> ()(())
    O(n)
*/
public class LongstValidSubStr {

    static int solve(String s, int n) {
        int left = 0, right = 0;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxlen = Math.max(maxlen, 2 * right);
            else if (right > left)
                left = right = 0;
        }

        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else
                right++;

            if (left == right)
                maxlen = Math.max(maxlen, 2 * left);
            else if (left > right)
                left = right = 0;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(solve("()(()))))", 9));
    }

    /*
     * if ( put in stack
     * else if stack empty len = 0
     * else pop, len++, maxlen = (len, maxlen)
     */
}
