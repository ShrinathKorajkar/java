package dsalgo.dsques;

/* 
    2. Find if LinkedList is Pallindrome
*/

public class LinkedList2 {

    // Pallindrome
    boolean pallindrome(Node head) {
        if (head == null)
            return true;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node last = reverse(mid);
        Node cur = head;
        while (last != null) {
            if (last.data != cur.data)
                return false;
            last = last.next;
            cur = cur.next;
        }
        return true;
    }

    Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
