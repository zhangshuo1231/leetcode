package answers;

import java.util.TreeSet;

public class Solution_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.ceiling(nums[i]) != null && Math.abs(set.ceiling(nums[i]) - nums[i]) <= t) {
                return true;
            }
            if (set.floor(nums[i]) != null && Math.abs(nums[i] - set.floor(nums[i])) <= t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
