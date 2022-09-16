package dsalgo.dsques;

import java.util.PriorityQueue;

/* 
    Q: Connect N ropes with minimum cost (given rope cost)
    input : [2, 5, 4, 8, 6, 9]
    output : 85
    O(n)
*/
public class PriQueue2 {

    private static int minCost(int a[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
        }
        int ans = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[] = { 2, 5, 4, 8, 6, 9 };
        System.out.println(minCost(arr));
    }
}
