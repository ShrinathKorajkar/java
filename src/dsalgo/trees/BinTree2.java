package dsalgo.trees;

/* 
    1. Convert BinTree -> DLL
    2. Diameter of BinTree -> no of nodes between longest path b|w two leaf nodes
*/
public class BinTree2 {

    static Node prev = null, head = null;

    static void convertToDll(Node root) {
        if (root == null) {
            return;
        }
        convertToDll(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDll(root.right);
    }

    // DIAMETER
    static int ans = 0;

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = diameter(root.left);
        int rh = diameter(root.right);
        ans = Math.max(ans, 1 + lh + rh);
        return Math.max(lh, rh) + 1;
    }
}

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
    }
}