package answers;

public class Solution_276 {
    public int numWays(int n, int k) {
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = k;
        if (n == 1) {
            return res[1];
        }
        res[2] = k * k;
        if (n == 2) {
            return res[2];
        }

        for (int i = 3; i <= n; i++) {
            res[i] = (k - 1) * res[i - 1] + (k - 1) * res[i - 2];
        }

        return res[n];
    }
}
