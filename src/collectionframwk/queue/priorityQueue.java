package collectionframwk.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
    add(), element(), remove() -> return exeception if cannot do anything
    offer(), peek(), poll() -> return false, null if cannot do
    Uses min heap to store elements -> smallest element first (all operation are in log(n))
*/
public class priorityQueue {
    public static void main(String[] args) {

        // Queue<Integer> myPQueue = new PriorityQueue<Integer>();
        Queue<Integer> myPQueue = new PriorityQueue<Integer>(Comparator.reverseOrder()); // implements max heap

        // Add elem
        myPQueue.offer(4);
        myPQueue.offer(2);
        myPQueue.offer(1);
        myPQueue.offer(3);
        System.out.println(myPQueue);

        // Remove elem
        myPQueue.poll();
        System.out.println(myPQueue);

        // Peek next value on front
        System.out.println(myPQueue.peek());
    }

}
