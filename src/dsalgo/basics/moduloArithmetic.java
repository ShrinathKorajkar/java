package dsalgo.basics;

/*
    compute : (a + b) % n = (a % n + b % n) % n
    in case of large number use modulo arithmetic in every a + b
    similarly for -, * but not /
    (ans)^b = ()10^9 + 7

    to find power( O(log n) )
    a^b = (a ^ 2)^b/2  if even 
    else  (a * a ^ b-1);
*/

public class moduloArithmetic {

    public static int findPow(int a, int b) {

        if (b == 1)
            return a;

        if ((b & 1) == 0) {
            a = a * a;
            return findPow(a, b / 2);
        }

        return findPow(a, b - 1) * a;
    }

    public static long fastPower(long a, long b, int n) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                // res = res * a
                res = (res * a % n) % n;
            }
            // a = a * a;
            a = (a % n * a % n) % n;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(fastPower(134513, 5, 1000000007));
        System.out.println(findPow(2, 3));
    }
}
