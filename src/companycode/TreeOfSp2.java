package companycode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/* 
    lock :    1. if it is already locked, then return false
              2. if its descendents is locked return false
              3. if any ancestor is locked return false
    unlock:   1. if it is not locked, then return false
              2. if it is locked by some diff id return false
              3. otherwise unlock and return true
    upgrade:  1. if locked return false
              2. if no locked descendents return false
              3. if locked descendents with other id or only some desc locked return false
              4. unlock every locked descendents and lock this node
    lock, unlock -> O(logN)

    m array tree -> parent of j = (j - 1) / m
                 -> j th child of i = m * i + j 
*/
public class TreeOfSp2 {
    static int n, m, q;
    static HashMap<String, Integer> indexMap = new HashMap<>();
    static LinkedList<String> nodes = new LinkedList<>();
    static HashMap<String, Integer> isLocked = new HashMap<>();
    static HashMap<String, HashSet<String>> lockedChildList = new HashMap<>();

    static int getParent(int i) {
        if (i == 0)
            return -1;
        return (i - 1) / m;
    }

    static boolean lock(String name, int id) {
        if (isLocked.containsKey(name))
            return false;
        if (!lockedChildList.get(name).isEmpty())
            return false;
        int i = indexMap.get(name);
        while (i != -1) {
            if (isLocked.containsKey(nodes.get(i)))
                return false;
            i = getParent(i);
        }
        i = getParent(indexMap.get(name));
        while (i != -1) {
            lockedChildList.get(nodes.get(i)).add(name);
            i = getParent(i);
        }
        isLocked.put(name, id);
        return true;
    }

    static boolean unlock(String name, int id) {
        if (!isLocked.containsKey(name))
            return false;
        int lockedById = isLocked.get(name);
        if (lockedById != id)
            return false;
        isLocked.remove(name);
        int i = getParent(indexMap.get(name));
        while (i != -1) {
            lockedChildList.get(nodes.get(i)).remove(name);
            i = getParent(i);
        }
        return true;
    }

    static boolean upgrade(String name, int id) {
        if (isLocked.containsKey(name))
            return false;
        HashSet<Integer> childId = new HashSet<>();
        for (String str : lockedChildList.get(name)) {
            childId.add(isLocked.get(str));
        }
        if (childId.size() != 1) {
            return false;
        }
        HashSet<String> temp = new HashSet<>(lockedChildList.get(name));
        for (String str : temp) {
            unlock(str, id);
        }
        unlock(name, id);
        return lock(name, id);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nodes.add(sc.next());
            indexMap.put(nodes.get(i), i);
            lockedChildList.put(nodes.get(i), new HashSet<String>());
        }
        while (q-- > 0) {
            int opType = sc.nextInt();
            String nodeName = sc.next();
            int userID = sc.nextInt();
            if (opType == 1) {
                System.out.println(lock(nodeName, userID));
            } else if (opType == 2) {
                System.out.println(unlock(nodeName, userID));
            } else {
                System.out.println(upgrade(nodeName, userID));
            }
        }
        sc.close();
    }
}
