package dsalgo.dsques;

/* 
    LINKED LIST
    1. reverse linked list
*/
public class LinkedList1 {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void insert(int data, Node head, int pos) {
        Node toAdd = new Node(data);
        if (pos == 0) {
            toAdd.next = head;
            head = toAdd;
            return;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        toAdd.next = prev.next;
        prev.next = toAdd;
    }

    void delete(Node head, int pos) {
        if (pos == 0) {
            head = head.next;
            return;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // Reverse linked list
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
}
