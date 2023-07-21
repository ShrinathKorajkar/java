package dsa_apnacollege.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/* 
    Q: Find k largest and smallest elements in array
    approaches - sort k times(any algo), Heap(max, min), BST, PriorityQ

    PriorityQ - O(N logK)
*/
public class kLargest {

    static void kLargestElements(int arr[], int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (minHeap.peek() < arr[i]) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }

    static void kSmallestElements(int arr[], int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50 };
        kLargestElements(arr, arr.length, 3);
        kSmallestElements(arr, arr.length, 3);
    }
}
