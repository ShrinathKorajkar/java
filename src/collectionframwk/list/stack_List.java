package collectionframwk.list;

import java.util.Stack;

public class stack_List {
    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>();

        // Adding Elements
        myStack.add(1); // we can use list methods also , if not throw exception
        myStack.push(1);
        System.out.println(myStack);

        // Peek
        System.out.println(myStack.peek());

        // Remove Pop
        System.out.println("element removed : " + myStack.pop());
        System.out.println(myStack);

    }
}
