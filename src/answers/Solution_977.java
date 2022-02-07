package answers;

public class Solution_977 {
    public int[] sortedSquares(int[] nums) {
        int start = 0, end;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(nums[start])) {
                start = i;
            }
        }
        int[] res = new int[nums.length];
        end = start + 1;

        int idx = 0;
        while (start >= 0 && end < nums.length) {
            if (nums[start] * nums[start] <= nums[end] * nums[end]) {
                res[idx] = nums[start] * nums[start];
                idx++;
                start--;
            }
            else {
                res[idx] = nums[end] * nums[end];
                idx++;
                end++;
            }
        }

        while (start >= 0) {
            res[idx] = nums[start] * nums[start];
            idx++;
            start--;
        }

        while (end < nums.length) {
            res[idx] = nums[end] * nums[end];
            idx++;
            end++;
        }
        return res;
    }
}
