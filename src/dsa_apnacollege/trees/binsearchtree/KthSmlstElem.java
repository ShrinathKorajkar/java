package dsa_apnacollege.trees.binsearchtree;

/*
    Q: Kth Smallest Element in BST
    input:      3           k = 1
              1   4
                2
    outptu: 1
    O(N)
*/
public class KthSmlstElem {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    static int count = 0;
    static int result = Integer.MIN_VALUE;

    static void traverse(Node root, int k) {
        if (root == null)
            return;
        traverse(root.left, k);
        count++;
        if (count == k)
            result = root.data;
        if (count < k)
            traverse(root.right, k);

    }

    static int kthSmallerElement(Node root, int k) {
        traverse(root, k);
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.right = new Node(2);

        System.out.println(kthSmallerElement(root, 1));
    }
}
