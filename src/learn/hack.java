package learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class hack {
    static boolean[] SeiveOfEratosthenes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }

    static int bots(String str, int n) {
        int bots = 0;
        char[] strarr = str.toCharArray();
        boolean isPrime[] = SeiveOfEratosthenes(n);
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < n; i++) {
            set.add(strarr[i]);
            if (i % 2 == 0 && isPrime[set.size()]) {
                bots++;
            }
        }
        return bots;
    }

    public static void main(String[] args) {
        int n = 6;
        String str = "aabagh";
        System.out.println(bots(str, n));
    }
}
