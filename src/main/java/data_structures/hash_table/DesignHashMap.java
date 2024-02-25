package data_structures.hash_table;

import java.util.*;

public class DesignHashMap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }

}

class MyHashMap {

    private static final int CAPACITY = 769;

    private List<Entry>[] buckets;


    // Класс для представления пары ключ-значение
    private static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public MyHashMap() {
        buckets = new LinkedList[CAPACITY];
    }

    public void put(int key, int value) {
        int hash = key % CAPACITY;

        if(buckets[hash] == null) {
            buckets[hash] = new LinkedList<>();
        }

        List<Entry> bucket = buckets[hash];

        Iterator<Entry> iter = bucket.iterator();
        while (iter.hasNext()) {
            Entry entry = iter.next();
            if(entry.key == key) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry(key, value));
    }

    public int get(int key) {
        int hash = key % CAPACITY;
        List<Entry> bucket = buckets[hash];
        if(bucket != null) {
            Entry entry = bucket.stream().filter(it -> it.key == key).findFirst().orElse(new Entry(-1, -1));
            return entry.value;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = key % CAPACITY;
        List<Entry> bucket = buckets[hash];
        if(bucket != null) {
            Iterator<Entry> iter = bucket.iterator();
            while (iter.hasNext()) {
                Entry entry = iter.next();
                if(entry.key == key) {
                    iter.remove();
                    break;
                }
            }
        }
    }
}