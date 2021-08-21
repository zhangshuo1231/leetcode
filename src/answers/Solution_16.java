package answers;

import java.util.Arrays;

public class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[2];
        if (nums.length == 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while(start < end) {
                int curr = nums[i] + nums[start] + nums[end];
                int diff = curr - target;
                if (Math.abs(diff) < Math.abs(res - target))
                    res = curr;
                if (diff > 0)
                    end--;
                else if (diff < 0)
                    start++;
                else
                    return target;
            }
        }
        return res;
    }
}
