package dsa_apnacollege.trees.binsearchtree;

import java.util.ArrayList;

/*
    Q: Convert BST to Balanced BST
    input:      4                        4
              3   5         =>        2     6
            2       6               1   3 5   7
          1           7
*/
public class BalancedBst {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void getInorderTraversal(Node root, ArrayList<Node> nodes) {
        if (root == null)
            return;
        getInorderTraversal(root.left, nodes);
        nodes.add(root);
        getInorderTraversal(root.right, nodes);
    }

    static Node buildTreeUtil(Node root, ArrayList<Node> inorder, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = inorder.get(mid);
        node.left = buildTreeUtil(root, inorder, start, mid - 1);
        node.right = buildTreeUtil(root, inorder, mid + 1, end);
        return node;
    }

    static Node buildTree(Node root) {
        ArrayList<Node> inorder = new ArrayList<Node>();
        getInorderTraversal(root, inorder);
        return buildTreeUtil(root, inorder, 0, inorder.size() - 1);
    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        preOrder(root);
        System.out.println();
        root = buildTree(root);
        preOrder(root);
    }
}
