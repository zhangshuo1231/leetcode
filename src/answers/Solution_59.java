package answers;

public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = true;
            }
        }
        map[0][0] = false;
        int[] curr = new int[]{0, 0};
        for (int i = 1; i <= n * n; i++) {
            result[curr[0]][curr[1]] = i;
            int[] next = next(curr, map);
            curr = next;
        }
        return result;
    }

    private int[] next(int[] curr, boolean[][] map) {
        int[] right = new int[]{curr[0], curr[1] + 1};
        int[] down = new int[]{curr[0] + 1, curr[1]};
        int[] left = new int[]{curr[0], curr[1] - 1};
        int[] up = new int[]{curr[0] - 1, curr[1]};
        int[] result = null;
        if (isValid(right, map) && isValid(up, map)) {
            result = up;
        }
        else {
            if (isValid(right, map)) {
                result = right;
            } else if (isValid(down, map)) {
                result = down;
            } else if (isValid(left, map)) {
                result = left;
            } else if (isValid(up, map)) {
                result = up;
            }
        }
        if (result != null) {
            map[result[0]][result[1]] = false;
        }
        return result;
    }

    private boolean isValid(int[] pos, boolean[][] map) {
        return pos[0] >= 0 && pos[0] < map.length && pos[1] >=0 && pos[1] < map[0].length && map[pos[0]][pos[1]];
    }
}
