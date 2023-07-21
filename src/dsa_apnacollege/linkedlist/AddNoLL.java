package dsa_apnacollege.linkedlist;

/* 
    Q: Add 2 nos represented by linked list
    input: 5->6->3      8->4->2
    ouput: 1->4->0->5
    O(M + N)
*/
public class AddNoLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head1, head2, result;
    static int carry;
    static Node cur;

    static void addSameSize(Node n, Node m) {
        if (n == null)
            return;
        addSameSize(n.next, m.next);
        int sum = n.data + m.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        Node newNode = new Node(sum);
        newNode.next = result;
        result = newNode;
    }

    static int getSize(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static void addLists() {
        if (head1 == null) {
            result = head2;
            return;
        }
        if (head2 == null) {
            result = head1;
            return;
        }
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        if (size1 == size2) {
            addSameSize(head1, head2);
        } else {
            if (size1 < size2) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int diff = Math.abs(size1 - size2);
            Node temp = head1;
            while (diff-- >= 0) {
                cur = temp;
                temp = temp.next;
            }
            addSameSize(cur, head2);
            propogateCarry(head1);
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            newNode.next = result;
            result = newNode;
        }
    }

    static void propogateCarry(Node head1) {
        if (head1 != cur) {
            propogateCarry(head1.next);
            int sum = carry + head1.data;
            carry = sum / 10;
            sum %= 10;
            Node newNode = new Node(sum);
            newNode.next = result;
            result = newNode;
        }
    }

    public static void main(String[] args) {

    }
}
