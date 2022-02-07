package answers;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; ++i)
            prefixSum[i + 1] = prefixSum[i] + (long) nums[i];

        int ans = n + 1;
        Deque<Integer> slidingWindow = new LinkedList();

        for (int i = 0; i < prefixSum.length; ++i) {
            while (!slidingWindow.isEmpty() && prefixSum[i] <= prefixSum[slidingWindow.getLast()]) {
                slidingWindow.removeLast();
            }
            while (!slidingWindow.isEmpty() && prefixSum[i] >= prefixSum[slidingWindow.getFirst()] + k) {
                ans = Math.min(ans, i - slidingWindow.removeFirst());
            }
            slidingWindow.addLast(i);
        }
        return ans <= n ? ans : -1;
    }
}