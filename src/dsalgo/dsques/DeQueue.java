package dsalgo.dsques;

import java.util.ArrayDeque;
import java.util.Deque;

/* 
    Q: SLIDING WINDOW MAXIMUM : find max element in given window size
    input : arr[4, 1, 3, 5, 1, 2, 3 ,2, 1, 1, 3]    , k = 3
    ouput : [4, 5, 5, 5, 3, 3, 3, 2, 3] -> n - k + 1
    O(n)
*/
public class DeQueue {

    static void printMax(int arr[], int k) {

        Deque<Integer> dq = new ArrayDeque<Integer>();
        int i;
        for (i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(arr[i]);
        }

        for (; i < arr.length; i++) {
            System.out.print(dq.peek() + " ");
            if (arr[i - k] == dq.peek()) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && arr[i] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(arr[i]);
        }

        System.out.println(dq.peek());
    }

    public static void main(String[] args) {

        int arr[] = { 4, 1, 3, 5, 1, 2, 3, 2, 1, 1, 3 };
        int k = 3;
        printMax(arr, k);
    }
}
