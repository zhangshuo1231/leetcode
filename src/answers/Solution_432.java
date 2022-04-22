package answers;

import java.util.*;

public class Solution_432 {
    private Map<String, Integer> wc = new HashMap<>();
    private TreeMap<Integer, List<String>> cw = new TreeMap<>();

    public Solution_432() {

    }

    public void inc(String key) {
        this.wc.put(key, this.wc.getOrDefault(key, 0) + 1);
        int freq = wc.get(key);
        if (cw.containsKey(freq - 1)) {
            List<String> list = cw.get(freq - 1);
            list.remove(key);
            cw.put(freq - 1, list);
            if (list.isEmpty()) {
                cw.remove(freq - 1);
            }
        }
        List<String> list = cw.getOrDefault(freq, new ArrayList<>());
        list.add(key);
        cw.put(freq, list);
    }

    public void dec(String key) {
        int freq = wc.get(key);
        this.wc.put(key, this.wc.get(key) - 1);
        this.wc.remove(key, 0);
        List<String> list = cw.get(freq);
        list.remove(key);
        if (list.isEmpty()) {
            cw.remove(freq);
        }
        if (freq > 1) {
            list = cw.getOrDefault(freq - 1, new ArrayList<>());
            list.add(key);
            this.cw.put(freq - 1, list);
        }
    }

    public String getMaxKey() {
        if (wc.isEmpty()) {
            return "";
        }
        return this.cw.lastEntry().getValue().get(0);
    }

    public String getMinKey() {
        if (wc.isEmpty()) {
            return "";
        }
        return this.cw.firstEntry().getValue().get(0);
    }
}
