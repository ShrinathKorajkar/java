package dsalgo.basics;

// find trailing zeroes in factorial of given no
// we get zeroes with 5 -> count no of 5 (10 contains 2*5 - 1, 25 contains 5*5 - 2)

public class Factorial {
    public static void main(String[] args) {

        int num = 25;
        int res = 0;
        for (int i = 5; i <= num; i *= 5) {
            res = res + num / i;
        }
        System.out.println("no of trailing zeroes : " + res);
    }
}
