package answers;

public class Solution_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i >= 1 && s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
            }
        }

        for (int l = 3; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l - 1;
                if (j < n) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j) ? true : false;
                }
            }
        }

        int max = 1;
        String res = s.substring(n - 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 >= max && dp[i][j]) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
