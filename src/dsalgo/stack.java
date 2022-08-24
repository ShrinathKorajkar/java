package dsalgo;

// capacity is the stack capacity , 
// pop returns -1 for empty and position for poped element ,
//  stackcontent will return stack content

class stackds {
    int capacity = 10;
    int top = -1;
    int stk[] = new int[capacity];

    public void push(int element) {
        stk[++top] = element;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        } else {
            top--;
            return top + 1;
        }
    }

    public int[] stackContent() {
        int rem[] = new int[top + 1];
        if (top == -1) {
            return null;
        } else {
            System.out.println("elements of stack ");
            for (int x = 0; x <= top; x++) {
                rem[x] = stk[x];
            }
            return rem;
        }
    }
}

public class stack {
    public static void main(String args[]) {
        stackds obj = new stackds();
        obj.push(1);
        int elem = obj.pop();
        System.out.println(elem);
        System.out.println(obj.stackContent());
    }
}
