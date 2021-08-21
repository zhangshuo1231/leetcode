package answers;

public class Solution_45 {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                curEnd = curFarthest;
                jumps++;
            }
            if (curEnd >= nums.length)
                break;
        }
        return jumps;
    }
}
