package dsalgo.trees;

/* 
    1. Lowest Common Ancestor of Two nos
    2. Burn Tree -> given leaf node return time to burn complete
*/
public class BinTree3 {

    // LCA
    Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left == null)
            return right;
        if (right == null)
            return left;

        return root;

    }

    // BURN TREE
    static int time = -1;

    static class Depth {
        int d;

        public Depth(int d) {
            this.d = d;
        }
    }

    static int minTime(Node root, int target) {
        Depth depth = new Depth(-1);
        burn(root, target, depth);
        return time;
    }

    static int burn(Node root, int target, Depth depth) {
        if (root == null)
            return 0;
        if (root.data == target) {
            depth.d = 0;
            return 1;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(root.left, target, ld);
        int rh = burn(root.right, target, rd);

        if (ld.d != -1) {
            time = Math.max(time, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        } else if (rd.d != -1) {
            time = Math.max(time, rd.d + 1 + lh);
            depth.d = rd.d + 1;
        }
        return Math.max(lh, rh) + 1;
    }

    class Node {
        Node right, left;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}
