package answers;

import java.util.HashSet;
import java.util.Set;

public class Solution_548 {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7) return false;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 3; i < n - 3; i++) {
            set.clear();
            for (int j = 1; j < i - 1; j++) {
                if (segSum(0, j - 1, preSum) == segSum(j + 1, i - 1, preSum)) {
                    set.add(segSum(0, j - 1, preSum));
                }
            }
            for (int j = i + 2; j < n - 1; j++) {
                if (segSum(i + 1, j - 1, preSum) == segSum(j + 1, n - 1, preSum)) {
                    if (set.contains(segSum(i + 1, j - 1, preSum))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int segSum(int i , int j, int[] preSum) {
        return preSum[j + 1] - preSum[i];
    }
}
