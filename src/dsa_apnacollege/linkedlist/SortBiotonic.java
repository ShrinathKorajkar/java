package dsa_apnacollege.linkedlist;

/* 
    Q: Sort biotonic doubly linked list(doubly LL which first inc, then dec)
    input: 20 <-> 17 <-> 14 <-> 8 <-> 3
    output: 3 <-> 8 <-> 14 <-> 17 <-> 20
    O(N)
*/
public class SortBiotonic {

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node reverse(Node head_ref) {
        Node temp = null;
        Node current = head_ref;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head_ref = temp.prev;
        }
        return head_ref;
    }

    static Node merge(Node first, Node second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head.next;
        while (current != null) {
            if (current.data < current.prev.data) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return head;
        }
        current.prev.next = null;
        current.prev = null;
        current = reverse(current);
        return merge(head, current);
    }

    public static void main(String[] args) {

    }
}
