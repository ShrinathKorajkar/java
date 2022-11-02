package dsalgo.dsques;

/* 
    3. Detect if cycle is present 
    4. Duplicate a LinkedList with random pointers
*/
public class LinkedList3 {

    // DETECT CYCLE
    Node detectCycle(Node head) {
        Node slow = head, fast = head;
        Node meet = null, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meet = slow;
                break;
            }
        }
        while (start != meet) {
            start = start.next;
            meet = meet.next;
        }
        return start;
    }

    // DUPLICATE
    Node duplicate(Node head) {
        Node cur = head;
        while (cur != null) { // inserting new list
            Node temp = cur.next;
            cur.next = new Node(cur.data);
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur != null) { // setting random pointers
            if (cur.next != null) {
                cur.next.random = cur.random != null ? cur.random.next : null;
            }
            cur = cur.next.next;
        }
        Node org = head, copy = head.next;
        Node temp = copy;
        while (org != null) { // seperating list
            org.next = org.next.next;
            copy.next = copy.next.next;
            org = org.next;
            copy = copy.next;
        }
        return temp;
    }

    class Node {
        int data;
        Node next;
        Node random;

        Node(int data) {
            this.data = data;
        }
    }
}
