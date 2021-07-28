package answers;

import java.util.Arrays;

public class Solution_376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 2) {
            if (nums.length == 2 && nums[0] != nums[1])
                return 2;
            return 1;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1; dp[0][1] = 1; // +, -
        int totalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxUp = 1;
            int maxDown = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxUp = Math.max(maxUp, dp[j][1] + 1);
                }
                if (nums[i] < nums[j]) {
                    maxDown = Math.max(maxDown, dp[j][0] + 1);
                }
            }
            dp[i][0] = maxUp;
            dp[i][1] = maxDown;
            totalMax = Math.max(totalMax, Math.max(maxUp, maxDown));
        }
        return totalMax;
    }
}
