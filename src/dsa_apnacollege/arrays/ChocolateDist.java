package dsa_apnacollege.arrays;

import java.util.Arrays;

/*
    given n array of integers representing value of chocolates in each packet, there are m students
    distribute chocolates such that max chocolates and min chocolates given is min
    Input : [7, 3, 2, 4, 9, 12]     m = 3
    Output : 2 ([2,3,4])  
    time : O(n log n)      space : O(1)
*/
public class ChocolateDist {

    static int findMinDif(int[] arr, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        Arrays.sort(arr);
        if (n < m)
            return -1;
        int minDif = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            if (arr[i + m - 1] - arr[i] < minDif) {
                minDif = arr[i + m - 1] - arr[i];
            }
        }
        return minDif;
    }

    public static void main(String[] args) {

        int[] chocolates = { 7, 3, 2, 4, 9, 12 };
        int noOfStudent = 3;

        int minDif = findMinDif(chocolates, chocolates.length, noOfStudent);
        System.out.println(minDif);
    }
}
