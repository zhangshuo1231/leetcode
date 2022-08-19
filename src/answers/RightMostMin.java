package answers;

import java.util.Arrays;

public class RightMostMin {
    public int[] rightMostMin(int[] nums) {
        int n = nums.length;
        int[] postMin = new int[n];
        postMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postMin[i] = Math.min(nums[i], postMin[i + 1]);
        }

        int[] res = new int[n];
        res[n - 1] = -1;
        for (int i = 0; i < n - 1; i++) {
            if (postMin[i + 1] >= nums[i]) {
                res[i] = -1;
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (postMin[m] < nums[i]) {
                    l = m;
                }
                else {
                    r = m - 1;
                }
            }
            res[i] = l;
        }
        return res;
    }
}
