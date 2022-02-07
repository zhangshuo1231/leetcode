package answers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_934 {
    private int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    private Queue<int[]> queue = new LinkedList<>();	// store visited cells with x and y in an array
    private int[][] grid;
    private int row, col;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean found = false;

        // 1. dfs to find an island, mark its cells in visited
        for (int i = 0; i < row && !found; i++) {
            for (int j = 0; j < col && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(visited, i, j);
                    found = true;
                }
            }
        }
        // 2. bfs to expand this island to reach another island
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int x = cell[0] + d[0];
                    int y = cell[1] + d[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && !visited[x][y]) {	// Not in current island
                        if (grid[x][y] == 1) {
                            return step;
                        }
                        queue.offer(new int[] { x, y });
                        visited[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y] || grid[x][y] == 0) {
            return;
        }
        visited[x][y] = true;
        queue.offer(new int[] { x, y });
        for (int[] d : dirs) {
            dfs(visited, x + d[0], y + d[1]);
        }
    }
}
