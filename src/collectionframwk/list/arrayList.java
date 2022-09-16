package collectionframwk.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* 
    when size reaches n , new size -> n/2 + 1
    add , set, size -> O(1)
    add(ind, val) , remove, clear -> O(n)

    extraMethods: get, set, indexOf, lastIndexOf, listIterator, sublist
*/

class arrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // List<String> list = new ArrayList<String>();
        // ArrayList<Boolean> list = new ArrayList<>();

        // add element
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(list);

        // get element
        int element = list.get(0);
        System.out.println(element);

        // add element in between
        list.add(1, 2);
        System.out.println(list);

        // set element (dont increase size)
        list.set(0, 5);
        System.out.println(list);

        // delete element using index
        list.remove(0);
        System.out.println(list);

        // delete element using value
        list.remove(Integer.valueOf(1));

        // search elements
        System.out.println(list.contains(4));

        // get size
        int size = list.size();
        System.out.println(size);

        // merge List
        List<Integer> newList = new ArrayList<Integer>();
        newList.add(6);
        newList.add(7);

        list.addAll(newList);
        System.out.println(list);

        // Iterating
        for (int i = 0; i < list.size(); i++) {
            System.out.println("element using normal for : " + list.get(i));
        }
        for (Integer x : list) {
            System.out.println("element using for each : " + x);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("using Iterator : " + it.next());
        }

        // sort
        Collections.sort(list);
        System.out.println(list);

        // Clear List
        list.clear();
        System.out.println(list);
    }
}