package answers;

import java.util.Arrays;

public class Solution_403 {
    public boolean canCross(int[] stones) {
        int[][] memo = new int[stones.length][stones.length];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        for (int j = 0; j < stones.length; j++) {
            memo[stones.length - 1][j] = 1;
        }

        return can_Cross(stones, 0, 0, memo) == 1;
    }
    public int can_Cross(int[] stones, int currLoc, int prevJump, int[][] memo) {
        if (memo[currLoc][prevJump] >= 0) {
            return memo[currLoc][prevJump];
        }
        for (int nextLoc = currLoc + 1; nextLoc < stones.length; nextLoc++) {
            int jump = stones[nextLoc] - stones[currLoc];
            if (jump >= prevJump - 1 && jump <= prevJump + 1) {
                if (can_Cross(stones, nextLoc, jump, memo) == 1) {
                    memo[currLoc][prevJump] = 1;
                    return 1;
                }
            }
        }
        memo[currLoc][prevJump] = 0;
        return 0;
    }
}
