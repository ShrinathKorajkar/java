package dsa_apnacollege.greedy;

/* 
    Q: Find smallest no with given sum and no of digits
    input: sum = 20, digits = 3
    ouput: 299
    O(m) -> value of integer
*/
public class SumWDigits {

    static void findSmallest(int m, int s) {
        if (s == 0) {
            System.out.println(m == 1 ? "Smallest no is 0" : "Not possible");
            return;
        }
        if (s > 9 * m) {
            System.out.println("Not possible");
            return;
        }
        int[] res = new int[m];
        s -= 1;
        for (int i = m - 1; i > 0; i--) {
            if (s > 9) {
                res[i] = 9;
                s -= 9;
            } else {
                res[i] = s;
                s = 0;
            }
        }
        res[0] = s + 1;
        System.out.println("Smallest no is ");
        for (int i = 0; i < m; i++) {
            System.out.print(res[i]);
        }
    }

    public static void main(String[] args) {
        int s = 20, m = 3;
        findSmallest(m, s);
    }
}
