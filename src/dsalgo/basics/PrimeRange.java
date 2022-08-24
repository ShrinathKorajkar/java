package dsalgo.basics;

import java.util.Arrays;

// Seive Of Eratosthenes -> to find prime nos in range
// if root(n) is not divisible then no is prime

public class PrimeRange {

    static boolean[] SeiveOfEratosthenes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) { // loop from 2 to root(n)
            for (int j = i * 2; j <= n; j += i) { // table of i from i*2 to i*n
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {

        int num = 100;
        boolean primeNos[] = SeiveOfEratosthenes(num);
        for (int i = 0; i < primeNos.length; i++) {
            if (primeNos[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
