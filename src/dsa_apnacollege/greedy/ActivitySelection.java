package dsa_apnacollege.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* 
    Q: Given n activities with start and end time. Select the maximum no of activities that can be performed
    input: start = [1, 3, 0, 5, 8, 5]       end = [2, 4, 6, 7, 9, 9]
    output: 0, 1, 3, 4 -> activity no
    O(N logN)

    Q2: Given n pairs of nums. Every pair has 1 no < 2 no. a pair(c, d) can follow pair(a, b) if b < c
        Find the longest chain
    input: {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90}}
    output: 3 -> {5, 27, 50}
*/
public class ActivitySelection {

    static class Pair {
        int start;
        int finish;

        Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    static void selectActivity(int[] st, int[] fin) {
        ArrayList<Pair> ans = new ArrayList<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> p1.start - p2.start);
        // (Collections.reverseOrder((p1, p2) -> p1.start - p2.start));
        for (int i = 0; i < st.length; i++) {
            q.add(new Pair(fin[i], st[i]));
        }
        Pair it = q.poll();
        int strt = it.finish;
        int end = it.start;
        ans.add(new Pair(strt, end));
        while (!q.isEmpty()) {
            Pair itr = q.poll();
            if (itr.finish >= end) {
                strt = itr.finish;
                end = itr.start;
                ans.add(new Pair(strt, end));
            }
        }
        System.out.println("activities Selected : ");
        for (Pair itr : ans) {
            System.out.println("start : " + itr.start + " end : " + itr.finish);
        }
    }

    // Q2
    static class C implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }

    }

    static int maxChainLen(int p[][], int n) {
        Arrays.sort(p, new C());
        int prev = Integer.MIN_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (p[i][0] > prev) {
                ans++;
                prev = p[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };

        selectActivity(s, f);

        int n = 5;
        int[][] p = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
        System.out.println(maxChainLen(p, n));
    }
}
