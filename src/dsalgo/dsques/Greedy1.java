package dsalgo.dsques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
    MAXIMUM DISJOINT INTERVALS
    Q: find the no of maximum disjoint intervals we can get (which do not overlap)
    input: starting and ending intervals array s=[1, 3, 0, 5, 8, 5] e=[2, 4, 6, 7, 9, 9]
    output: total number of disjoint intervals o=[1, 2, 4, 5] -> index of starting interval(1-2,3-4,5-7,8-9)
    O(n)
*/
public class Greedy1 {

    static ArrayList<Integer> maxMeet(int n, int[] Start, int[] End) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = i + 1;
            a[i][1] = Start[i];
            a[i][2] = End[i];
        }
        Arrays.sort(a, Comparator.comparingInt(o -> o[2]));
        int r = a[0][2];
        ans.add(a[0][0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i][1] > r) {
                ans.add(a[i][0]);
                r = a[i][2];
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
