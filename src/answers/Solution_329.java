package answers;

import java.util.*;

public class Solution_329 {
    Integer max = 1;
    private int[] rows = new int[]{0, 0, -1, 1};
    private int[] cols = new int[]{-1, 1, 0, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = maxDistance(i, j, matrix, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    // DP 最好是跟递归一起使用，而不是跟 backtracking
    private int maxDistance(int i, int j, int[][] matrix, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        for (int direction = 0; direction <= 3; direction++) {
            int[] next = nextCell(matrix, new int[]{i, j}, direction);
            if (next == null) {
                continue;
            }
            int len = 1 + maxDistance(next[0], next[1], matrix, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    private int[] nextCell(int[][] matrix, int[] curr, int direction) {
        int currVal = matrix[curr[0]][curr[1]];
        int row = curr[0] + rows[direction];
        int col = curr[1] + cols[direction];
        return isValid(matrix, row, col, currVal) ? new int[]{row, col} : null;

    }

    private boolean isValid(int[][] matrix, int row, int col, int currVal) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length && matrix[row][col] > currVal;
    }
}
