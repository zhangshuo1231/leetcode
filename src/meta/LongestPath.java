package meta;

public class LongestPath {

    private int m, n, len;
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestPathOverAll(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int max = 1;
        Integer[][] memo = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, mat, memo));
            }
        }
        return max;
    }

    private int dfs(int x, int y, int[][] mat, Integer[][] memo) {
        if (memo[x][y] != null) {
            return memo[x][y];
        }
        int curr = mat[x][y];
        int tail = 0;
        for (int i = 0; i < 4; i++) {
            int r = x + dirs[i][0];
            int c = y + dirs[i][1];
            if (isValid(r, c) && mat[r][c] == curr + 1) {
                tail = Math.max(tail, dfs(r, c, mat, memo));
            }
        }
        memo[x][y] = 1 + tail;
        return 1 + tail;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
