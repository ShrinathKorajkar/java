package collectionframwk;

import java.util.Arrays;

public class arraysClass {
    public static void main(String[] args) {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int index = Arrays.binarySearch(numbers, 4);
        System.out.println("element foud on index " + index);
        Arrays.sort(numbers);
        // System.out.println(numbers); cannot do this

        Integer[] numbers2 = { 10, 11, 12, 13, 14, 15, 16, 17, 18 };
        Arrays.sort(numbers2);

        // used to fill all elements with val
        Arrays.fill(numbers2, 19);

        int[] temp = Arrays.copyOfRange(numbers, 0, 5);
        System.arraycopy(numbers, 0, temp, 0, 5);

        for (int i : numbers2) {
            System.out.println(i + " ");
        }

        Character.isDigit('1');
        Character.getNumericValue('1');
        Integer.parseInt("2");
    }
}
