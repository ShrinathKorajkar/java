package dsa_apnacollege.greedy;

import java.util.Arrays;
import java.util.Comparator;

/* 
    Fractional Knapsack
    Q: Fiven value, wieght of N items, put it in capacity W to get max value in knapsack.
    input: arr[] = {{60, 10}, {100, 20}, {120, 30}}     W = 50
    output: 240 -> {60, 100, (2/3 * 120)}
    O(N logN)
*/
public class KnapSack {

    static class ItemValue {
        int value, weight;

        ItemValue(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

    static double getMaxValue(ItemValue[] arr, int capacity) {
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                double cpr1 = (double) o1.value / (double) o1.weight;
                double cpr2 = (double) o2.value / (double) o2.weight;
                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });
        double totalValue = 0d;
        for (ItemValue i : arr) {
            int curWt = i.weight;
            int curVal = i.value;
            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                double fraction = (double) capacity / (double) curWt;
                totalValue += curVal * fraction;
                capacity = (int) (capacity - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        ItemValue[] arr = {
                new ItemValue(60, 10),
                new ItemValue(100, 20),
                new ItemValue(120, 30)
        };
        int capacity = 50;
        double maxValue = getMaxValue(arr, capacity);
        System.out.println(maxValue);
    }
}
