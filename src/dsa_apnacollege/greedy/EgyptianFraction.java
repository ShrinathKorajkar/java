package dsa_apnacollege.greedy;

/* 
    Q: Given positive fraction, represent it using unit fraction(1/n) or EgyptianFraction
    input: 6/14 
    output: 1/3 + 1/11 + 1/231
*/
public class EgyptianFraction {

    static void egyptianFraction(int nr, int dr) {
        if (dr == 0 || nr == 0)
            return;

        if (dr % nr == 0) {
            System.out.print("1/" + dr / nr);
            return;
        }
        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }
        if (nr > dr) {
            System.out.print(nr / dr + " + ");
            egyptianFraction(nr % dr, dr);
            return;
        }
        int n = dr / nr + 1;
        System.out.print("1/" + n + " + ");
        egyptianFraction(nr * n - dr, dr * n);
    }

    public static void main(String[] args) {
        int nr = 6, dr = 14;
        System.out.println("EgyptianFraction : ");
        egyptianFraction(nr, dr);
    }
}
