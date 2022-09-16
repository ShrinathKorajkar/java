package dsalgo.trees;

import java.util.Set;

/* 
    1. Find ceil and floor Node
    2. Find Pair with given target
*/
public class Bst3 {

    void floorCeil(Node root, int key) {
        int floor = Integer.MAX_VALUE;
        int ceil = Integer.MIN_VALUE;
        while (root != null) {
            if (root.data == key) {
                System.out.println(root.data);
                return;
            }
            if (root.data > key) {
                ceil = root.data;
                root = root.left;
            } else {
                floor = root.data;
                root = root.right;
            }
        }
        System.out.println(floor);
        System.out.println(ceil);
    }

    // target
    boolean isPair(Node root, int sum, Set<Integer> set) {

        if (root == null)
            return false;
        if (isPair(root.left, sum, set))
            return true;
        if (set.contains(sum - root.data))
            return true;
        set.add(root.data);
        return isPair(root.right, sum, set);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}