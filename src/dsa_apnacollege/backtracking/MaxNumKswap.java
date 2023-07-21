package dsa_apnacollege.backtracking;

/* 
    Q: Find max no possible by doing at-most k swaps
    input: 7599   k = 2
    output: 9975    (for k = 1 -> 9597)
    O(n ^ 2)
*/
public class MaxNumKswap {

    static String res = "";

    static void maxNumPoss(char[] str, int k, String res) {
        if (k == 0)
            return;
        int n = str.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (str[j] > str[i]) {
                    char temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                    String st = new String(str);
                    if (res.compareTo(st) < 0) {
                        res = st;
                    }
                    maxNumPoss(str, k - 1, res);
                    temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String num = "7599";
        maxNumPoss(num.toCharArray(), 2, res);
        System.out.println(res);
    }

}
