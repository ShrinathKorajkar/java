package dsa_apnacollege.stacknqueues;

import java.util.LinkedList;
import java.util.Queue;

/* 
    Q: Implement stack(LIFO) usign only two queue -> push, pop, top, empty
    O(1)
*/
public class StkUsingQ {

    private static Queue<Integer> queue = new LinkedList<Integer>();

    static void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    static int pop() {
        return queue.remove();
    }

    static int top() {
        return queue.peek();
    }

    static boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        push(1);
        push(1);
        push(1);
        System.out.println(pop());
    }
}
