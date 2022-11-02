package dsa_apnacollege.strings.med;

import java.util.LinkedList;
import java.util.Queue;

/* 
    TRANSFORM ONE STRING TO ANOTHER
    Q: given operations -> remove any element and insert it in front
    input: "EACBD" -> "EABCD"
    output: 3 -> 1. pick b and insert front = "BEACD"
                 2. pick a and insert front = "ABECD"
                 3. pick e and insert front = "EABCD"
    O(n)
*/
public class TfrmStrtoStr2 {

    static int minOp(String A, String B) {
        if (A.length() != B.length()) {
            return -1;
        }
        int i, j, res = 0;
        int count[] = new int[256];

        for (i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }

        for (i = 0; i < A.length(); i++) {
            if (count[A.charAt(i)] != 0) {
                return -1;
            }
        }

        Queue<Character> q = new LinkedList<Character>();
        for (i = A.length() - 1; i >= 0; i--) {
            q.offer(A.charAt(i));
        }
        j = B.length() - 1;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == B.charAt(j)) {
                j--;
            } else {
                res++;
                q.offer(c);
            }
        }

        // i = A.length() - 1;
        // j = B.length() - 1;
        // while (i >= 0) {
        // if (A.charAt(i) != B.charAt(j)) {
        // res++;
        // } else {
        // j--;
        // }
        // i--;
        // }

        return res;
    }

    public static void main(String[] args) {

        String A = "AECBD";
        String B = "EABCD";
        System.out.println(minOp(A, B));
    }
}
