package answers;

import java.util.TreeMap;

public class Solution_1438 {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        int max = 0;
        for (; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (left <= right && map.lastKey() - map.firstKey() > limit) {
                int abandon = nums[left];
                left++;
                map.put(abandon, map.get(abandon) - 1);
                map.remove(abandon, 0);
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
