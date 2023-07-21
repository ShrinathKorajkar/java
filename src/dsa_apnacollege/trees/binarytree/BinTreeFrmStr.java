package dsa_apnacollege.trees.binarytree;

/* 
    Q: Construct Binary Tree from String with Bracket representation
    input: "4(2(3)(1))(6(5))"
    output: 4 2 3 1 6 5 -> level order
    O(N)
*/
public class BinTreeFrmStr {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int start = 0;

    static Node constructTree(String s) {
        if (s.length() == 0 || s == null)
            return null;
        if (start >= s.length())
            return null;
        int num = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }
        Node node = new Node(num);
        if (start >= s.length())
            return node;
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.left = constructTree(s);
        }
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = constructTree(s);
        }
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        return node;
    }

    static void printTree(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        Node root = constructTree(s);
        printTree(root);
    }
}
