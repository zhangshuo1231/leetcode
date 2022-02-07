package answers;

import java.util.Arrays;

public class Solution_935 {
    private static final int MOD = 1000000007;

    public int knightDialer(int n) {
        int[] init = new int[10];
        Arrays.fill(init, 1);
        if (n == 1) {
            return sum(init);
        }
        int[] curr = new int[10];
        while (--n > 0) {
            curr = next(init);
            System.arraycopy(curr, 0, init, 0, 10);
        }
        return sum(curr);
    }

    private int[] next(int[] pre) {
        int[] res = new int[10];
        res[0] = (pre[4] % MOD + pre[6] % MOD) % MOD;
        res[1] = (pre[8] % MOD + pre[6] % MOD) % MOD;
        res[2] = (pre[7] % MOD + pre[9] % MOD) % MOD;
        res[3] = (pre[4] % MOD + pre[8] % MOD) % MOD;
        res[4] = ((pre[3] % MOD + pre[9] % MOD) % MOD + pre[0] % MOD) % MOD;
        res[5] = 0;
        res[6] = ((pre[1] % MOD + pre[7] % MOD) % MOD + pre[0] % MOD) % MOD;
        res[7] = (pre[2] % MOD + pre[6] % MOD) % MOD;
        res[8] = (pre[1] % MOD + pre[3] % MOD) % MOD;
        res[9] = (pre[2] % MOD + pre[4] % MOD) % MOD;
        return res;
    }

    private int sum(int[] array) {
        int res = 0;
        for (int i : array) {
            res = (res + (i % MOD)) % MOD;
        }
        return res;
    }
}
