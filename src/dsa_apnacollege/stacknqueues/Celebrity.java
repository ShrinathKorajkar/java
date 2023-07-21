package dsa_apnacollege.stacknqueues;

/* 
    Q: In a party of N people, Celebrity is a person who is known to everyone, but doesnt know anyone
    i.e every A knows B, B don't know any A
    input: {{0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}}
    output: Celebrity id 2
    O(N)
*/
public class Celebrity {

    static int celebrity(int mat[][], int n) {
        int i = 0, j = n - 1;
        while (i < j) {
            if (mat[j][i] == 1)
                j--;
            else
                i++;
        }
        int candidate = i;
        for (i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[i][candidate] == 0 || mat[candidate][i] == 1)
                    return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[][] Mat = {
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 }
        };
        int clebIdx = celebrity(Mat, 4);
        if (clebIdx == -1) {
            System.out.println("no celebrity");
        } else {
            System.out.println("Celebrity id : " + clebIdx);
        }
    }
}
