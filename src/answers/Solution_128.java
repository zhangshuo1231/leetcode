package answers;

import java.util.HashSet;
import java.util.Set;

public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }

        int longest = 0;

        for (int i : numbers) {
            if (!numbers.contains(i - 1)) {
                int tempLength = 1;
                int curr = i;
                while (numbers.contains(curr + 1)) {
                    curr += 1;
                    tempLength++;
                }
                longest = Math.max(longest, tempLength);
            }
        }
        return longest;
    }
}
