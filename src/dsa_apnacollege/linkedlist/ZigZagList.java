package dsa_apnacollege.linkedlist;

/* 
    Q: Given LL arrange it in form a < b > c < d > e < f >...
    input: 11->15->20->5->10
    output: 11->20->5->15->10
    O(N)

    Q: Rearrange in order L0, L1....Ln-1, Ln into L0, Ln, L1, Ln-1..... in place
    input: 1->2->3->4->5
    output: 1->5->2->4->3
*/
public class ZigZagList {

    static class Node {
        int data;
        Node next;
    }

    static void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    static Node zigZag(Node node, int flag) {
        if (node == null || node.next == null)
            return node;
        if (flag == 0) { // check a < b
            if (node.data > node.next.data)
                swap(node, node.next);
            return zigZag(node.next, 1);
        } else { // check b > c
            if (node.data < node.next.data)
                swap(node, node.next);
            return zigZag(node.next, 0);
        }
    }

    // Q2
    static Node left;

    static void reOrderList(Node right) { // initally left = right = head
        if (right == null) {
            return;
        }
        reOrderList(right.next);
        if (left == null) {
            return;
        }
        if (left != right && left.next != right) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        } else {
            if (left.next == right) {
                left.next.next = null;
                left = null;
            } else {
                left.next = null;
                left = null;
            }
        }
    }

    public static void main(String[] args) {
        Node head = null;
        left = head;
    }
}
