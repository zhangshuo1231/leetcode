package answers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_317 {
    private int[] rows = new int[] {0, 0, 1, -1};
    private int[] cols = new int[] {1, -1, 0, 0};

    public int shortestDistance(int[][] grid) {
        int totalOnes = 0; int[][] dist = new int[grid.length][grid[0].length], reachable = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalOnes++;
                    bfs(i, j, grid, dist, reachable);
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && reachable[i][j] == totalOnes) {
                    minDistance = Math.min(minDistance, dist[i][j]);
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private void bfs(int r, int c, int[][] grid, int[][] dist, int[][] reachable) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new int[]{r, c});
        int distance = -1;
        while (!queue.isEmpty()) {
            int currLayerSize = queue.size();
            distance++;
            for (int i = 0; i < currLayerSize; i++) {
                int[] curr = queue.poll();
                dist[curr[0]][curr[1]] += distance;
                reachable[curr[0]][curr[1]]++;
                for (int direction = 0; direction < 4; direction++) {
                    int rr = curr[0] + rows[direction];
                    int cc = curr[1] + cols[direction];
                    if (isValid(grid, rr, cc) && !visited[rr][cc]) {
                        visited[rr][cc] = true;
                        queue.add(new int[]{rr, cc});
                    }
                }
            }
        }
    }

    private boolean isValid(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        return grid[r][c] == 0;
    }
}
