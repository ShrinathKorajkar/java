package dsa_apnacollege.stacknqueues;

import java.util.Stack;

/* 
    Q: Find the duplicate paranthesis in balanced expression
    input: ((a+b)+((c+d)))
    ouput: has duplicate -> c+d is surrounded by 2 pairs of brackets
    O(N)
*/
public class ExpDupBracket {

    static boolean findDuplicate(String str) {
        Stack<Character> stk = new Stack<Character>();
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (ch == ')') {
                char top = stk.peek();
                stk.pop();
                int elemInsd = 0;
                while (top != '(') {
                    elemInsd++;
                    top = stk.peek();
                    stk.pop();
                }
                if (elemInsd < 1) {
                    return true;
                }
            } else {
                stk.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b)+((c+d))";
        System.out.println(findDuplicate(str));
    }
}
