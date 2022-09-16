package dsalgo.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/* 
    leaf = 2 ^ h + 1;
    child = 2 * i, 2 * i + 1;
*/
public class BinTree1 {

    // HEIGHT OF TREE -> similarly size(size of left + right +1)
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // LEVEL ORDER TRAVERSEL
    static void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(root); // q.add(null) to print in new line
        while (!q.isEmpty()) {
            Node cur = q.poll(); // if null print() continue
            System.out.println(cur.data);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    // LEFT VIEW AND RIGHT VIEW
    static void leftView(Node root, ArrayList<Node> list, int level) {

        if (root == null) {
            return;
        }
        if (list.get(level) == null) {
            list.add(root); // print list for left view
        }
        leftView(root.left, list, level + 1); // interchange for right view
        leftView(root.right, list, level + 1);
    }

    // TOP AND BOTTOM -> TreeMap -> store level and data in queue and map, store in
    // map if key not present

    public static void main(String[] args) {

    }

    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}