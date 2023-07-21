package dsa_apnacollege.trees.binsearchtree;

/* 
    Q: Delete a Node in BST
    input:      5                   5               key = 3
              3   6       =>      4   6
            2   4   7           2       7
    O(N)
    
    if leaf node -> delete
    if left || right = null -> delete and join right or left to parent
    else find sucessor(min in right subtree) leaf node and replace and recur for deletion
*/
public class DelNodeBst {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static TreeNode findMin(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            TreeNode minNode = findMin(root.right);
            root.data = minNode.data;
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    static void printTree(TreeNode root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        root = deleteNode(root, 3);
        printTree(root);
    }
}
