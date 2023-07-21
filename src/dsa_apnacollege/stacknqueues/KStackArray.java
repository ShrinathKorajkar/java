package dsa_apnacollege.stacknqueues;

/* 
    Q: Implement k stacks in a single array
    input: push(elem, stckno)       pop(stckno)
    O(N)
*/
public class KStackArray {

    static class KStack {
        int arr[];
        int top[];
        int next[];
        int n, k;
        int free;

        KStack(int k1, int n1) {
            k = k1;
            n = n1;
            arr = new int[n];
            top = new int[k];
            next = new int[n];
            for (int i = 0; i < k; i++)
                top[i] = -1;

            free = 0;
            for (int i = 0; i < n - 1; i++)
                next[i] = i + 1;

            next[n - 1] = -1; // indicates end of stack
        }

        void push(int item, int stk) {
            if (free == -1) {
                System.out.println("Stack overflow");
                return;
            }
            int i = free;
            free = next[i];
            next[i] = top[stk];
            top[stk] = i;
            arr[i] = item;
        }

        int pop(int stk) {
            if (top[stk] == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            int i = top[stk];
            top[stk] = next[i];
            next[i] = free;
            free = i;
            return arr[i];
        }
    }

    public static void main(String[] args) {
        KStack ks = new KStack(3, 10);
        ks.push(10, 2);
        ks.push(20, 2);
        ks.push(30, 1);
        ks.push(40, 1);
        System.out.println(ks.pop(2));
        System.out.println(ks.pop(1));
    }
}
