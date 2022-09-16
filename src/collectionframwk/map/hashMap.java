package collectionframwk.map;

import java.util.HashMap;
import java.util.Map;

/* 
    extra : put, get, putAll, containsKey, containsValue, keySet, values, entrySet -> getKey, getValue
*/

public class hashMap {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        // add element
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        map.putIfAbsent("four", 4);
        System.out.println(map);

        // search for element
        System.out.println(map.containsKey("four"));
        System.out.println(map.isEmpty());

        // replace , getordefalut

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        for (Integer value : map.values()) {
            System.out.println(value);
        }
    }
}
