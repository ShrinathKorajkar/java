package collectionframwk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class collectionsClass {
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<Integer>();

        myList.add(1);
        myList.add(4);
        myList.add(2);
        myList.add(3);

        System.out.println(myList);

        // collectionsClass
        System.out.println("min element " + Collections.min(myList));
        System.out.println("max element " + Collections.max(myList));
        System.out.println(Collections.frequency(myList, 1));

        Collections.sort(myList, Comparator.reverseOrder());
        System.out.println(myList);

    }

}
