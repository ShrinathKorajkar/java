package dsa_apnacollege.trees.binarytree;

import java.util.HashSet;

/* 
    Q: Check if a Binary Tree contains duplicate subtree of size 2 or more
    O(N)
*/
public class DupSubTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static char marker = '$';

    static String dupSubTree(Node root, HashSet<String> subtrees) {
        String s = "";
        if (root == null)
            return s + marker;
        String lStr = dupSubTree(root.left, subtrees);
        if (lStr.equals(s))
            return s;
        String rStr = dupSubTree(root.right, subtrees);
        if (rStr.equals(s))
            return s;

        s = s + root.data + lStr + rStr;
        if (s.length() > 3 && subtrees.contains(s))
            return "";

        subtrees.add(s);
        return s;
    }

    public static void main(String[] args) {
        HashSet<String> subtrees = new HashSet<String>();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(3);
        String str = dupSubTree(root, subtrees);
        if (str.equals("")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
