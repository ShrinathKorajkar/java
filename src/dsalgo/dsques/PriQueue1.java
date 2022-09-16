package dsalgo.dsques;

import java.util.PriorityQueue;

/*
    Q: find kth largest element  (min heap)  
    for smallest use max heap      
    O(N logK)
*/

public class PriQueue1 {

    private static void kthlargest(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() < arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        System.out.println(queue.peek());
    }

    public static void main(String[] args) {
        int arr[] = { 20, 10, 60, 30, 50, 40 };
        kthlargest(arr, 3);
    }
}
