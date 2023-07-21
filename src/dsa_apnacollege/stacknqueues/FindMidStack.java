package dsa_apnacollege.stacknqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/* 
    Q: Design a stack with operations on middle element i.e findMiddle() -> return mid element in (1)
       deleteMid() -> delete mid element
*/
public class FindMidStack {

    static class MyStack {
        Stack<Integer> stk;
        Deque<Integer> dq;

        MyStack() {
            stk = new Stack<Integer>();
            dq = new ArrayDeque<Integer>();
        }

        void add(int data) {
            dq.addLast(data);
            if (dq.size() > stk.size() + 1) {
                int temp = dq.pollFirst();
                stk.push(temp);
            }
        }

        int pop() {
            int data = dq.pollLast();
            if (stk.size() > dq.size()) {
                int temp = stk.pop();
                dq.offerFirst(temp);
            }
            return data;
        }

        int getMidElement() {
            return dq.getFirst();
        }

        void deleteMidElement() {
            dq.pollFirst();
            if (stk.size() > dq.size()) {
                int temp = stk.pop();
                dq.offerFirst(temp);
            }
        }
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.add(2);
        s.add(3);
        s.add(5);
        System.out.println(s.getMidElement());
        s.deleteMidElement();
    }
}
