package collectionframwk.set;

import java.util.HashSet;
import java.util.Set;

/*
    HashSet -> Unordered, Sorted , Unique
    all operations -> O(1)
*/

public class hashSet {
    public static void main(String[] args) {

        Set<Integer> mySet = new HashSet<Integer>();

        // add elements
        mySet.add(3);
        mySet.add(2);
        mySet.add(1);
        mySet.add(4);
        mySet.add(4);
        System.out.println(mySet);

        // remove elements
        mySet.remove(1);
        System.out.println(mySet);

        // search for elements
        System.out.println(mySet.contains(3));

        // empty
        System.out.println(mySet.isEmpty());
    }

}
