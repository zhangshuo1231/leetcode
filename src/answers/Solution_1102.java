package answers;

import java.util.PriorityQueue;

public class Solution_1102 {
    public int maximumMinimumPath(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int min = Math.min(grid[r - 1][c - 1], grid[0][0]);
        PriorityQueue<int[]> queue = new PriorityQueue((a, b) -> (grid[((int[])b)[0]][((int[])b)[1]] - grid[((int[])a)[0]][((int[])a)[1]]));
        boolean[][] visited = new boolean[r][c];
        int i = 0, j = 0;
        while (i != r - 1 || j != c - 1) {
            visited[i][j] = true;
            int cur = grid[i][j];
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true;
                queue.offer(new int[]{i - 1, j});
            }
            if (i + 1 < r && !visited[i + 1][j]) {
                if (reach(i + 1, j, r, c)) {
                    return min;
                }
                visited[i + 1][j] = true;
                queue.offer(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                visited[i][j - 1] = true;
                queue.offer(new int[]{i, j - 1});
            }
            if (j + 1 < c && !visited[i][j + 1]) {
                if (reach(i, j + 1, r, c)) {
                    return min;
                }
                visited[i][j + 1] = true;
                queue.offer(new int[]{i, j + 1});
            }

            int[] next = queue.poll();
            min = Math.min(min, grid[next[0]][next[1]]);
            i = next[0];
            j = next[1];
        }
        return min;
    }

    private boolean reach(int i, int j, int r, int c) {
        if (i == r - 1 && j == c - 1) {
            return true;
        }
        return false;
    }
}
