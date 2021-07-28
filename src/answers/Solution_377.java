package answers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_377 {
    int[] cache;
    public int combinationSum4(int[] nums, int target) {
        cache = new int[target + 1];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (target < 0) return 0;
        if (cache[target] != -1) return cache[target];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i]);
        }
        cache[target] = res;
        return res;
    }

    public int combinationSum4_v2(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += combinationSum4_v2(nums, target - nums[i]);
        }
        return res;
    }
}
