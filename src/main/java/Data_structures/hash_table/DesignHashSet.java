package Data_structures.hash_table;

import java.util.*;

/**
 * Название: Design HashSet
 */

public class DesignHashSet {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}

class MyHashSet {

    private static final int CAPACITY = 769;

    private List<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[CAPACITY];
    }

    public void add(int key) {
        int hash = key % CAPACITY;

        if (buckets[hash] == null) {
            buckets[hash] = new LinkedList<>();
        }

        List<Integer> list = buckets[hash];
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        int hash = key % CAPACITY;
        List<Integer> bucket = buckets[hash];
        if(bucket != null) {
            bucket.removeIf(it -> it.equals(key));
        }
    }


    public boolean contains(int key) {
        int hash = key % CAPACITY;
        List<Integer> list = buckets[hash];
        if (list != null) {
            return list.contains(key);
        }
        return false;
    }

}
