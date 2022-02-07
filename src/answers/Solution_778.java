package answers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_778 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] grid;
    boolean[][] realtime;
    boolean[][] visited;
    int n;
    int[] des;

    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        this.realtime = new boolean[n][n];
        this.visited = new boolean[n][n];
        this.grid = grid;
        this.des = new int[]{n - 1, n - 1};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = Math.max(grid[0][0], grid[n - 1][n - 1]); i <= n * n; i++) {
            refreshMap(i);
            queue.clear();
            queue.offer(new int[]{0, 0});
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                if (Arrays.equals(curr, des)) {
                    return i;
                }
                for (int[] dir : dirs) {
                    int[] next = new int[]{curr[0] + dir[0], curr[1] + dir[1]};
                    if (isValid(next[0], next[1]) && realtime[next[0]][next[1]] && !visited[next[0]][next[1]]) {
                        queue.offer(new int[]{next[0], next[1]});
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
        }
        return -1;
    }

    private void refreshMap(int waterLevel) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                realtime[i][j] = waterLevel >= grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
