package dsa_apnacollege.arrays;

import java.util.Arrays;

// Program to Find min and max in given array

public class minMax {

    static class MinMax {
        int min;
        int max;
    }

    private static MinMax findMinMax(int[] arr, int length) {

        MinMax Pair = new MinMax();
        if (length == 1) {
            Pair.min = arr[0];
            Pair.max = arr[0];
            return Pair;
        }

        if (arr[0] < arr[1]) {
            Pair.min = arr[0];
            Pair.max = arr[1];
        } else {
            Pair.min = arr[1];
            Pair.max = arr[0];
        }

        for (int i = 2; i < length; i++) {
            if (arr[i] < Pair.min) {
                Pair.min = arr[i];
            } else if (arr[i] > Pair.max) {
                Pair.max = arr[i];
            }
        }

        return Pair;
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 1 };

        MinMax minmax = new MinMax();
        minmax = findMinMax(arr, arr.length);
        System.out.println(minmax.min + " " + minmax.max);

        long endTime = System.nanoTime();

        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[arr.length - 1]);

        long endTime2 = System.nanoTime();

        System.out.println(endTime - startTime);
        System.out.println(endTime2 - endTime); // less time
    }
}
