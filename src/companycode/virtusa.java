package companycode;

import java.util.Scanner;

public class virtusa {

    public static int oddSeries(int x) {
        int y;
        if (x <= 1) {
            return 2;
        } else {
            y = oddSeries(x - 2) * oddSeries(x - 2);
        }
        return y;
    }

    public static int evenSeries(int x) {
        int a;
        if (x <= 2) {
            return 2;
        } else {
            a = evenSeries(x - 2) * evenSeries(x - 2) * evenSeries(x - 2);
        }
        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            if (n % 2 == 1) {
                int z = oddSeries(n);
                System.out.println(z);
            } else {
                int b = evenSeries(n);
                System.out.println(b);
            }
        } else {
            System.out.println("invalid input");
        }
        sc.close();
    }
}
