package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] next = new int[]{0, 0};
        while (next != null) {
            result.add(matrix[next[0]][next[1]]);
            matrix[next[0]][next[1]] = -200;
            next = next(next, matrix);
        }
        return result;
    }

    private int[] next(int[] curr, int[][] matrix) {
        int[] right = new int[]{curr[0], curr[1] + 1};
        int[] down = new int[]{curr[0] + 1, curr[1]};
        int[] left = new int[]{curr[0], curr[1] - 1};
        int[] up = new int[]{curr[0] - 1, curr[1]};
        int[] result = null;
        if (isValid(right, matrix) && isValid(up, matrix)) {
            result = up;
        }
        else {
            if (isValid(right, matrix)) {
                result = right;
            } else if (isValid(down, matrix)) {
                result = down;
            } else if (isValid(left, matrix)) {
                result = left;
            } else if (isValid(up, matrix)) {
                result = up;
            }
        }
        return result;
    }

    private boolean isValid(int[] pos, int[][] matrix) {
        return pos[0] >= 0 && pos[0] < matrix.length && pos[1] >=0 && pos[1] < matrix[0].length && matrix[pos[0]][pos[1]] != -200;
    }
}
