package answers;

public class Solution_1559 {
    int m, n;
    char[][] grid;
    boolean[][] visited;
    boolean res = false;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, -1, -1);
                }
            }
        }
        return res;
    }

    private void dfs(int x, int y, int fromX, int fromY) {
        if (res) {
            return;
        }
        if (visited[x][y]) {
            res = true;
            return;
        }
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (!isValid(nextX, nextY)) {
                continue;
            }
            if (nextX == fromX && nextY == fromY) {
                continue;
            }
            if (grid[nextX][nextY] != grid[x][y]) {
                continue;
            }
            dfs(nextX, nextY, x, y);
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
