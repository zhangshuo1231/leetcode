package answers;

import java.util.*;

public class Solution_1202 {
    int[] parent;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            PriorityQueue<Character> queue = map.getOrDefault(root, new PriorityQueue<>());
            queue.add(s.charAt(i));
            map.put(root, queue);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            sb.append(map.get(root).poll());
        }

        return sb.toString();
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }

    private void union(int i, int j) {
        if (find(i) < find(j)) {
            parent[find(j)] = find(i);
        }
        else if (find(i) > find(j)) {
            parent[find(i)] = find(j);
        }
    }
}
