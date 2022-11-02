package dsalgo.dsques;

import java.util.ArrayDeque;
import java.util.Deque;

/* 
    Q: Find max area in histogram
    input: histogram length (4, 2, 1, 5, 6, 3, 2, 4, 2)
    output: 12 (2 * 6 from right)
    O(n)
*/
public class Stack2 {

    private static int[] previousSmaller(int a[]) {

        Deque<Integer> stack = new ArrayDeque<Integer>();
        int arr[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {

            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                arr[i] = -1;
            } else {
                arr[i] = stack.peek();
            }
            stack.push(i);
        }
        return arr;
    }

    private static int[] nextSmaller(int a[]) {

        Deque<Integer> stack = new ArrayDeque<Integer>();
        int arr[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                arr[i] = a.length;
            } else {
                arr[i] = stack.peek();
            }
            stack.push(i);
        }
        return arr;
    }

    private static int maxArea(int arr[]) {
        int prevSm[] = previousSmaller(arr);
        int nextSm[] = nextSmaller(arr);
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            area = (nextSm[i] - prevSm[i] - 1) * arr[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int arr[] = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };
        System.out.println(maxArea(arr));
    }
}
