package dsalgo.recursion;

// O(2^n)

public class toweOfHanoi {

    public static void Hanoi(int n, String src, String mid, String dest) {
        if (n == 1) {
            System.out.println("move " + n + " from " + src + " to " + dest);
            return;
        }

        Hanoi(n - 1, src, dest, mid);
        System.out.println("move " + n + " from " + src + " to " + dest);
        Hanoi(n - 1, mid, src, dest);
    }

    public static void main(String[] args) {

        int n = 2;
        Hanoi(n, "src", "mid", "dest");

    }
}
