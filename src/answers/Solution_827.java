package answers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_827 {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islands = new HashMap<>();
        int rows = grid.length, cols = grid[0].length;
        int max = 0, index = 3; // islands start with 3
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    islands.put(index, area);
                    max = Math.max(max, area);
                    index++;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, aggregate(grid, i, j, islands));
                }
            }
        }
        return max;
    }

    private int aggregate(int[][] grid, int x, int y, Map<Integer, Integer> islands) {
        Set<Integer> seen = new HashSet<>();
        int area = 1;
        if (isValid(grid, x + 1, y) && grid[x + 1][y] != 0 && !seen.contains(grid[x + 1][y])) {
            area += islands.get(grid[x + 1][y]);
            seen.add(grid[x + 1][y]);
        }
        if (isValid(grid, x - 1, y) && grid[x - 1][y] != 0 && !seen.contains(grid[x - 1][y])) {
            area += islands.get(grid[x - 1][y]);
            seen.add(grid[x - 1][y]);
        }
        if (isValid(grid, x, y + 1) && grid[x][y + 1] != 0 && !seen.contains(grid[x][y + 1])) {
            area += islands.get(grid[x][y + 1]);
            seen.add(grid[x][y + 1]);
        }
        if (isValid(grid, x, y - 1) && grid[x][y - 1] != 0 && !seen.contains(grid[x][y - 1])) {
            area += islands.get(grid[x][y - 1]);
            seen.add(grid[x][y - 1]);
        }
        return area;
    }

    private int dfs(int[][] grid, int x, int y, int index) {
        if (!isValid(grid, x, y) || grid[x][y] != 1) {
            return 0;
        }
        else {
            grid[x][y] = index;
            return 1 +
                    dfs(grid, x + 1, y, index) +
                    dfs(grid, x - 1, y, index) +
                    dfs(grid, x, y + 1, index) +
                    dfs(grid, x, y - 1, index);
        }
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
