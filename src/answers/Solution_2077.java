package answers;

import java.util.*;

public class Solution_2077 {
    public int numberOfPaths(int n, int[][] corridors) {
        Set<String> set = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] path : corridors) {
            Set<Integer> curr = map.getOrDefault(path[0], new HashSet<>());
            curr.add(path[1]);
            map.put(path[0], curr);

            curr = map.getOrDefault(path[1], new HashSet<>());
            curr.add(path[0]);
            map.put(path[1], curr);
        }

        for (int i = 1; i <= n; i++) {
            int start = i;
            int step = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            LinkedList<Integer> prevs = new LinkedList<>();
            queue.offer(i);
            prevs.offer(-1);
            while (!queue.isEmpty()) {
                step++;
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int curr = queue.poll();
                    int prev = prevs.poll();
                    if (map.get(curr) != null) {
                        for (int next : map.get(curr)) {
                            if (next == prev) continue;
                            if (step == 3) {
                                if (next == start) {
                                    int[] rec = new int[3];
                                    rec[0] = start;
                                    rec[1] = prev;
                                    rec[2] = curr;
                                    Arrays.sort(rec);
                                    set.add(rec[0] + "-" + rec[1] + "-" + rec[2]);
                                }
                            } else {
                                queue.offer(next);
                                prevs.offer(curr);
                            }
                        }
                    }
                }
            }
        }
        return set.size();
    }
}
