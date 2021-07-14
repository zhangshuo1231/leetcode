package answers;

import java.util.*;

public class Solution_354 {
    class envComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            else {
                return o1[1] - o2[1];
            }
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1)
            return 1;
        Arrays.sort(envelopes, new envComparator());
        int res = 1;
        int[] dp = new int[envelopes.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(envelopes[i], envelopes[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }

    private boolean compare(int[] a, int[] b) {
        return a[0] - b[0] > 0 && a[1] - b[1] > 0;
    }
}
