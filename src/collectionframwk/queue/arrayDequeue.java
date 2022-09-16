package collectionframwk.queue;

import java.util.ArrayDeque;

/* 
    extraMethods : peek, offer, poll, Element
    usage : stack -> push, pop, peek
    queue -> offer, poll, peek
    dequeue -> offerfirst, last
*/

public class arrayDequeue {
    public static void main(String[] args) {

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        // add elements at both sides
        deque.offer(1);
        deque.offerLast(2);
        deque.offerFirst(3);
        deque.offer(4);
        System.out.println(deque);

        // peek elements
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.peek());
        System.out.println(deque);

        // remove elements
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.poll());
        System.out.println(deque);
    }

}
