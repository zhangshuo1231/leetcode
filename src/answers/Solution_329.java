package answers;

public class Solution_329 {
    int max = 1;
    public int longestIncreasingPath(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                backtrack(0, new int[]{i, j}, matrix);
            }
        }
        return max;
    }

    private void backtrack(int currNumSteps, int[] currLocation, int[][] matrix) {
        if (currLocation == null) {
            max = Math.max(max, currNumSteps);
            return;
        }
        for (int direction = 0; direction <= 3; direction++) {
            currNumSteps++;
            backtrack(currNumSteps, nextCell(matrix, currLocation, direction), matrix);
            currNumSteps--;
        }
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
