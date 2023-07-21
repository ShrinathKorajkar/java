package dsa_apnacollege.greedy;

/* 
    Q: Given 3 stk, find equal max sum of stacks with removal of top element
    input: stk1[] = {1, 1, 1, 2, 3}     stk2[] = {2, 3, 4}      stk3[] = {1, 4, 5, 2}
    output: stk1[] = {1, 1, 1, 2}       stk2[] = {2, 3}         stk3[] = {1, 4}
            sum = 5
    O(n1 + n2 + n3)
*/
public class MaxEqSum3Stk {

    static int maxSum(int stk1[], int stk2[], int stk3[], int n1, int n2, int n3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < n1; i++) {
            sum1 += stk1[i];
        }
        for (int i = 0; i < n2; i++) {
            sum2 += stk2[i];
        }
        for (int i = 0; i < n3; i++) {
            sum3 += stk3[i];
        }
        int top1 = 0, top2 = 0, top3 = 0;
        while (true) {
            if (top1 == n1 || top2 == n2 || top3 == n3) {
                return 0;
            }
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= stk1[top1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= stk2[top2++];
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= stk3[top3++];
            }
        }
    }

    public static void main(String[] args) {
        int stk1[] = { 3, 2, 1, 1, 1 };
        int stk2[] = { 4, 3, 2 };
        int stk3[] = { 2, 5, 4, 1 };
        System.out.println(maxSum(stk1, stk2, stk3, stk1.length, stk2.length, stk3.length));
    }
}
