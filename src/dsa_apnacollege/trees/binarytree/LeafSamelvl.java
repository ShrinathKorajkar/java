package dsa_apnacollege.trees.binarytree;

/* 
    Q: Check if leaves are at same level
    O(N)
*/
public class LeafSamelvl {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    class Leaf {
        int level = 0;
    }

    static boolean checkUtil(Node node, int level, Leaf leaflvl) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) { // if node is leaf
            if (leaflvl.level == 0) {
                leaflvl.level = level;
                return true;
            }
            return (level == leaflvl.level);
        }
        return checkUtil(node.left, level + 1, leaflvl) && checkUtil(node.right, level + 1, leaflvl);
    }

    public static void main(String[] args) {
    }

}
