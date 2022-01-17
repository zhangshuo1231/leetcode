package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length], pre = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int lastIdx = 0, currMax = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > currMax) {
                currMax = dp[i];
                lastIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (pre[lastIdx] != -1) {
            res.add(0, nums[lastIdx]);
            lastIdx = pre[lastIdx];
        }
        res.add(0, nums[lastIdx]);
        return res;
    }

//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        if (nums == null)
//            return res;
//        Arrays.sort(nums);
//        int len = nums.length;
//        int[] dp = new int[len];
//        int[] previousLocation = new int[len];
//        for (int i = 0; i < len; i++) {
//            previousLocation[i] = i;
//        }
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] % nums[j] == 0) {
//                    if (dp[j] + 1 > dp[i]) {
//                        dp[i] = dp[j] + 1;
//                        previousLocation[i] = j;
//                    }
//                }
//            }
//        }
//        int max = dp[0], maxIdx = 0;
//        for (int i = 0; i < len; i++) {
//            if (dp[i] > max) {
//                max = dp[i];
//                maxIdx = i;
//            }
//        }
//        while(previousLocation[maxIdx] != maxIdx) {
//            res.add(nums[maxIdx]);
//            maxIdx = previousLocation[maxIdx];
//        }
//        res.add(nums[maxIdx]);
//        Collections.reverse(res);
//        return res;
//    }
}
