package dsa_apnacollege.arrays.med;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
    Q: Arrange the numbers to form biggest no
    input: [54, 546, 548, 60]
    output: [60, 548, 546, 54] - 6054854654
    O(n)
*/
public class BiggestNo {

    static void biggestNo(ArrayList<Integer> numbers) {
        Collections.sort(numbers, new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                int xy = x;
                int yx = y;
                int countx = 0, county = 0;

                while (x > 0) {
                    countx++;
                    x /= 10;
                }
                while (y > 0) {
                    county++;
                    y /= 10;
                }

                x = xy;
                y = yx;

                xy = xy * (int) Math.pow(10, county);
                yx = yx * (int) Math.pow(10, countx);

                xy += y; // append y to x
                yx += x; // append x to y

                return -xy + yx; // xy = 6054, yx = 5460
            }
        });

        // print results
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(54);
        numbers.add(546);
        numbers.add(548);
        numbers.add(60);

        biggestNo(numbers);
    }
}