package answers;

public class Solution_330 {
    public int minPatches(int[] nums, int n) {
        long firstMiss = 1;
        int numAdded = 0, index = 0;
        while (firstMiss <= n) {
            if (index < nums.length && nums[index] <= firstMiss) {
                firstMiss += nums[index++];
            } else {
                firstMiss += firstMiss;
                numAdded++;
            }
        }
        return numAdded;
    }
}
