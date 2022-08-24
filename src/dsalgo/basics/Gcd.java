package dsalgo.basics;
/*
    gcd(a,b) = gcd(a-b, b); if b < a else gcd(a, b - a) -> return no which is not zero at last
*/

public class Gcd {

    public static int euclidGcd(int a, int b) {

        if (b == 0)
            return a;
        return euclidGcd(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println(euclidGcd(15, 27));
        System.out.println(euclidGcd(24, 60));
    }
}
