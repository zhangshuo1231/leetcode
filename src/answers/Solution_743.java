package answers;

import java.util.*;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[][] timeArray = new int[n + 1][n + 1];
        for (int[] conn : times) {
            Set<Integer> set = map.getOrDefault(conn[0], new HashSet<>());
            set.add(conn[1]);
            map.put(conn[0], set);
            timeArray[conn[0]][conn[1]] = conn[2];
        }
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
        queue.offer(new int[]{k, 0});
        int res = 0;
        while (visited.size() < n && !queue.isEmpty()) {
            int[] next = queue.poll();
            int node = next[0];
            int timeStamp = next[1];
            if (!visited.containsKey(node)) {
                visited.put(node, timeStamp);
                res = Math.max(res, timeStamp);
                if (map.containsKey(node)) {
                    for (int nextNode : map.get(node)) {
                        int nextTime = timeStamp + timeArray[node][nextNode];
                        queue.offer(new int[]{nextNode, nextTime});
                    }
                }
            }
        }
        if (visited.size() == n) {
            return res;
        }
        else {
            return -1;
        }
    }
}
