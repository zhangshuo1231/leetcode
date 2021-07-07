package answers;

import java.util.*;

public class Solution_329 {
    Integer max = 1;
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
        if (cache[i][j] != 0) return cache[i][j];
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
        int maxRowIndex = matrix.length - 1;
        int maxColIndex = matrix[0].length - 1;
        int currValue = matrix[curr[0]][curr[1]];
        switch (direction) {
            case 0:
                if (curr[1] == 0) {
                    return null;
                } else {
                    if (matrix[curr[0]][curr[1] - 1] > currValue) {
                        return new int[]{curr[0], curr[1] - 1};
                    } else {
                        return null;
                    }
                }
            case 1:
                if (curr[0] == 0) {
                    return null;
                } else {
                    if (matrix[curr[0] - 1][curr[1]] > currValue) {
                        return new int[]{curr[0] - 1, curr[1]};
                    } else {
                        return null;
                    }
                }
            case 2:
                if (curr[1] == maxColIndex) {
                    return null;
                } else {
                    if (matrix[curr[0]][curr[1] + 1] > currValue) {
                        return new int[]{curr[0], curr[1] + 1};
                    } else {
                        return null;
                    }
                }
            case 3:
                if (curr[0] == maxRowIndex) {
                    return null;
                } else {
                    if (matrix[curr[0] + 1][curr[1]] > currValue) {
                        return new int[]{curr[0] + 1, curr[1]};
                    } else {
                        return null;
                    }
                }
            default:
                throw new RuntimeException();
        }
    }
}
