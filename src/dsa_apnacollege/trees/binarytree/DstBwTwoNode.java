package dsa_apnacollege.trees.binarytree;

/* 
    Q: Find Distance Between 2 Nodes
    O(N)
*/
public class DstBwTwoNode {

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static int ans;

    static int findDist(Node root, int a, int b) {
        if (root == null)
            return 0;
        int left = findDist(root.left, a, b);
        int right = findDist(root.right, a, b);
        if (root.data == a || root.data == b) {
            if (left != 0 || right != 0) {
                ans = Math.max(left, right);
                return 0;
            } else {
                return 1;
            }
        } else if (left != 0 && right != 0) {
            ans = left + right;
            return 0;
        } else if (left != 0 || right != 0) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        ans = 0;
        findDist(root, 4, 5);
        System.out.println(ans);
    }
}
