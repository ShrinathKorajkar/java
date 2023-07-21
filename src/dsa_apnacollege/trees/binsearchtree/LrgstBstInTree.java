package dsa_apnacollege.trees.binsearchtree;

/*
    Q: Largest BST in a Binary Tree
    input:      5
              2   4
            1   3

    output: 3 => (1, 2, 3)
    O(n)

    check if largest in leftsubtree < x > smallest in rightsubtree
*/
public class LrgstBstInTree {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
        }
    }

    static class NodeInfo {
        int size;
        int max;
        int min;
        boolean isBst;

        NodeInfo() {
        }

        NodeInfo(int size, int max, int min, boolean isBst) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBst = isBst;
        }
    }

    static NodeInfo largestBst(Node root) {
        if (root == null) {
            return new NodeInfo(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        NodeInfo left = largestBst(root.left);
        NodeInfo right = largestBst(root.right);

        NodeInfo info = new NodeInfo();

        info.min = Math.min(left.min, root.data);
        info.max = Math.max(left.max, root.data);
        info.isBst = left.isBst && right.isBst && root.data > left.max && root.data < right.min;

        if (info.isBst)
            info.size = left.size + right.size + 1;
        else
            info.size = Math.max(left.size, right.size);

        return info;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        System.out.println(largestBst(root).size);
    }
}
