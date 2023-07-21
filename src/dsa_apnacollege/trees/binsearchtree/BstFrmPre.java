package dsa_apnacollege.trees.binsearchtree;

/*
    Q: Construct BST from preorder traversal
    input: {10, 5, 1, 7, 40, 50}
    output: 10
          5    40
        1   7     50
    O(N)
*/
public class BstFrmPre {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class Index {
        int index = 0;
    }

    static Index index = new Index();

    static Node constructTree(int pre[], Index preIndex, int key, int min, int max, int size) {
        if (preIndex.index >= size) {
            return null;
        }

        Node root = null;
        if (key > min && key < max) {
            root = new Node(key);
            preIndex.index++;

            if (preIndex.index < size) {
                root.left = constructTree(pre, preIndex, pre[preIndex.index], min, key, size);
            }
            if (preIndex.index < size) {
                root.right = constructTree(pre, preIndex, pre[preIndex.index], key, max, size);
            }
        }
        return root;
    }

    static void printInOrder(Node node) {
        if (node == null)
            return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        int pre[] = { 10, 5, 1, 7, 40, 50 };
        Node root = constructTree(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, pre.length);
        printInOrder(root);
    }
}
