package dsalgo.dsques;

public class CircQueue {

    static int queue[];
    static int N;
    static int front = -1, rear = -1;

    public void CQueue(int n) {
        N = n;
        queue = new int[n];
    }

    public static void enQueue(int data) {
        if ((rear + 1) % N == front) {
            System.out.println("OVERFLOW");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % N;
        queue[rear] = data;
    }

    public static int deQueue() {
        if (front == -1) {
            System.out.println("UNDERFLOW");
            return -1;
        }
        int res = queue[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % N;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
