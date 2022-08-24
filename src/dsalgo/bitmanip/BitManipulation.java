package dsalgo.bitmanip;

import java.util.Scanner;

public class BitManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num and pos : ");
        int num = sc.nextInt();
        int pos = sc.nextInt();
        int bitMask = 1 << pos;

        // GET BIT
        System.out.println("GET BIT " + num + " POS " + pos);
        if ((bitMask & num) == 0) {
            System.out.println("bit is 0");

        } else {
            System.out.println("bit is 1");
        }

        // SET BIT
        System.out.println("SET BIT " + num + " POS " + pos);
        int newNumber = bitMask | num;
        System.out.println("new number = " + newNumber);

        // CLEAR BIT
        System.out.println("CLEAR BIT " + num + " POS " + pos);
        newNumber = num & (~bitMask);
        System.out.println("new number = " + newNumber);

        sc.close();
    }
}