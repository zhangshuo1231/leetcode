package answers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_265 {
    public int minCostII(int[][] costs) {
        int n = costs[0].length;
        for (int i = 1; i < costs.length; i++) {
            int[] lowest = minIdx2(costs[i - 1]);
            for (int j = 0; j < n; j++) {
                if (j != lowest[0]) {
                    costs[i][j] = costs[i - 1][lowest[0]] + costs[i][j];
                }
                else {
                    costs[i][j] = costs[i - 1][lowest[1]] + costs[i][j];
                }
            }
        }
        int[] result = minIdx2(costs[costs.length - 1]);
        return costs[costs.length - 1][result[0]];
    }

    private int[] minIdx2 (int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        return new int[]{queue.poll()[1], queue.poll()[1]};
    }
}
