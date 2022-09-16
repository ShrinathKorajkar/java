package dsalgo.trees;

/*
    BINARY SEARCH TREE O(logn)
*/

public class Bst1 {

    // SEARCH NODE IN BST
    static boolean search(Node root, int x) {
        if (root == null)
            return false;
        if (root.data == x)
            return true;
        if (root.data < x)
            return search(root.right, x);

        return search(root.left, x);
    }

    // INSERT
    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);
        if (root.data > key)
            root.left = insert(root.left, key);
        if (root.data < key)
            root.right = insert(root.right, key);

        return root;
    }

    // DELETE
    static int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    static Node delete(Node root, int key) {

        if (root == null)
            return root;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.right;
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        Node n = new Node(10);
        System.out.println(n);
    }
}
