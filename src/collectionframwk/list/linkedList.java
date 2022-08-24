package collectionframwk.list;

import java.util.LinkedList;
import java.util.Queue;

/*
    present in both queue and list
*/
public class linkedList {
    public static void main(String[] args) {

        Queue<Integer> myPQueue = new LinkedList<Integer>();
        // List<Integer> myPQueue = new LinkedList<Integer>(); // use list methods

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