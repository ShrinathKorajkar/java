package dsalgo.bitmanip;

import java.util.Scanner;

public class BitM_ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number : ");
        int num = sc.nextInt();
        int one = 0;
        while (num > 0) {
            int bit = num & 1;
            if (bit == 1) {
                one++;
            }
            num = num >> 1; // num / 2
        }
        if (one == 1) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not Power of 2");
        }
        sc.close();
    }
}