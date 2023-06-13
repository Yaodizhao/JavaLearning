package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s146LRU缓存 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }
}

class LRUCache {
    HashMap<Integer, Integer> map;
    int capacity;
    List<Integer> list = new ArrayList<>();

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (key == (list.get(i))) {
                list.remove(i);
                break;
            }
        }

        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            for (int i = 0; i < list.size(); i++) {
                if (key == (list.get(i))) {
                    list.remove(i);
                    break;
                }
            }
            list.add(0, key);
            map.replace(key, map.get(key), value);
            return;
        }
        if (map.size() == this.capacity) {
            map.remove(list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        list.add(0, key);
        map.put(key, value);
    }
}