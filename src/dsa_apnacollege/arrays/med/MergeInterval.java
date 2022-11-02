package dsa_apnacollege.arrays.med;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/* 
    MERGE OVERLAPPING INTERVALS
    Q: Given intervals merge overlapping intervals
    input : [[1, 3], [2, 4], [6, 8], [9, 10]]
    output: [[1, 4], [6, 8], [9, 10]]
    O(N logN)
*/
public class MergeInterval {

    static void mergeOverlappingIntervals(Interval arr[]) {
        if (arr.length <= 0)
            return;
        Stack<Interval> stack = new Stack<Interval>();
        Arrays.sort(arr, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }

        });
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Interval top = stack.peek();
            if (top.end < arr[i].start)
                stack.push(arr[i]);
            else if (top.end < arr[i].end) {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        // printing
        System.out.println("Merged Intervals : ");
        while (!stack.isEmpty()) {
            Interval t = stack.pop();
            System.out.println("[" + t.start + "," + t.end + "]");
        }
    }

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
