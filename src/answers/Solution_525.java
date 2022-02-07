package answers;

import java.util.HashMap;
import java.util.Map;

public class Solution_525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] == 0 ? -1 : 1;
        }

        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < n + 1; i++) {
            if (map.containsKey(preSum[i])) {
                max = Math.max(max, i - map.get(preSum[i]));
            }
            else {
                map.put(preSum[i], i);
            }
        }
        return max == -1 ? 0 : max;
    }
}
