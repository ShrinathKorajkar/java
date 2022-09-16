package dsalgo.dsques;
/* 
    Q: Find previous/nearest smaller element/ next smaller element/ greater element
    input: [4, 10, 5, 18, 3, 12, 7]
    output: -1, 4, 4, 5, -1, 3, 3
    O(n)
    Q: paranthesis matching
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack1 {

    private static void previousSmaller(int a[]) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < a.length; i++) {

            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(stack.peek());
            }
            stack.push(a[i]);
        }

    }

    public static void main(String[] args) {

        int arr[] = { 4, 10, 5, 18, 3, 12, 7 };
        previousSmaller(arr);
    }
}
