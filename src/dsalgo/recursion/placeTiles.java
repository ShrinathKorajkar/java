package dsalgo.recursion;

/*
given 1 * m tile length we have to place it in n * m matrix and print ways
*/

public class placeTiles {

    public static int place(int n, int m) {
        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }

        int placeHorizontal = place(n - 1, m);
        int placeVertical = place(n - m, m);

        return placeHorizontal + placeVertical;
    }

    public static void main(String[] args) {
        int n = 5, m = 4;
        System.out.println(place(n, m));
    }
}
