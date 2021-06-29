package com.company;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class LRUCache {
    private Map<Integer, Integer> map = new HashMap<>();
    private Set<Integer> visit = new LinkedHashSet<>();
    private int capacity = 0;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer ret = map.get(key);
        if (ret == null)
            ret = -1;
        else {
            updateVisit(key);
        }
        System.out.println("After Get: " + map);
        return ret;
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key))
            removeFirst();
        map.put(key, value);
        updateVisit(key);
        System.out.println("After Put: " + map);
    }

    private void updateVisit(int key) {
        if (visit.contains(key)) {
            visit.remove(key);
        }
        visit.add(key);
    }

    private void removeFirst() {
        Integer toBeRemoved = this.visit.stream().findFirst().get();
        visit.remove(toBeRemoved);
        map.remove(toBeRemoved);
    }
}
