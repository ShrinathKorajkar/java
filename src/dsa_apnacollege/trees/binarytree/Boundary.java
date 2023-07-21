package dsa_apnacollege.trees.binarytree;

import java.util.ArrayList;
import java.util.Stack;

/* 
    Q: Boundary Traversal of Tree
    O(N)
*/
public class Boundary {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static boolean isLeaf(Node node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    static void addLeftBound(Node root, ArrayList<Integer> ans) {
        root = root.left;
        while (root != null) {
            if (!isLeaf(root))
                ans.add(root.data);
            if (root.left != null)
                root = root.left;
            else
                root = root.right;
        }
    }

    static void addLeaves(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }

    static void addRighBound(Node root, ArrayList<Integer> ans) {
        root = root.right;
        Stack<Integer> stk = new Stack<Integer>();
        while (root != null) {
            if (!isLeaf(root))
                stk.push(root.data);
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }
        while (!stk.isEmpty()) {
            ans.add(stk.peek());
            stk.pop();
        }
    }

    ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        if (!isLeaf(root))
            ans.add(root.data);
        addLeftBound(root, ans);
        addLeaves(root, ans);
        addRighBound(root, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
