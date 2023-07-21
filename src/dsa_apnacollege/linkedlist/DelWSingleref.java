package dsa_apnacollege.linkedlist;

/* 
    Q: Given a single reference to node to be deleted
    input: refNode
    ouput: remove the refNode
    O(1)

    Q: merge two sorted linked list
    O(N + M)
*/
public class DelWSingleref {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void delNode(Node refNode) {
        if (refNode.next == null) { // if this is last node
            refNode = null;
            return;
        }
        Node temp = refNode.next;
        refNode.data = temp.data;
        refNode.next = temp.next;
        temp = null;
    }

    static Node sortMergeList(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.data < l2.data) {
            l1.next = sortMergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = sortMergeList(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }
}
