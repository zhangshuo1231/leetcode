package answers;

public class Solution_1937 {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] += (long) points[i][j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }

        long res = -1;
        for (int j = 0; j < n; j++) {
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}
