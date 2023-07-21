package dsa_apnacollege.trees.binarytree;

import java.util.HashMap;

/*
    Q: Construct binary tree from preorder and inorder traversal
    input: pre-[3, 9, 20, 15, 7]    post-[9, 3, 15, 20, 7]
    output: [3, 9, 20, null, null, 15, 7]
    O(N)
*/
public class TreefrmInPre {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int idxRoot = map.get(root.data);
        int numsLeft = idxRoot - inStart;

        root.left = helper(pre, preStart + 1, preStart + numsLeft, in, inStart, idxRoot - 1, map);
        root.right = helper(pre, preStart + numsLeft + 1, preEnd, in, idxRoot + 1, inEnd, map);
        return root;
    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        printTree(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
        int[] in = { 3, 2, 4, 1, 6, 5, 7 };
        TreeNode tree = buildTree(pre, in);
        printTree(tree);
    }
}
