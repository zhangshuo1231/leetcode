package answers;

import java.util.Arrays;

public class Solution_132 {
    public int minCut(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int right = 0; right < s.length(); right++) {
            dp[right] = right;
            isPalindrome[right][right] = true;
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 1 || isPalindrome[left + 1][right - 1])) {
                    if (left == 0)
                        dp[right] = 0;
                    else {
                        isPalindrome[left][right] = true;
                        dp[right] = Math.min(dp[left - 1] + 1, dp[right]);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
