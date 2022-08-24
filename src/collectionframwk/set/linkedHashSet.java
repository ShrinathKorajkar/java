package collectionframwk.set;

import java.util.LinkedHashSet;
import java.util.Set;

/*
    LinkedHashSet -> Unique elements , Ordered
    remove() -> value
*/

public class linkedHashSet {
    public static void main(String[] args) {

        Set<Integer> mySet = new LinkedHashSet<Integer>();

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
