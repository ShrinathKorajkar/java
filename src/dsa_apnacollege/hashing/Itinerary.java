package dsa_apnacollege.hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Q: Find Itinerary from given list of tickets
    input: Chennai -> Bangalore
            Bombay -> Delhi
            Goa    -> Chennai
            Delhi  -> Goa
    output: Bombay -> Delhi -> Goa -> Chennai -> Bangalore
    O(N)
*/

public class Itinerary {

    static void printItinerary(Map<String, String> dataset) {
        Map<String, String> reverseMap = new HashMap<String, String>();
        String start = null;
        for (Map.Entry<String, String> entry : dataset.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<String, String> entry : dataset.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }
        System.out.print(start);
        String to = dataset.get(start);
        while (to != null) {
            System.out.print(" -> " + to);
            to = dataset.get(to);
        }
    }

    public static void main(String[] args) {
        Map<String, String> dataset = new HashMap<String, String>();
        dataset.put("Chennai", "Bangalore");
        dataset.put("Bombay", "Delhi");
        dataset.put("Goa", "Chennai");
        dataset.put("Delhi", "Goa");

        printItinerary(dataset);
    }
}
