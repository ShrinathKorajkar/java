package dsalgo.trees;

public class Bst2 {
    // CHECK FOR BST
    boolean isBst(Node root, int min, int max) { // min = Integer.Min, max = Integer.Max
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        return isBst(root.left, min, root.data - 1) && isBst(root.right, root.data + 1, max);
    }

    Node prev = null;

    boolean isBst(Node root) {
        if (root == null)
            return true;

        if (!isBst(root.left))
            return false;
        if (prev != null && root.data <= prev.data)
            return false;
        prev = root;
        return isBst(root.right);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}