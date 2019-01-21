package algorithm.java;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 * Created by huaxiufeng on 18/10/3.
 */
public class LC146LRUCache {
    private int capacity;
    private Map<Integer, Integer> data = new LinkedHashMap<>();

    public LC146LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = data.get(key);
        if (result != null) {
            data.remove(key);
            data.put(key, result);
        }
        return result != null ? result : -1;
    }

    public void put(int key, int value) {
        data.remove(key);
        if (data.size() >= capacity) {
            data.remove(data.keySet().iterator().next());
        }
        data.put(key, value);
    }

    public static void main(String[] args) {
        LC146LRUCache cache = new LC146LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
