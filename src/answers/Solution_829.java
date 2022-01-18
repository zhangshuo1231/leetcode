package answers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_829 {
    public int consecutiveNumbersSum(int n) {
        int cnt = 0;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + i;
        }
        // System.out.println(Arrays.toString(prefixSum));
        Set<Long> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            if (set.contains(prefixSum[i] - n)) {
                // System.out.println(prefixSum[i] - n + " => " + prefixSum[i]);
                cnt++;
            }
            set.add(prefixSum[i]);
        }
        return cnt;
    }
}
