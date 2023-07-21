package dsa_apnacollege.trees.binarytree;

/* 
    Q: Given roots of two trees, return true if one tree is subtree of another
    O(N)
*/
public class TreeWSubTree {

    static class Tree {
        int data;
        Tree left, right;

        Tree(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static boolean isSame(Tree tree, Tree subtree) {
        if (tree == null && subtree == null)
            return true;
        if (tree == null || subtree == null)
            return false;
        if (tree.data != subtree.data)
            return false;
        return isSame(tree.left, subtree.left) && isSame(tree.right, subtree.right);
    }

    static boolean isSubTree(Tree tree, Tree subtree) {
        if (tree == null)
            return false;
        if (isSame(tree, subtree))
            return true;
        return isSubTree(tree.left, subtree) || isSubTree(tree.right, subtree);
    }

    public static void main(String[] args) {

    }
}
