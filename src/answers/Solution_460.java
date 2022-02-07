package answers;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Solution_460 {
    private final int capacity;
    private int minUseCount;
    private final Map<Integer, Integer> cache;
    private final Map<Integer, Integer> count = new HashMap<>();
    private final Map<Integer, LinkedHashSet<Integer>> order;

    public Solution_460(int capacity) {
        this.capacity = capacity;
        this.minUseCount = 0;
        this.cache = new HashMap<>();
        this.order = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            adjustCount(key);
            return cache.get(key);
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            adjustCount(key);
            cache.put(key, value);
        }
        else {
            if (cache.size() >= capacity) {
                evict();
            }
            minUseCount = 1;
            cache.put(key, value);
            count.put(key, 1);
            LinkedHashSet<Integer> targetSet = order.getOrDefault(1, new LinkedHashSet<>());
            targetSet.add(key);
            order.put(1, targetSet);
        }
    }

    private void adjustCount(int key) {
        int currUseCount = count.get(key);
        count.put(key, currUseCount + 1);
        order.get(currUseCount).remove(key);
        if (currUseCount == minUseCount && order.get(currUseCount).isEmpty()) {
            minUseCount++;
        }
        LinkedHashSet<Integer> targetSet = order.getOrDefault(currUseCount + 1, new LinkedHashSet<>());
        targetSet.add(key);
        order.put(currUseCount + 1, targetSet);
    }

    private void evict() {
        int tobeEvicted = order.get(minUseCount).iterator().next();
        order.get(minUseCount).remove(tobeEvicted);
        count.remove(tobeEvicted);
        cache.remove(tobeEvicted);
    }
}