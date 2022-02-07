package answers;

import java.util.*;

public class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            TreeSet<Integer> set = map.getOrDefault(c, new TreeSet<>());
            set.add(i);
            map.put(c, set);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        for (TreeSet<Integer> set : map.values()) {
            queue.offer(new int[]{set.first(), set.last()});
        }

        List<Integer> res = new ArrayList<>();
        int[] curr = queue.poll();
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            }
            else {
                res.add(curr[1] - curr[0] + 1);
                curr = interval;
            }
        }
        res.add(curr[1] - curr[0] + 1);
        return res;
    }
}
