package answers;

import java.util.*;

public class Solution_1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] res = new int[2][n]; // 0: red, 1: blue
        for (int i = 0; i < 2; i++) {
            Arrays.fill(res[i], -1);
        }
        res[0][0] = 0;
        res[1][0] = 0;
        Map<Integer, Set<Integer>> red = new HashMap<>();
        Map<Integer, Set<Integer>> blue = new HashMap<>();

        for (int[] r : redEdges) {
            Set<Integer> set = red.getOrDefault(r[0], new HashSet<>());
            set.add(r[1]);
            red.put(r[0], set);
        }

        for (int[] b : blueEdges) {
            Set<Integer> set = blue.getOrDefault(b[0], new HashSet<>());
            set.add(b[1]);
            blue.put(b[0], set);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int steps = 0;
        bfs(res, red, blue, queue, true, steps);

        queue.clear();
        queue.offer(0);
        steps = 0;
        bfs(res, red, blue, queue, false, steps);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (res[0][i] == -1 && res[1][i] == -1) {
                ans[i] = -1;
            }
            else if (res[0][i] == -1) {
                ans[i] = res[1][i];
            }
            else if (res[1][i] == -1){
                ans[i] = res[0][i];
            }
            else {
                ans[i] = Math.min(res[0][i], res[1][i]);
            }
        }
        return ans;
    }

    private void bfs(int[][] res, Map<Integer, Set<Integer>> red, Map<Integer, Set<Integer>> blue, LinkedList<Integer> queue, boolean nowBlue, int steps) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (nowBlue) {
                    iterate(res, blue, queue, steps, curr, 1);
                }
                else {
                    iterate(res, red, queue, steps, curr, 0);
                }
            }
            steps++;
            nowBlue = !nowBlue;
        }
    }

    private void iterate(int[][] res, Map<Integer, Set<Integer>> blue, LinkedList<Integer> queue, int steps, int curr, int color) {
        if (blue.get(curr) != null) {
            for (int next : blue.get(curr)) {
                if (res[color][next] == -1 || steps + 1 < res[color][next]) {
                    queue.offer(next);
                    res[color][next] = steps + 1;
                }
            }
        }
    }
}
