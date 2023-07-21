package dsa_apnacollege.hashing;

/*
    CUCKOO HASHING - O(1) LOOKUP

    In hashtable - lookup, insert, delete - cuckoo hashing gurantees O(1) lookup
    Birthday paradox - In 23 people, prob of 2 people having same birthdate is 50%
    Collisions - open addressing, closed addressing(chaining)
    Cuckoo Hashing - multiple choise hashing(multiple hash func), relocation hashing(move after placed)
        Cuckoo bird pushes other eggs after it hatches
    O(N)
*/
public class CukooHashing {

    static int SIZE = 11;
    static int ver = 2;
    static int[][] hashTable = new int[ver][SIZE];
    static int[] pos = new int[ver];

    static void initTable() {
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < ver; i++) {
                hashTable[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    static int hash(int function, int key) {
        switch (function) {
            case 1:
                return key % SIZE;
            case 2:
                return (key / SIZE) % SIZE;
        }
        return Integer.MIN_VALUE;
    }

    static void place(int key, int tableID, int cnt, int n) {
        if (cnt == n) {
            System.out.println(key + " unpositioned");
            System.out.println("Cycle present. REHASH");
            return;
        }
        for (int i = 0; i < ver; i++) {
            pos[i] = hash(i + 1, key);
            if (hashTable[i][pos[i]] == key)
                return;
        }
        if (hashTable[tableID][pos[tableID]] == Integer.MIN_VALUE) {
            hashTable[tableID][pos[tableID]] = key;
        } else {
            int dis = hashTable[tableID][pos[tableID]];
            hashTable[tableID][pos[tableID]] = key;
            place(dis, (tableID + 1) % ver, cnt + 1, n);
        }
    }

    static void cuckoo(int keys[], int n) {
        initTable();
        for (int i = 0, cnt = 0; i < n; i++, cnt = 0)
            place(keys[i], 0, cnt, n);
        printTable();
    }

    static void printTable() {
        System.out.println("\n**********HASHTABLE*********");
        for (int i = 0; i < ver; i++, System.out.println()) {
            for (int j = 0; j < SIZE; j++) {
                if (hashTable[i][j] == Integer.MIN_VALUE)
                    System.out.print("  -  ");
                else
                    System.out.printf(" %3d ", hashTable[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int keys1[] = { 20, 50, 53, 75, 100, 67, 105, 3, 36, 39 };
        cuckoo(keys1, keys1.length);
    }
}
